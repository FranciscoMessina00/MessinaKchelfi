package univpm.esame.ProgettoOOP.search;

import java.util.ArrayList;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.AbstractObject;

public interface Search {
	public ArrayList<AbstractObject> searchByExtension(ArrayList<AbstractObject> allFiles,String extension) throws TypeNotRecognisedException;
	public ArrayList<AbstractObject> searchByName(ArrayList<AbstractObject> allFiles,String name) throws TypeNotRecognisedException;
	public ArrayList<AbstractObject> searchBoth(ArrayList<AbstractObject> allFiles,String fullName);
}
