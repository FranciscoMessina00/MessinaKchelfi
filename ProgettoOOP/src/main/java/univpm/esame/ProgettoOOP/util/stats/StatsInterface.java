package univpm.esame.ProgettoOOP.util.stats;

import java.util.ArrayList;
import java.util.HashMap;

import univpm.esame.ProgettoOOP.exception.TypeNotRecognisedException;
import univpm.esame.ProgettoOOP.model.AbstractObject;


public interface StatsInterface  {
    public HashMap<String, Long> StatsType(ArrayList<AbstractObject> file) throws TypeNotRecognisedException;
    public HashMap<String, ?> StatsSize(ArrayList<AbstractObject> files) throws TypeNotRecognisedException;
} 