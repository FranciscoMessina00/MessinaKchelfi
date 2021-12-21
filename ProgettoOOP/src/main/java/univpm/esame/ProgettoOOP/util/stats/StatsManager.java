package univpm.esame.ProgettoOOP.util.stats;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import java.util.ArrayList;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.Model;
import univpm.esame.ProgettoOOP.model.File;
import univpm.esame.ProgettoOOP.model.Folder;
/**
 * The class implements the StatsInterface methods
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
@Service
public class StatsManager implements StatsInterface {

	public HashMap<String, Long> StatsType(ArrayList<Model> files) throws TypeNotRecognisedException {

		HashMap<String, Long> hmap = new HashMap<>();

		for(int i=0; i<files.size(); i++){
			if (files.get(i) instanceof File){
				File file = (File)files.get(i);
				if(hmap.containsKey(file.getExtension())) {
					hmap.replace(file.getExtension(), hmap.get(file.getExtension())+1);
				}
				else hmap.put(file.getExtension(), 1L);

			}
			else if (files.get(i) instanceof Folder){
				if(hmap.containsKey("folders")) {
					hmap.replace("folders", hmap.get("folders")+1);
				}	
				else hmap.put("folders", 1L);
			}
			else throw new TypeNotRecognisedException("Type not recognised");
		}

		return hmap;
	}

	public HashMap<String, Object> StatsSize(ArrayList<Model> files) throws TypeNotRecognisedException{
		HashMap<String, Object> hmap = new HashMap<>();
		long cont = 0L;
		hmap.put("Total size", 0L);

		for(int i=0; i<files.size(); i++){
			if (files.get(i) instanceof File){
				File file = (File)files.get(i);
				hmap.replace("Total size", (Object)((Long)hmap.get("Total size") + file.getSize()));	
			}
			else if (files.get(i) instanceof Folder){
				cont++;
			}
			else throw new TypeNotRecognisedException("Type not recognised");
		}
		//we count only the numer of files
		long totFile=files.size()-cont;
		hmap.put("Number of files", (Object)(totFile));
		hmap.put("Average size", (Object)((Long)hmap.get("Total size")/(Long)hmap.get("Number of files")));
		return hmap;
	}
}