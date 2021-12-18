package univpm.esame.ProgettoOOP.util.stats;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

import univpm.esame.ProgettoOOP.exception.IncorrectFormatException;
import univpm.esame.ProgettoOOP.model.AbstractObject;
import univpm.esame.ProgettoOOP.model.File;


public class StatsType {

	public static <Path> File getStatsType(ArrayList<AbstractObject> path) throws IncorrectFormatException {

		AbstractObject file = new File();		
		HashMap<Path, String> folders = new HashMap<>();
		Iterator<?> it = path.iterator();

		while(it.hasNext()) {
			file = (File)it.next();

			if(file.getTag().equals("Folder")) { 
				throw new IncorrectFormatException ("I cant do this for a folder");
			}

		}
		return null;	
	}
}



