package univpm.esame.ProgettoOOP.search;

import java.util.ArrayList;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.AbstractObject;
/**
 * This interface defines the searching methods
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public interface Search {
	/**
	 * Searches all files with certain extension e.g. "*.txt"
	 * @param allFiles array of all files
	 * @param extension the extension to filter
	 * @return all files filtered
	 * @throws TypeNotRecognisedException Exception
	 */
	public ArrayList<AbstractObject> searchByExtension(ArrayList<AbstractObject> allFiles,String extension) throws TypeNotRecognisedException;
	/**
	 * Searches all files with certain name e.g. "name.*"
	 * @param allFiles array of all files
	 * @param name the name to filter
	 * @return all files filtered
	 * @throws TypeNotRecognisedException Exception
	 */
	public ArrayList<AbstractObject> searchByName(ArrayList<AbstractObject> allFiles,String name) throws TypeNotRecognisedException;
	/**
	 * Searches all files with specific name e.g. "name.txt"
	 * @param allFiles array of all files
	 * @param fullName name+extension to filter
	 * @return all files filtered
	 * @throws TypeNotRecognisedException Exception
	 */
	public ArrayList<AbstractObject> searchBoth(ArrayList<AbstractObject> allFiles,String fullName) throws TypeNotRecognisedException;
}
