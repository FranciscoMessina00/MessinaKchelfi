package univpm.esame.ProgettoOOP.filter;

import java.util.ArrayList;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.AbstractObject;
import univpm.esame.ProgettoOOP.model.File;
import univpm.esame.ProgettoOOP.model.Folder;

public class FilterSize {
	private long param;
	private String logic;
	public FilterSize(long param, String logic) {
		this.param=param;
		this.logic=logic;
	}
	public ArrayList<AbstractObject> doFilter(ArrayList<AbstractObject> files) throws TypeNotRecognisedException{
		if (logic.equalsIgnoreCase("grater")) {
			for (int i=files.size()-1;i>=0;i--) {
				if (files.get(i) instanceof File) {
					File file=(File)files.get(i);
					if(!filterGrater(file.getSize())) {
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
					if(!filterLower(file.getSize())) {
						files.remove(i);
					}
				} else if(files.get(i) instanceof Folder) {
					files.remove(i);
				} else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		return files;
	}
	public boolean filterGrater(long size) {
		return size>=this.param;
	}
	public boolean filterLower(long size) {
		return size<this.param;
	}
}
