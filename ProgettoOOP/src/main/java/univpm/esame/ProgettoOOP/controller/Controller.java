package univpm.esame.ProgettoOOP.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import univpm.esame.ProgettoOOP.model.*;

@RestController
public class Controller {
	//public Abstract file= new PrivateFile("ciccia","txt","testo",500000L,"/cartella1");
	@GetMapping("/files")
	public String seeFile() {
		
		return ; //ritorna tutti i file
	}
//	@GetMapping("/files/nome")
//	public String seeSpecificFile() {
//		return ; //ritorna le caratteristiche del file
//	}
	
}
