package univpm.esame.ProgettoOOP.filter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.json.simple.JSONObject;

import univpm.esame.ProgettoOOP.exception.FilterException;
import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.AbstractObject;

public class FilterManager {
	@SuppressWarnings({ "unchecked", "static-access" })
	public static Object getFilteredFiles(LinkedHashMap<?,?> filterParam, ArrayList<AbstractObject> files) throws FilterException, TypeNotRecognisedException {
		if(filterParam==null) {
			return files;
		}
		@SuppressWarnings("unchecked")
		LinkedHashMap<String,?> filter=(LinkedHashMap<String,?>)filterParam.get("filter");
		FilterSize filterSize=null;
		FilterDate filterDate=null;
		if (filter.size()==0) {
			return files;
		}else {
			if (filter.containsKey("size")) {
				@SuppressWarnings("unchecked")
				LinkedHashMap<String,?> size=(LinkedHashMap<String,?>)filter.get("size");
				String logic=(String) size.get("logic");
				if(!logic.equalsIgnoreCase("grater")&&!logic.equalsIgnoreCase("lower")) {
					throw new FilterException("Filter must contain a logic \"grater\" or \"lower\"");
				}
				long sizeFile=(int)size.get("sizeFile");
				filterSize=new FilterSize(sizeFile,logic);
				
			}
			if(filter.containsKey("date")) {
				
				Timestamp dateParam=new Timestamp(0);
				LinkedHashMap<String,?> date=(LinkedHashMap<String,?>)filter.get("date");
				String logic=(String) date.get("logic");
				if(!logic.equalsIgnoreCase("grater")&&!logic.equalsIgnoreCase("lower")) {
					throw new FilterException("Filter must contain a logic \"grater\" or \"lower\"");
				}
				//conversion from string to Timestamp
				dateParam=(Timestamp)dateParam.valueOf((String)date.get("dateParam"));
				filterDate=new FilterDate(dateParam,logic);
				
			}else throw new FilterException("Filter not recognised");
			if(filter.size()==1) {
				if (filter.containsKey("size"))return filterSize.doFilter(files);
				if (filter.containsKey("date"))return filterDate.doFilter(files);
			}else if(filter.size()==2) {
				String operator=(String)filterParam.get("operator");
				FilterBoth filterBoth=new FilterBoth(filterDate,filterSize);
				if((!filter.containsKey("size")&&!filter.containsKey("date"))||operator==null) {
					throw new FilterException("Filter in wrong format");
				}
				if(operator.equalsIgnoreCase("and")) {
					return filterBoth.doAndFilter(files);
				}else if(operator.equalsIgnoreCase("or")) {
					return filterBoth.doOrFilter(files);
				}else throw new FilterException("Wrong operator");
			}else throw new FilterException("Filter not in correct format");
			
		}
		return null;
	}
}
