package univpm.esame.ProgettoOOP.util.stats;

import java.util.ArrayList;
import java.util.HashMap;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.Model;


public interface StatsInterface  {
    public HashMap<String, Long> StatsType(ArrayList<Model> file) throws TypeNotRecognisedException;
    public HashMap<String, ?> StatsSize(ArrayList<Model> files) throws TypeNotRecognisedException;
} 