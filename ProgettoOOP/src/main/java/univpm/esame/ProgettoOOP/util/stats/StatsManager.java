package univpm.esame.ProgettoOOP.util.stats;

import java.util.HashMap;
import java.util.ArrayList;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.AbstractObject;
import univpm.esame.ProgettoOOP.model.File;
import univpm.esame.ProgettoOOP.model.Folder;


public class StatsManager implements StatsInterface {

	public HashMap<String,Integer> StatsType(ArrayList<AbstractObject> files) throws TypeNotRecognisedException {

		HashMap<String,Integer> hmap = new HashMap<>();

		for(int i=0; i<files.size()-1; i++){
			if (files.get(i) instanceof File){
				File file = (File)files.get(i);
				if(hmap.containsKey(file.getExtension())) {
					hmap.replace(file.getExtension(), hmap.get(file.getExtension())+1);
				}
				else hmap.put(file.getExtension(), 1);

			}
			else if (files.get(i) instanceof Folder){
				if(hmap.containsKey("folders")) {
					hmap.replace("folders", hmap.get("folders")+1);
				}	
				else hmap.put("folders", 1);
			}
			else throw new TypeNotRecognisedException("Type not recognised");
		}

		return hmap;
	}
	public ArrayList<AbstractObject> StatsSize(ArrayList<AbstractObject> file, long size){

	}
}



