package univpm.esame.ProgettoOOP.search;

import java.util.ArrayList;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognised;
import univpm.esame.ProgettoOOP.model.AbstractObject;

public interface Search {
	public ArrayList<AbstractObject> searchByExtension(ArrayList<AbstractObject> allFiles,String extension) throws TypeNotRecognised;
	public ArrayList<AbstractObject> searchByName(ArrayList<AbstractObject> allFiles,String name) throws TypeNotRecognised;
	public ArrayList<AbstractObject> searchBoth(ArrayList<AbstractObject> allFiles,String fullName);
}
