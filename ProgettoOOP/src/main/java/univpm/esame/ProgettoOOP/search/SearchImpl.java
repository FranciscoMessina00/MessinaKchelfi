package univpm.esame.ProgettoOOP.search;

import java.util.ArrayList;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognised;
import univpm.esame.ProgettoOOP.model.*;
/**
 * This filter is specific for filtering files with jolly characters like *
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public class SearchImpl implements Search{
	/**
	 * Filters all files with certain extension e.g. "*.txt"
	 * @param allFiles array of all files
	 * @param extension the extension to filter
	 * @return all files filtered
	 * @throws TypeNotRecognised 
	 */
	public ArrayList<AbstractObject> searchByExtension(ArrayList<AbstractObject> allFiles,String extension) throws TypeNotRecognised {
		for (int i=allFiles.size()-1;i>=0;i--) {
			if (allFiles.get(i) instanceof File) {
				File file=(File)allFiles.get(i);
				if(!file.getExtension().equals(extension)) {
					allFiles.remove(i);
				}
			} else if(allFiles.get(i) instanceof Folder) {
				allFiles.remove(i);
			} else throw new TypeNotRecognised("The type isn't a File or Folder");
		}

		return allFiles;
	}
	/**
	 * Filters all files with certain name e.g. "name.*"
	 * @param allFiles array of all files
	 * @param name the name to filter
	 * @return all files filtered
	 * @throws TypeNotRecognised 
	 */
	public ArrayList<AbstractObject> searchrByName(ArrayList<AbstractObject> allFiles,String name) throws TypeNotRecognised {
		for (int i=allFiles.size()-1;i>=0;i--) {
			if (allFiles.get(i) instanceof File) {
				File file=(File)allFiles.get(i);
				if(!file.getName().contains(name)) {
					allFiles.remove(i);
				}
			}else if(allFiles.get(i) instanceof Folder) {
				allFiles.remove(i);
			}else throw new TypeNotRecognised("The type isn't a File or Folder");
		}

		return allFiles;
	}
	/**
	 * Filters all files with specific name e.g. "name.txt"
	 * @param allFiles array of all files
	 * @param fullName name+extension to filter
	 * @return all files filtered
	 */
	public ArrayList<AbstractObject> searchBoth(ArrayList<AbstractObject> allFiles,String fullName) {
		for (int i=allFiles.size()-1;i>=0;i--) {
			if (allFiles.get(i) instanceof File) {
				File file=(File)allFiles.get(i);
				if(!file.fullName().equals(fullName)) {
					allFiles.remove(i);
				}
			}else if(allFiles.get(i) instanceof Folder) {
				allFiles.remove(i);
			}
		}

		return allFiles;
	}
	
}
