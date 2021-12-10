package univpm.esame.ProgettoOOP.converters;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import univpm.esame.ProgettoOOP.model.AbstractObject;

public interface AllConverters {
	//With API list_folder we get in return a JSON array
	public JSONArray APIToJSONArray();
	//With API get_temporary_link we get in return a JSON object
	public JSONObject APIToJSONObject();
	//This method transforms the JSONArray to a ArrayList<AbstractObject>
	public ArrayList<AbstractObject> JSONArrayToObject();
	//This method transforms a JSONObject to a AbstractObject;
	public AbstractObject JSONToObject();
	//This method transforms the JSONObject to a String that represents the downloadable link of a File
	public String JSONObjectToURLDownload();
}
