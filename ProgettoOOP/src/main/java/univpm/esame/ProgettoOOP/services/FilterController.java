package univpm.esame.ProgettoOOP.services;
import java.util.ArrayList;
import org.json.simple.JSONObject;

import univpm.esame.ProgettoOOP.model.AbstractObject;
import univpm.esame.ProgettoOOP.model.File; 

public class FilterController {
	
	public static ArrayList<File> FilterController(JSONObject filterBody) throws Exception{
		ArrayList<AbstractObject> rawData = File.getFile();
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

		return null;
	}
}	


