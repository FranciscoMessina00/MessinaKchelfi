package univpm.esame.ProgettoOOP.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import univpm.esame.ProgettoOOP.file.*;

@RestController
public class Controller {
	public FileAstratto file= new FilePrivato("ciccia","txt","testo",500000L,"/cartella1");
	@GetMapping("/files")
	public String vediFile() {
		return file.toString();
	}
	
	
}
