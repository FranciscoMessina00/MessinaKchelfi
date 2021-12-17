package univpm.esame.ProgettoOOP.services;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univpm.esame.ProgettoOOP.converters.Converter;
import univpm.esame.ProgettoOOP.exception.FileNotFoundException;
import univpm.esame.ProgettoOOP.exception.IncorrectFormatException;
import univpm.esame.ProgettoOOP.exception.TypeNotRecognised;
import univpm.esame.ProgettoOOP.model.*;
import univpm.esame.ProgettoOOP.search.SearchImpl;
/**
 * The class calls the Dropbox API /list_folder and can either return all or some files
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
@Service
public class AllFiles {
	@Autowired
	Converter converter;
	@Autowired
	SearchImpl searchImpl;
	/**
	 * 
	 * @param fullName file's name + extension
	 * @return allFiles
	 * @throws Exception exception
	 */
	public ArrayList<AbstractObject> getFiles(String fullName) throws Exception{
		String url="https://api.dropboxapi.com/2/files/list_folder";
		String jsonBody="{\r\n" + "    \"path\": \"\",\r\n" + "    \"recursive\": true,\r\n"
				+ "    \"include_media_info\": true,\r\n" + "    \"include_deleted\": false,\r\n"
				+ "    \"include_has_explicit_shared_members\": true,\r\n"
				+ "    \"include_mounted_folders\": true,\r\n" + "    \"include_non_downloadable_files\": true\r\n"
				+ "}";
		JSONObject files=converter.APIToJSONObject(url, jsonBody);
		ArrayList<AbstractObject> allFiles = converter.JSONObjectToList(files);
		if(fullName==null || fullName.equals("*.*")) {
			return getAllFiles(allFiles);
		}else {
			//metti tutto questo dentro un filtro chiamato search filter
			return getFilteredFiles(allFiles, fullName);
		}
	}
	/**
	 * Returns all files un-filtered
	 * @param allFilesNotFiltered all files
	 * @return allFilesNotFiltered
	 */
	public ArrayList<AbstractObject> getAllFiles(ArrayList<AbstractObject> allFilesNotFiltered) {
		return allFilesNotFiltered;
	}
	/**
	 * The method filters allFiles either by their extension or name
	 * @param allFilesFiltered Arraylist of all Dropbox files
	 * @param fullName file's name + extension
	 * @return allFilesFiltered
	 * @throws FileNotFoundException exception for file not found
	 * @throws IncorrectFormatException Not correct format
	 * @throws TypeNotRecognised 
	 */
	public ArrayList<AbstractObject> getFilteredFiles(ArrayList<AbstractObject> allFilesFiltered, String fullName) throws FileNotFoundException, IncorrectFormatException, TypeNotRecognised {
		String[] splitName = fullName.split("\\.");
		String extension;
		String name;
		if (splitName.length != 2) {
			throw new IncorrectFormatException("Not correct format");
		}else {
			name = splitName[0];
			extension=splitName[1];
		}

		if (name.equals("*")) {
			
			allFilesFiltered=searchImpl.searchByExtension(allFilesFiltered,extension);
		}else if(extension.equals("*")) {
			
			allFilesFiltered=searchImpl.searchByName(allFilesFiltered,name);
		}else {
			
			allFilesFiltered=searchImpl.searchBoth(allFilesFiltered,fullName);
		}
		if (allFilesFiltered.isEmpty()) {
			throw new FileNotFoundException("File not found");
		}else return allFilesFiltered;
	}
    public static ArrayList<AbstractObject> getAllFiles() {
        return null;
    }
}
