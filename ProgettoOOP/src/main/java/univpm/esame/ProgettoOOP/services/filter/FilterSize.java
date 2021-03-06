package univpm.esame.ProgettoOOP.services.filter;

import java.util.ArrayList;
import java.util.Iterator;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.Model;
import univpm.esame.ProgettoOOP.model.File;
import univpm.esame.ProgettoOOP.model.Folder;
/**
 * The class filters the ArrayList by size
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public class FilterSize {
	private long param;
	private String logic;
	/**
	 * The constructor
	 * @param param The size we want to compare
	 * @param logic Can be either "greater" or "lower"
	 */
	public FilterSize(long param, String logic) {
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
				Model model=it.next();
				if ( model instanceof File) {
					File file=(File)model;
					if(!filterGreater(file.getSize())) {
						it.remove();
					}
				}else if(model instanceof Folder) {
					it.remove();
				}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}else {
			Iterator<Model> it=files.iterator();
			while(it.hasNext()){
				Model model=it.next();
				if ( model instanceof File) {
					File file=(File)model;
					if(!filterLower(file.getSize())) {
						it.remove();
					}
				}else if(model instanceof Folder) {
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
	public long getParam() {
		return param;
	}
	/**
	 * Sets the parameter
	 * @param param the parameter
	 */
	public void setParam(long param) {
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
	 * Compares the size with our parameter
	 * @param size Size we want to compare
	 * @return true if size greater than the parameter else false
	 */
	public boolean filterGreater(long size) {
		return size>=this.param;
	}
	/**
	 * Compares the size with our parameter
	 * @param size Size we want to compare
	 * @return true if size lower than the parameter else false
	 */
	public boolean filterLower(long size) {
		return size<this.param;
	}
}
