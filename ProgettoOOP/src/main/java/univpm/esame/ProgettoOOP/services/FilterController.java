package univpm.esame.ProgettoOOP.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONObject;

import univpm.esame.ProgettoOOP.model.AbstractObject;
import univpm.esame.ProgettoOOP.util.filter.ExtensionFilter;
import univpm.esame.ProgettoOOP.util.filter.FileModificationFilter;
import univpm.esame.ProgettoOOP.util.filter.NameAndExtensionFilter;
import univpm.esame.ProgettoOOP.util.filter.NameFilter;
import univpm.esame.ProgettoOOP.util.filter_main.Filter;


/**
 * The Class "FilterController" manages all the filters that can be used for the data and the stats.
 * @author Francisco Messina
 * @author Amine Kchelfi
 */

public class FilterController {
	
	/**
	 * @param filterBody 
	 * @return
	 */

	public static ArrayList<AbstractObject> filterManager(JSONObject filterBody) throws Exception {
		ArrayList<AbstractObject> rawData = AllFiles.getAllFiles();
		ArrayList<AbstractObject> filteredData = new ArrayList<>();
		ArrayList<String> filterParameters;
		ArrayList<Object> filterValues;
		ArrayList<?> array;
		Object body = (Object)filterBody.get("filter");
		if ( body instanceof ArrayList<?>)
			array = (ArrayList<?>) body;
		else 
			throw new Exception("The filter value must be an array");
		String operator="";
		boolean flag=false;
		
		
		if (array.isEmpty()) 
			throw new Exception("The filter can't be empty");
		return null;
			
	}

	private static Filter filterIdentification(String filterParameter, Object filterValue)
	throws Exception{
		Filter filter = new Filter();
		
		if(filterParameter.equals("file_modification")) {
			filter = new FileModificationFilter(filterValue);
		}	
		else if (filterParameter.equals("name")) {
			filter = new NameFilter(filterValue);
		}
		else if (filterParameter.equals("esxtension")) {
			filter = new ExtensionFilter(filterValue);
		}
		
		else if (filterParameter.equals("jolly")) {
			
		}		
		return filter;
	}
}