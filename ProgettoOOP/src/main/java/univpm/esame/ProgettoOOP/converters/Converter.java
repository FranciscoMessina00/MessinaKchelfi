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
import univpm.esame.ProgettoOOP.model.AbstractObject;
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
	public ArrayList<AbstractObject> JSONObjectToList(JSONObject obj) throws Exception {
		ArrayList<AbstractObject> allFiles=new ArrayList<AbstractObject>();
		String[] splitName;
		JSONArray obj2 = (JSONArray) obj.get("entries");
		JSONObject obj3= new JSONObject();
		Timestamp date= new Timestamp(0);
		for (int i=0; i<obj2.size();i++) {
			obj3=(JSONObject) obj2.get(i);
			if (obj3.get(".tag").equals("file")) {
				splitName = (String[])((String) obj3.get("name")).split("\\.");
				if (splitName.length != 2) {
				     throw new IncorrectFormatException("String not in correct format");
				}
				String dataRaw=(String)obj3.get("server_modified");
				String dataOk=dataRaw.replace("T", "\s");
				dataOk=dataOk.replace("Z", "");
				date=date.valueOf(dataOk);
				AbstractObject file=new File(splitName[0], splitName[1], (long)obj3.get("size"),(String)obj3.get("path_lower"),(String)obj3.get("id"),(boolean)obj3.get("has_explicit_shared_members"),(String)obj3.get("rev"), date);
				allFiles.add(file);
			} else if (obj3.get(".tag").equals("folder")) {
				AbstractObject folder=new Folder((String)obj3.get("name"),(String)obj3.get("path_lower"),(String)obj3.get("id"));
				allFiles.add(folder);
			} else throw new TypeNotRecognisedException("Type not recognised");
		}
		return allFiles;
	}



}
