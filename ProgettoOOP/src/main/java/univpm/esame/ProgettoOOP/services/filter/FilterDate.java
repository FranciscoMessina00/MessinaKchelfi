package univpm.esame.ProgettoOOP.services.filter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.Model;
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
	public ArrayList<Model> doFilter(ArrayList<Model> files) throws TypeNotRecognisedException{
		if (logic.equalsIgnoreCase("greater")) {
			Iterator<Model> it=files.iterator();
			while(it.hasNext()){
				Model abob=it.next();
				if (abob instanceof File) {
					File file=(File)abob;
					if(!filterGreater(file.getModification_Date())) {
						it.remove();
					}
				}else if(abob instanceof Folder) {
					it.remove();
				}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}else {
			Iterator<Model> it=files.iterator();
			while(it.hasNext()){
				Model abob=it.next();
				if (abob instanceof File) {
					File file=(File)abob;
					if(!filterLower(file.getModification_Date())) {
						it.remove();
					}
				}else if(abob instanceof Folder) {
					it.remove();
				}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
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
