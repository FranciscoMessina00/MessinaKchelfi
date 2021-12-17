package univpm.esame.ProgettoOOP.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import univpm.esame.ProgettoOOP.converters.AllConverters;
import univpm.esame.ProgettoOOP.filter.FilterManager;
import univpm.esame.ProgettoOOP.model.AbstractObject;
import univpm.esame.ProgettoOOP.services.AllFiles;
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
	 * @throws Exception
	 */
	@GetMapping("/files")
	public ArrayList<AbstractObject> seeFile() throws Exception {

		return allFiles.getFiles(null); //ritorna tutti i file
	}

	@PostMapping("/files")
	public ArrayList<AbstractObject> seeFileFiltered(
			@RequestParam(name="fullName", required = false) String fullName,
			@RequestBody(required=false) LinkedHashMap<?,?> filterParam)
					throws Exception {
		ArrayList<AbstractObject> files=allFiles.getFiles(fullName);
		return FilterManager.getFilteredFiles(filterParam,files);
	}

	//	@GetMapping("/stats")
	//	public String seeStats() {
	//		
	//		return stats;
	//	}
	//	
	//	@PostMapping("/stats")
	//	public String statsFilter(@RequestBody(required = false) JSONObject filter) throws Exception {
	//		if (filter==null) {
	//			return stats;
	//		}else return stats.doFilter(filter);
	//		
	//	}
}
