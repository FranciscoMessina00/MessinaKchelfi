package univpm.esame.ProgettoOOP.converters;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import univpm.esame.ProgettoOOP.model.AbstractObject;

public interface AllServices {
	//with API list_folder we get in return a JSON array
	public JSONArray URLToJSONArray();
	//with API get_temporary_link we get in return a JSON object
	public JSONObject URLToJSONObject();
	//this method transforms the JSON array to either File or Folder
	public JSONObject JSONArrayToObject();
	public AbstractObject JSONToObject();
	public String URLToURLDownload();
}
