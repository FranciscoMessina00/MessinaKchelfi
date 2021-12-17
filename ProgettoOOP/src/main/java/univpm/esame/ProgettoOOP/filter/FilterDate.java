package univpm.esame.ProgettoOOP.filter;

import java.sql.Timestamp;
import java.util.ArrayList;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.AbstractObject;
import univpm.esame.ProgettoOOP.model.File;
import univpm.esame.ProgettoOOP.model.Folder;

public class FilterDate {
	private Timestamp param;
	private String logic;
	public FilterDate(Timestamp param, String logic) {
		this.param=param;
		this.logic=logic;
	}
	public ArrayList<AbstractObject> doFilter(ArrayList<AbstractObject> files) throws TypeNotRecognisedException{
		if (logic.equalsIgnoreCase("grater")) {
			for (int i=files.size()-1;i>=0;i--) {
				if (files.get(i) instanceof File) {
					File file=(File)files.get(i);
					if(!filterGrater(file.getModification_Date())) {
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
	public boolean filterGrater(Timestamp date) {
		return date.after(param);
	}
	public boolean filterLower(Timestamp date) {
		return date.before(param);
	}
}
