package univpm.esame.ProgettoOOP.converters;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import univpm.esame.ProgettoOOP.model.AbstractObject;

public interface AllConverters {
	//With API get_temporary_link we get in return a JSON object
	public JSONObject APIToJSONObject(String url, String jsonBody);
	//This method transforms the JSONArray to a ArrayList<AbstractObject>
	public ArrayList<AbstractObject> JSONObjectToList(JSONObject obj) throws Exception;
}
