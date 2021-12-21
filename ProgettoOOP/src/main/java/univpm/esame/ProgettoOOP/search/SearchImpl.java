package univpm.esame.ProgettoOOP.search;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.*;
/**
 * This search class is specific for searchig files with jolly characters like *
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
@Service
public class SearchImpl implements Search{
	/**
	 * Filters all files with certain extension e.g. "*.txt"
	 * @param allFiles array of all files
	 * @param extension the extension to filter
	 * @return all files filtered
	 * @throws TypeNotRecognisedException Exception
	 */
	public ArrayList<Model> searchByExtension(ArrayList<Model> allFiles,String extension) throws TypeNotRecognisedException {
		Iterator<Model> it=allFiles.iterator();
		while(it.hasNext()){
			Model abob=it.next();
			if ( abob instanceof File) {
				File file=(File)abob;
				if(!file.getExtension().equals(extension)) {
					it.remove();
				}
			}else if(abob instanceof Folder) {
				it.remove();
			}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
		}

		return allFiles;
	}
	/**
	 * Filters all files with certain name e.g. "name.*"
	 * @param allFiles array of all files
	 * @param name the name to filter
	 * @return all files filtered
	 * @throws TypeNotRecognisedException Exception
	 */
	public ArrayList<Model> searchByName(ArrayList<Model> allFiles,String name) throws TypeNotRecognisedException {
		Iterator<Model> it=allFiles.iterator();
		while(it.hasNext()){
			Model abob=it.next();
			if ( abob instanceof File) {
				File file=(File)abob;
				if(!file.getName().contains(name)) {
					it.remove();
				}
			}else if(abob instanceof Folder) {
				it.remove();
			}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
		}


		return allFiles;
	}
	/**
	 * Filters all files with specific name e.g. "name.txt"
	 * @param allFiles array of all files
	 * @param fullName name+extension to filter
	 * @return all files filtered
	 * @throws TypeNotRecognisedException Exception
	 */
	public ArrayList<Model> searchBoth(ArrayList<Model> allFiles,String fullName) throws TypeNotRecognisedException {
		Iterator<Model> it=allFiles.iterator();
		while(it.hasNext()){
			Model abob=it.next();
			if ( abob instanceof File) {
				File file=(File)abob;
				if(!file.fullName().equals(fullName)) {
					it.remove();
				}
			}else if(abob instanceof Folder) {
				it.remove();
			}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
		}

		return allFiles;
	}

}
