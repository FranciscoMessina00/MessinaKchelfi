package univpm.esame.ProgettoOOP.converters;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import univpm.esame.ProgettoOOP.model.AbstractObject;
/**
 * The interface defines the converters
 * @author Francisco Messina
 *
 */
public interface AllConverters {
	/**
	 * With API get_temporary_link we get in return a JSON object
	 * @param url The API url
	 * @param jsonBody The Body required for the API call
	 * @return JSONObject given by the API call
	 */
	public JSONObject APIToJSONObject(String url, String jsonBody);
	/**
	 * This method transforms the JSONArray to a ArrayList of AbstractObject
	 * @param obj The JSONObject we want to convert
	 * @return Converts the JSONObjet to a more simple ArrayList of AbstractObject
	 * @throws Exception Exception
	 */
	public ArrayList<AbstractObject> JSONObjectToList(JSONObject obj) throws Exception;
}
