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
		HashMap<String, Object> filterMap = new HashMap<>();
		
		if (array.isEmpty()) 
			throw new Exception("The filter can't be empty");
			
		Filter filter = new Filter();
		Iterator<?> it = array.iterator();
		while(it.hasNext()) {
			filterMap = (HashMap<String, Object>)it.next();
			filterParameters = new ArrayList<>(filterMap.keySet());
			filterValues = new ArrayList<>(filterMap.values());
			
			if (filterParameters.size() == 0 || filterParameters.size() > 2)
				throw new Exception("There are no parmeters");
			if(filterParameters.size()>1 && !filterParameters.get(1).equals("oprator"))
				throw new Exception("To interlock filters use \"operator\"");
			
			filter = filterIdentification(filterParameters.get(0), filterValues.get(0));
			
			if (!flag) {
				Iterator<AbstractObject> it2 = rawData.iterator();
				while (it2.hasNext()) {
					AbstractObject file = it2.next();
					if (filter.doFilter(file) && !filteredData.contains(file))
						filteredData.add(file);
				}
			}
			else {
				Iterator<AbstractObject> it2 = filteredData.iterator();
				while (it2.hasNext()) {
					AbstractObject file = it2.next();
					if (!filter.doFilter(file))
						it2.remove();
				}
			}
			
			if(filterParameters.size()>1) {
				operator = (String)filterValues.get(1);
				if(operator.equalsIgnoreCase("and"))
					flag=true;
				else if(operator.equalsIgnoreCase("o r"))
					flag=false;
				else throw new Exception("The conditional operator must"
						+ " be \"and\"/\"or\"");
				if (!it.hasNext()) 
					throw new Exception ("After a conditional operator there must be another fillter-object ");
			}
			
		}
		
		return filteredData;
	}
	

	private static Filter filterIdentification(String filterParameter, Object filterValue)
	throws Exception{
		Filter filter = new Filter();
		
		if(filterParameter.equals("name")) {
			filter = new NameFilter(filterValue);
		}
		else if (filterParameter.equals("esxtension")) {
			filter = new ExtensionFilter(filterValue);
		}
		else if (filterParameter.equals("file_modification")) {
			filter = new FileModificationFilter(filterValue);
		}	
		else if (filterParameter.equals("jolly")) {
			filter = new NameAndExtensionFilter(filterValue);
		}		
		return filter;
	}
}