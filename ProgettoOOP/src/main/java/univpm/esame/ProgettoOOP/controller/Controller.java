package univpm.esame.ProgettoOOP.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import univpm.esame.ProgettoOOP.converters.AllConverters;
import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.filter.FilterManager;
import univpm.esame.ProgettoOOP.model.AbstractObject;
import univpm.esame.ProgettoOOP.services.AllFiles;
import univpm.esame.ProgettoOOP.util.stats.*;
/**
 * The class is the controller that sets the paths in localhost:8080
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
@RestController
public class Controller {
	@Autowired
	AllConverters allConverters;
	@Autowired
	AllFiles allFiles;
	/**
	 * 
	 * @return returns an ArrayList of all the files in DropBox
	 * @throws Exception Exception
	 */
	@GetMapping("/files")
	public ArrayList<AbstractObject> seeFile() throws Exception {

		return allFiles.getFiles(null); //ritorna tutti i file
	}
	/**
	 * 
	 * @param fullName represents the file's name with extension we want to search (jolly * can be used)
	 * @param filterParam represents the filter
	 * @return returns an ArrayList of all the files in DropBox filtered by modified date or/and size
	 * @throws Exception Exception
	 */
	@PostMapping("/files")
	public ArrayList<AbstractObject> seeFileFiltered(
			@RequestParam(name="fullName", required = false) String fullName,
			@RequestBody(required=false) LinkedHashMap<?,?> filterParam)
					throws Exception {
		ArrayList<AbstractObject> files=allFiles.getFiles(fullName);
		return FilterManager.getFilteredFiles(filterParam,files);
	}

		@GetMapping("/stats")
		public HashMap<String, Integer> seeStats() throws Exception {
			ArrayList<AbstractObject> files=allFiles.getFiles(null);
			return StatsManager.getStatsType(files);
		}
		
	//	@PostMapping("/stats")
	//	public String statsFilter(@RequestBody(required = false) JSONObject filter) throws Exception {
	//		if (filter==null) {
	//			return stats;
	//		}else return stats.doFilter(filter);
	//		
	//	}
}
