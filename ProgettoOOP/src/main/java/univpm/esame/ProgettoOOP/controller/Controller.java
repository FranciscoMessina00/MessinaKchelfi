package univpm.esame.ProgettoOOP.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		return allFiles.getAllFiles(); //ritorna tutti i file
	}
//	@GetMapping("/files/nome")
//	public String seeSpecificFile() {
//		return ; //ritorna le caratteristiche del file
//	}
	
}
