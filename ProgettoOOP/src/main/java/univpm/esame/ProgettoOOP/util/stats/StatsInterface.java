package univpm.esame.ProgettoOOP.util.stats;

import java.util.ArrayList;
import java.util.HashMap;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.Model;
/**
 * This interface defines the stats for the application
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public interface StatsInterface  {
	/**
     * Finds all the file types and the number of files of each extension
     * @param files List of files
     * @return Stats of file type
     * @throws TypeNotRecognisedException Exception
     */
    public HashMap<String, Long> StatsType(ArrayList<Model> files) throws TypeNotRecognisedException;
    /**
     * Calculates size stats, like total size o average size
     * @param files List of files
     * @return Stats of file sizes
     * @throws TypeNotRecognisedException Exception
     */
    public HashMap<String, ?> StatsSize(ArrayList<Model> files) throws TypeNotRecognisedException;
} 