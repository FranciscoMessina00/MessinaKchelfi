package univpm.esame.ProgettoOOP.services;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import univpm.esame.ProgettoOOP.converters.Converter;
import univpm.esame.ProgettoOOP.model.AbstractObject;

public class AllFiles {
	
	public static String getAllFiles() throws Exception{
		String url="https://api.dropboxapi.com/2/files/list_folder";
		String jsonBody="{\r\n" + "    \"path\": \"\",\r\n" + "    \"recursive\": true,\r\n"
				+ "    \"include_media_info\": true,\r\n" + "    \"include_deleted\": false,\r\n"
				+ "    \"include_has_explicit_shared_members\": true,\r\n"
				+ "    \"include_mounted_folders\": true,\r\n" + "    \"include_non_downloadable_files\": true\r\n"
				+ "}";
		JSONObject allFiles=Converter.APIToJSONObject(url, jsonBody);
		
		
		return Converter.JSONObjectToList(allFiles).toString();
	}
}
