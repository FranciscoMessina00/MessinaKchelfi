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
import univpm.esame.ProgettoOOP.exception.FileNotFoundException;
import univpm.esame.ProgettoOOP.exception.FilterException;
import univpm.esame.ProgettoOOP.exception.IncorrectFormatException;
import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.Model;
import univpm.esame.ProgettoOOP.services.AllFiles;
import univpm.esame.ProgettoOOP.services.filter.FilterManager;
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
	@Autowired
	StatsManager statsManager;
	@Autowired
	FilterManager filterManager;
	/**
	 * 
	 * @return returns an ArrayList of all the files in DropBox
	 * @throws FileNotFoundException Exception
	 * @throws TypeNotRecognisedException Exception
	 * @throws IncorrectFormatException Exception
	 */
	@GetMapping("/files")
	public ArrayList<Model> seeFile() throws IncorrectFormatException, TypeNotRecognisedException, FileNotFoundException {

		return allFiles.getFiles(null); //ritorna tutti i file
	}
	/**
	 * 
	 * @param fullName represents the file's name with extension we want to search (jolly * can be used)
	 * @param filterParam represents the filter
	 * @return returns an ArrayList of all the files in DropBox filtered by modified date or/and size
	 * @throws FileNotFoundException Exception
	 * @throws TypeNotRecognisedException Exception
	 * @throws IncorrectFormatException Exception
	 * @throws FilterException Exception
	 */
	@PostMapping("/files")
	public ArrayList<Model> seeFileFiltered(
			@RequestParam(name="fullName", required = false) String fullName,
			@RequestBody(required=false) LinkedHashMap<?,?> filterParam) throws IncorrectFormatException, TypeNotRecognisedException, FileNotFoundException, FilterException 
					  {
		ArrayList<Model> files=allFiles.getFiles(fullName);
		return filterManager.getFilteredFiles(filterParam,files);
	}
	/**
	 * 
	 * @return returns the stats of all files
	 * @throws FileNotFoundException Exception
	 * @throws TypeNotRecognisedException Exception
	 * @throws IncorrectFormatException Exception
	 */
	@GetMapping("/stats")
	public HashMap<String,HashMap<String,?>> seeStats() throws IncorrectFormatException, TypeNotRecognisedException, FileNotFoundException   {
		ArrayList<Model> files=allFiles.getFiles(null);
		HashMap<String,HashMap<String,?>> stats=new HashMap<String,HashMap<String,?>>();
		stats.put("Stats type",statsManager.StatsType(files));
		stats.put("Stats size", statsManager.StatsSize(files));
		return stats;
	}
	/**
	 * 
	 * @param fullName represents the file's name with extension we want to search (jolly * can be used)
	 * @param filterParam represents the filter
	 * @return returns the stats of files filtered by modified date or/and size
	 * @throws FileNotFoundException Exception
	 * @throws TypeNotRecognisedException Exception
	 * @throws IncorrectFormatException Exception
	 * @throws FilterException Exception
	 */
	@PostMapping("/stats")
	public HashMap<String,HashMap<String,?>> statsFilter(
			@RequestParam(name="fullName", required = false) String fullName,
			@RequestBody(required=false) LinkedHashMap<?,?> filterParam) throws IncorrectFormatException, TypeNotRecognisedException, FileNotFoundException, FilterException
					  {
		ArrayList<Model> files=allFiles.getFiles(fullName);
		files=filterManager.getFilteredFiles(filterParam,files);
		HashMap<String,HashMap<String,?>> stats=new HashMap<String,HashMap<String,?>>();
		stats.put("Stats type",statsManager.StatsType(files));
		stats.put("Stats size", statsManager.StatsSize(files));
		return stats; 
	}
}
