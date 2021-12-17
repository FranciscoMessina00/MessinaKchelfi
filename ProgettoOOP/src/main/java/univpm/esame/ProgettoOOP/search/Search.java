package univpm.esame.ProgettoOOP.util.filter;

import java.util.ArrayList;

import univpm.esame.ProgettoOOP.model.AbstractObject;

public interface Filter {
	public ArrayList<AbstractObject> filterByExtension(ArrayList<AbstractObject> allFiles,String extension);
	public ArrayList<AbstractObject> filterByName(ArrayList<AbstractObject> allFiles,String name);
	public ArrayList<AbstractObject> filterBoth(ArrayList<AbstractObject> allFiles,String fullName);
}
