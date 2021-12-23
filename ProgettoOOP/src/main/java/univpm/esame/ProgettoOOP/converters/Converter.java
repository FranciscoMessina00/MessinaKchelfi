package univpm.esame.ProgettoOOP.converters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import univpm.esame.ProgettoOOP.exception.IncorrectFormatException;
import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.Model;
import univpm.esame.ProgettoOOP.model.File;
import univpm.esame.ProgettoOOP.model.Folder;
/**
 * The class implements the converters
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
@Service
public class Converter implements AllConverters{
	public JSONObject APIToJSONObject(String url, String jsonBody) {
		JSONObject obj=null;
		
		try {
			//opens the connection with Dropbox
			HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
			openConnection.setRequestMethod("POST");
			openConnection.setRequestProperty("Authorization",
					"Bearer J-sQ67BVtzkAAAAAAAAAAX9XtytfGXFsHJ0dlhwSXN1EctBfvteXazO-hDin7z4W");
			openConnection.setRequestProperty("Content-Type", "application/json");
			openConnection.setRequestProperty("Accept", "application/json");
			openConnection.setDoOutput(true);
			

			try (OutputStream os = openConnection.getOutputStream()) {
				byte[] input = jsonBody.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			InputStream in = openConnection.getInputStream();

			String data = "";
			String line = "";
			try {
				InputStreamReader inR = new InputStreamReader(in);
				BufferedReader buf = new BufferedReader(inR);

				while ((line = buf.readLine()) != null) {
					data += line;
				}
			} finally {
				in.close();
			}
			obj = (JSONObject) JSONValue.parseWithException(data);
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@SuppressWarnings("static-access")
	public ArrayList<Model> JSONObjectToList(JSONObject fullJObj) throws IncorrectFormatException, TypeNotRecognisedException {
		ArrayList<Model> allFiles=new ArrayList<Model>();
		String[] splitName;
		JSONArray jArr = (JSONArray) fullJObj.get("entries");
		JSONObject jEntries= new JSONObject();
		Timestamp date= new Timestamp(0);
		//creates the arraylist of all files
		for (int i=0; i<jArr.size();i++) {
			jEntries=(JSONObject) jArr.get(i);
			if (jEntries.get(".tag").equals("file")) {
				//split name and extension from file's full name
				splitName = (String[])((String) jEntries.get("name")).split("\\.");
				if (splitName.length != 2) {
				     throw new IncorrectFormatException("String not in correct format");
				}
				//create the time format with Timestamp
				String dataRaw=(String)jEntries.get("server_modified");
				String dataOk=dataRaw.replace("T", "\s");
				dataOk=dataOk.replace("Z", "");
				date=date.valueOf(dataOk);
				File file=new File(splitName[0], splitName[1], (long)jEntries.get("size"),(String)jEntries.get("path_lower"),(String)jEntries.get("id"),(boolean)jEntries.get("has_explicit_shared_members"),(String)jEntries.get("rev"), date);
				//creates the downloadable URL
				file.createUrl();
				allFiles.add(file);
			} else if (jEntries.get(".tag").equals("folder")) {
				Folder folder=new Folder((String)jEntries.get("name"),(String)jEntries.get("path_lower"),(String)jEntries.get("id"));
				allFiles.add(folder);
			} else throw new TypeNotRecognisedException("Type not recognised, must be File or Folder");
		}
		return allFiles;
	}


}
