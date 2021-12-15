package univpm.esame.ProgettoOOP.controller;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import univpm.esame.ProgettoOOP.converters.AllConverters;
import univpm.esame.ProgettoOOP.model.*;
import univpm.esame.ProgettoOOP.services.AllFiles;

@RestController
public class Controller {
	@Autowired
	AllConverters allConverters;
	@Autowired
	AllFiles allFiles;
	//public Abstract file= new PrivateFile("ciccia","txt","testo",500000L,"/cartella1");
	@GetMapping("/files")
	public String seeFile() throws Exception {
		
		return allFiles.getFiles(null); //ritorna tutti i file
	}
	
	@PostMapping("/files")
	public String seeFileFiltered(
			@RequestParam(name="fullName", required = false) String fullName,
			@RequestBody(required=false) JSONObject dateFilter)
			throws Exception {
		
		return allFiles.getFiles(fullName)+dateFilter;
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
