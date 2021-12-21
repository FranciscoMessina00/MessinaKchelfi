package univpm.esame.ProgettoOOP.util.stats;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

import univpm.esame.ProgettoOOP.exception.IncorrectFormatException;
import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.AbstractObject;
import univpm.esame.ProgettoOOP.model.File;
import univpm.esame.ProgettoOOP.model.Folder;


public class StatsType {

	public static HashMap<String,Integer> getStatsType(ArrayList<AbstractObject> files) throws IncorrectFormatException {
		
		HashMap<String,Integer> hmap = new HashMap<>();
		Iterator<?> it = files.iterator();
		while (it.hasNext()){
			if (it.next() instanceof File){
				File file = (File)it.next();
				if(hmap.containsKey(file.getExtension())) {
					hmap.replace(file.getExtension(), hmap.get(file.getExtension())+1);
				}else hmap.put(file.getExtension(), 1);

			}
			else if (it.next() instanceof Folder){
				if(hmap.containsKey("Folders")) {
					hmap.replace("Folders", hmap.get("Folders")+1);
				}else hmap.put("Folders", 1);
			}
			else throw TypeNotRecognisedException("The type is not recognised");

		}
	}
}



