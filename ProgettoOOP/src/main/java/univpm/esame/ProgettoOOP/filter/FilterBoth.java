package univpm.esame.ProgettoOOP.filter;

import java.util.ArrayList;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.AbstractObject;
import univpm.esame.ProgettoOOP.model.File;
import univpm.esame.ProgettoOOP.model.Folder;
/**
 * The class filters the ArrayList by size and/or modification date
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public class FilterBoth {
	private FilterDate date;
	private FilterSize size;
	/**
	 * The constructor
	 * @param filterDate Date filter
	 * @param filterSize Size filter
	 */
	public FilterBoth(FilterDate filterDate, FilterSize filterSize) {
		this.date = filterDate;
		this.size = filterSize;
	}
	/**
	 * The method filters the ArrayList by size and modification date
	 * @param files Files we want to filter
	 * @return Files filtered
	 * @throws TypeNotRecognisedException Exception
	 */
	public ArrayList<AbstractObject> doAndFilter(ArrayList<AbstractObject> files) throws TypeNotRecognisedException{
		if(size.getLogic().equals("greater")&&date.getLogic().equals("greater")) {
			for (int i=files.size()-1;i>=0;i--) {
				if (files.get(i) instanceof File) {
					File file=(File)files.get(i);
					if(!size.filterGreater(file.getSize())||!date.filterGreater(file.getModification_Date())) {
						files.remove(i);
					}
				} else if(files.get(i) instanceof Folder) {
					files.remove(i);
				} else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		if(size.getLogic().equals("lower")&&date.getLogic().equals("greater")) {
			for (int i=files.size()-1;i>=0;i--) {
				if (files.get(i) instanceof File) {
					File file=(File)files.get(i);
					if(!size.filterLower(file.getSize())||!date.filterGreater(file.getModification_Date())) {
						files.remove(i);
					}
				} else if(files.get(i) instanceof Folder) {
					files.remove(i);
				} else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		if(size.getLogic().equals("greater")&&date.getLogic().equals("lower")) {
			for (int i=files.size()-1;i>=0;i--) {
				if (files.get(i) instanceof File) {
					File file=(File)files.get(i);
					if(!size.filterGreater(file.getSize())||!date.filterLower(file.getModification_Date())) {
						files.remove(i);
					}
				} else if(files.get(i) instanceof Folder) {
					files.remove(i);
				} else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		if(size.getLogic().equals("lower")&&date.getLogic().equals("lower")) {
			for (int i=files.size()-1;i>=0;i--) {
				if (files.get(i) instanceof File) {
					File file=(File)files.get(i);
					if(!size.filterLower(file.getSize())||!date.filterLower(file.getModification_Date())) {
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
	 * The method filters the ArrayList by size or modification date
	 * @param files Files we want to filter
	 * @return Files filtered
	 * @throws TypeNotRecognisedException Exception
	 */
	public ArrayList<AbstractObject> doOrFilter(ArrayList<AbstractObject> files) throws TypeNotRecognisedException{
		if(size.getLogic().equals("greater")&&date.getLogic().equals("grater")) {
			for (int i=files.size()-1;i>=0;i--) {
				if (files.get(i) instanceof File) {
					File file=(File)files.get(i);
					if(!size.filterGreater(file.getSize())&&!date.filterGreater(file.getModification_Date())) {
						files.remove(i);
					}
				} else if(files.get(i) instanceof Folder) {
					files.remove(i);
				} else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		if(size.getLogic().equals("lower")&&date.getLogic().equals("greater")) {
			for (int i=files.size()-1;i>=0;i--) {
				if (files.get(i) instanceof File) {
					File file=(File)files.get(i);
					if(!size.filterLower(file.getSize())&&!date.filterGreater(file.getModification_Date())) {
						files.remove(i);
					}
				} else if(files.get(i) instanceof Folder) {
					files.remove(i);
				} else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		if(size.getLogic().equals("greater")&&date.getLogic().equals("lower")) {
			for (int i=files.size()-1;i>=0;i--) {
				if (files.get(i) instanceof File) {
					File file=(File)files.get(i);
					if(!size.filterGreater(file.getSize())&&!date.filterLower(file.getModification_Date())) {
						files.remove(i);
					}
				} else if(files.get(i) instanceof Folder) {
					files.remove(i);
				} else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		if(size.getLogic().equals("lower")&&date.getLogic().equals("lower")) {
			for (int i=files.size()-1;i>=0;i--) {
				if (files.get(i) instanceof File) {
					File file=(File)files.get(i);
					if(!size.filterLower(file.getSize())&&!date.filterLower(file.getModification_Date())) {
						files.remove(i);
					}
				} else if(files.get(i) instanceof Folder) {
					files.remove(i);
				} else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		return files;
	}
}
