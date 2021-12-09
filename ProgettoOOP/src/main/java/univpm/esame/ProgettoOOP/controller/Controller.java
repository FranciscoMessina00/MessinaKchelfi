package univpm.esame.ProgettoOOP.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import univpm.esame.ProgettoOOP.model.*;

@RestController
public class Controller {
<<<<<<< HEAD
	public AbstractFile file= new PrivateFile("ciccia","txt","testo",500000L,"/cartella1");
	@GetMapping("/files")
	public String seeFile() {
		return file.toString();
=======
	//public FileAstratto file= new FilePrivato("ciccia","txt","testo",500000L,"/cartella1");
	@GetMapping("/files")
	public String vediFile() {
		return ; //ritorna tutti i file
	}
	@GetMapping("/files/nome")
	public String vediFileSpecifico() {
		return ; //ritorna le caratteristiche del file
>>>>>>> f94c1877d9b94bdb51bd70e8c9c3865ccafac848
	}
	
}
