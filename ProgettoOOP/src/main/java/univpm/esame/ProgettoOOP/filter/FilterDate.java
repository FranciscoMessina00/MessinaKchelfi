package univpm.esame.ProgettoOOP.filter;

import java.sql.Timestamp;
import java.util.ArrayList;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.AbstractObject;
import univpm.esame.ProgettoOOP.model.File;
import univpm.esame.ProgettoOOP.model.Folder;
/**
 * The class filters the ArrayList by last modification date in DropBox
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public class FilterDate {
	private Timestamp param;
	private String logic;
	/**
	 * The constructor
	 * @param param Date we want to compare
	 * @param logic Can be either "greater" or "lower"
	 */
	public FilterDate(Timestamp param, String logic) {
		this.param=param;
		this.logic=logic;
	}
	/**
	 * The method filters the files
	 * @param files The files we want to filter
	 * @return The files filtered by size
	 * @throws TypeNotRecognisedException Exception
	 */
	public ArrayList<AbstractObject> doFilter(ArrayList<AbstractObject> files) throws TypeNotRecognisedException{
		if (logic.equalsIgnoreCase("greater")) {
			for (int i=files.size()-1;i>=0;i--) {
				if (files.get(i) instanceof File) {
					File file=(File)files.get(i);
					if(!filterGreater(file.getModification_Date())) {
						files.remove(i);
					}
				} else if(files.get(i) instanceof Folder) {
					files.remove(i);
				} else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}else {
			for (int i=files.size()-1;i>=0;i--) {
				if (files.get(i) instanceof File) {
					File file=(File)files.get(i);
					if(!filterLower(file.getModification_Date())) {
						files.remove(i);
					}
				} else if(files.get(i) instanceof Folder) {
					files.remove(i);
				} else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		return files;
	}
	/**
	 * Returns the parameter
	 * @return the parameter
	 */
	public Timestamp getParam() {
		return param;
	}
	/**
	 * Sets the parameter
	 * @param param the parameter
	 */
	public void setParam(Timestamp param) {
		this.param = param;
	}
	/**
	 * Returns the logic
	 * @return logic
	 */
	public String getLogic() {
		return logic;
	}
	/**
	 * Sets the logic
	 * @param logic the logic
	 */
	public void setLogic(String logic) {
		this.logic = logic;
	}
	/**
	 * Compares the dates with our parameter
	 * @param date Date we want to compare
	 * @return true if date after the parameter else false
	 */
	public boolean filterGreater(Timestamp date) {
		return date.after(param);
	}
	/**
	 * Compares the dates with our parameter
	 * @param date Date we want to compare
	 * @return true if date before the parameter else false
	 */
	public boolean filterLower(Timestamp date) {
		return date.before(param);
	}
}
