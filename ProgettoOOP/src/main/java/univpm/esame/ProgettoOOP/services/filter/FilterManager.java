package univpm.esame.ProgettoOOP.services.filter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import univpm.esame.ProgettoOOP.exception.FileNotFoundException;
import univpm.esame.ProgettoOOP.exception.FilterException;
import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.Model;

/**
 * The class manages the two filters, the last modification date and size filter
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
@Service
public class FilterManager {
	/**
	 * The method calls specific filters
	 * @param filterParam The filter parameters
	 * @param files The files to filter
	 * @return all the files filtered
	 * @throws FilterException Filter exception
	 * @throws TypeNotRecognisedException Type not recognised exception
	 * @throws FileNotFoundException File not found
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public ArrayList<Model> getFilteredFiles(LinkedHashMap<?,?> filterParam, ArrayList<Model> files) throws FilterException, TypeNotRecognisedException, FileNotFoundException {
		if(filterParam==null) {
			return files;
		}
		LinkedHashMap<String,?> filter=(LinkedHashMap<String,?>)filterParam.get("filter");
		FilterSize filterSize=null;
		FilterDate filterDate=null;
		ArrayList<Model> filteredFiles= new ArrayList<Model>();
		//we use a flag to see if we have at least 1 filter
		boolean flag=false;
		if (filter.size()==0) {
			return files;
		}else {
			if (filter.containsKey("size")) {
				flag=true;
				LinkedHashMap<String,?> size=(LinkedHashMap<String,?>)filter.get("size");
				String logic=(String) size.get("logic");
				if(!logic.equalsIgnoreCase("greater")&&!logic.equalsIgnoreCase("lower")) {
					throw new FilterException("Filter must contain a logic \"greater\" or \"lower\"");
				}
				long sizeFile=(int)size.get("sizeFile");
				filterSize=new FilterSize(sizeFile,logic);

			}
			if(filter.containsKey("date")) {
				flag=true;
				Timestamp dateParam=new Timestamp(0);
				LinkedHashMap<String,?> date=(LinkedHashMap<String,?>)filter.get("date");
				String logic=(String) date.get("logic");
				if(!logic.equalsIgnoreCase("greater")&&!logic.equalsIgnoreCase("lower")) {
					throw new FilterException("Filter must contain a logic \"greater\" or \"lower\"");
				}
				//conversion from string to Timestamp
				dateParam=(Timestamp)dateParam.valueOf((String)date.get("dateParam"));
				filterDate=new FilterDate(dateParam,logic);

			}
			if (!flag) throw new FilterException("Filter not recognised");
			if(filter.size()==1) {
				if (filter.containsKey("size"))filteredFiles= filterSize.doFilter(files);
				if (filter.containsKey("date"))filteredFiles= filterDate.doFilter(files);
			}else if(filter.size()==2) {
				String operator=(String)filterParam.get("operator");
				FilterBoth filterBoth=new FilterBoth(filterDate,filterSize);
				if((!filter.containsKey("size")&&!filter.containsKey("date"))||operator==null) {
					throw new FilterException("Filter in wrong format");
				}
				if(operator.equalsIgnoreCase("and")) {
					filteredFiles= filterBoth.doAndFilter(files);
				}else if(operator.equalsIgnoreCase("or")) {
					filteredFiles= filterBoth.doOrFilter(files);
				}else throw new FilterException("Wrong operator");
			}else throw new FilterException("Filter not in correct format");

		}
		if(filteredFiles.isEmpty()) throw new FileNotFoundException("Files not found");
		return filteredFiles;
	}
}
