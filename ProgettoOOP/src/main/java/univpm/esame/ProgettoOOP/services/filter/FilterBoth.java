package univpm.esame.ProgettoOOP.services.filter;

import java.util.ArrayList;
import java.util.Iterator;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.Model;
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
	public ArrayList<Model> doAndFilter(ArrayList<Model> files) throws TypeNotRecognisedException{
		if(size.getLogic().equals("greater")&&date.getLogic().equals("greater")) {
			Iterator<Model> it=files.iterator();
			while(it.hasNext()){
				Model model=it.next();
				if ( model instanceof File) {
					File file=(File)model;
					if(!size.filterGreater(file.getSize())||!date.filterGreater(file.getModification_Date())) {
						it.remove();
					}
				}else if(model instanceof Folder) {
					it.remove();
				}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		if(size.getLogic().equals("lower")&&date.getLogic().equals("greater")) {
			Iterator<Model> it=files.iterator();
			while(it.hasNext()){
				Model model=it.next();
				if ( model instanceof File) {
					File file=(File)model;
					if(!size.filterLower(file.getSize())||!date.filterGreater(file.getModification_Date())) {
						it.remove();
					}
				}else if(model instanceof Folder) {
					it.remove();
				}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		if(size.getLogic().equals("greater")&&date.getLogic().equals("lower")) {
			Iterator<Model> it=files.iterator();
			while(it.hasNext()){
				Model abob=it.next();
				if ( abob instanceof File) {
					File file=(File)abob;
					if(!size.filterGreater(file.getSize())||!date.filterLower(file.getModification_Date())) {
						it.remove();
					}
				}else if(abob instanceof Folder) {
					it.remove();
				}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		if(size.getLogic().equals("lower")&&date.getLogic().equals("lower")) {
			Iterator<Model> it=files.iterator();
			while(it.hasNext()){
				Model model=it.next();
				if ( model instanceof File) {
					File file=(File)model;
					if(!size.filterLower(file.getSize())||!date.filterLower(file.getModification_Date())) {
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
	 * The method filters the ArrayList by size or modification date
	 * @param files Files we want to filter
	 * @return Files filtered
	 * @throws TypeNotRecognisedException Exception
	 */
	public ArrayList<Model> doOrFilter(ArrayList<Model> files) throws TypeNotRecognisedException{
		if(size.getLogic().equals("greater")&&date.getLogic().equals("greater")) {
			Iterator<Model> it=files.iterator();
			while(it.hasNext()){
				Model model=it.next();
				if ( model instanceof File) {
					File file=(File)model;
					if(!size.filterGreater(file.getSize())&&!date.filterGreater(file.getModification_Date())) {
						it.remove();
					}
				}else if(model instanceof Folder) {
					it.remove();
				}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		if(size.getLogic().equals("lower")&&date.getLogic().equals("greater")) {
			Iterator<Model> it=files.iterator();
			while(it.hasNext()){
				Model model=it.next();
				if ( model instanceof File) {
					File file=(File)model;
					if(!size.filterLower(file.getSize())&&!date.filterGreater(file.getModification_Date())) {
						it.remove();
					}
				}else if(model instanceof Folder) {
					it.remove();
				}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		if(size.getLogic().equals("greater")&&date.getLogic().equals("lower")) {
			Iterator<Model> it=files.iterator();
			while(it.hasNext()){
				Model model=it.next();
				if ( model instanceof File) {
					File file=(File)model;
					if(!size.filterGreater(file.getSize())&&!date.filterLower(file.getModification_Date())) {
						it.remove();
					}
				}else if(model instanceof Folder) {
					it.remove();
				}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		if(size.getLogic().equals("lower")&&date.getLogic().equals("lower")) {
			Iterator<Model> it=files.iterator();
			while(it.hasNext()){
				Model model=it.next();
				if ( model instanceof File) {
					File file=(File)model;
					if(!size.filterLower(file.getSize())&&!date.filterLower(file.getModification_Date())) {
						it.remove();
					}
				}else if(model instanceof Folder) {
					it.remove();
				}else throw new TypeNotRecognisedException("The type isn't a File or Folder");
			}
		}
		return files;
	}
}
