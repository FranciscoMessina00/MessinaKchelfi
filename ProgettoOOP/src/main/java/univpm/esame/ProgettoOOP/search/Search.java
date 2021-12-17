package univpm.esame.ProgettoOOP.search;

import java.util.ArrayList;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognised;
import univpm.esame.ProgettoOOP.model.AbstractObject;

public interface Search {
	public ArrayList<AbstractObject> filterByExtension(ArrayList<AbstractObject> allFiles,String extension) throws TypeNotRecognised;
	public ArrayList<AbstractObject> filterByName(ArrayList<AbstractObject> allFiles,String name) throws TypeNotRecognised;
	public ArrayList<AbstractObject> filterBoth(ArrayList<AbstractObject> allFiles,String fullName);
}
