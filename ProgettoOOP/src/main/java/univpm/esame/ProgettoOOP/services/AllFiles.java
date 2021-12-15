package univpm.esame.ProgettoOOP.services;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import univpm.esame.ProgettoOOP.util.filter.NameAndExtensionFilter;
import univpm.esame.ProgettoOOP.converters.Converter;
import univpm.esame.ProgettoOOP.exception.FileNotFound;
import univpm.esame.ProgettoOOP.model.*;
/**
 * The class calls the Dropbox API /list_folder and can either return all or some files
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
@Service
public class AllFiles {
	@Autowired
	Converter converter;
	/**
	 * 
	 * @param fullName file's name + extension
	 * @return allFiles
	 * @throws Exception exception
	 */
	public String getFiles(String fullName) throws Exception{
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
	public String getAllFiles(ArrayList<AbstractObject> allFilesNotFiltered) {
		return allFilesNotFiltered.toString();
	}
	/**
	 * The method filters allFiles either by their extension or name
	 * @param allFilesFiltered Arraylist of all Dropbox files
	 * @param fullName file's name + extension
	 * @return allFilesFiltered
	 * @throws FileNotFound exception for file not found
	 */
	public String getFilteredFiles(ArrayList<AbstractObject> allFilesFiltered, String fullName) throws FileNotFound {
		String[] splitName = fullName.split("\\.");
		String extension;
		String name;
		if (splitName.length != 2) {
			throw new IllegalArgumentException("Parameter not in correct format");
		}else {
			name = splitName[0];
			extension=splitName[1];
		}

		if (name.equals("*")) {
			
			allFilesFiltered=NameAndExtensionFilter.filterByExtension(allFilesFiltered,extension);
		}else if(extension.equals("*")) {
			
			allFilesFiltered=NameAndExtensionFilter.filterByName(allFilesFiltered,name);
		}else {
			
			allFilesFiltered=NameAndExtensionFilter.filterBoth(allFilesFiltered,fullName);
		}
		if (allFilesFiltered.isEmpty()) {
			throw new FileNotFound("File not found");
		}else return allFilesFiltered.toString();
	}
    public static ArrayList<AbstractObject> getAllFiles() {
        return null;
    }
}
