package univpm.esame.ProgettoOOP.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import univpm.esame.ProgettoOOP.converters.AllConverters;
import univpm.esame.ProgettoOOP.model.AbstractObject;
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
		
		return allFiles.getFiles(null).toString(); //ritorna tutti i file
	}
	
	@PostMapping("/files")
	public Object seeFileFiltered(
			@RequestParam(name="fullName", required = false) String fullName,
			@RequestBody(required=false) JSONObject filterParam)
			throws Exception {
		ArrayList<AbstractObject> files=allFiles.getFiles(fullName);
		LinkedHashMap<?,?> lhash=(LinkedHashMap<?, ?>)filterParam.get("filter");
		if (filterParam==null||filterParam.get("filter")==null||lhash.size()==0) {
			return files.toString();
		}
		else {
		/*classe che riceve questa LinkedHashMap e vede il size di "filter"
		se è uno lo manda a un metodo e controlla se è size o date,
		se è size faccio il filtro con size sennò lo faccio con date
		se invece la lunghezza è 2 vuol dire che devo filtrare sia uno che
		l'altro e faccio un altro metodo che va a filtrare a seconda se
		operator è AND o OR. La classe chiamata all'inizio deve ritornare
		un ArrayList<AbstractObject> con i file filtrati.
		*/
			return lhash.containsKey("size");
			
		}
		
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
