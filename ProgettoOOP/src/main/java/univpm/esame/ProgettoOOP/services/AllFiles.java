package univpm.esame.ProgettoOOP.services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univpm.esame.ProgettoOOP.converters.Converter;
@Service
public class AllFiles {
	@Autowired
	Converter converter;
	public String getAllFiles() throws Exception{
		String url="https://api.dropboxapi.com/2/files/list_folder";
		String jsonBody="{\r\n" + "    \"path\": \"\",\r\n" + "    \"recursive\": true,\r\n"
				+ "    \"include_media_info\": true,\r\n" + "    \"include_deleted\": false,\r\n"
				+ "    \"include_has_explicit_shared_members\": true,\r\n"
				+ "    \"include_mounted_folders\": true,\r\n" + "    \"include_non_downloadable_files\": true\r\n"
				+ "}";
		JSONObject allFiles=converter.APIToJSONObject(url, jsonBody);
		
		
		return converter.JSONObjectToList(allFiles).toString();
	}
}
