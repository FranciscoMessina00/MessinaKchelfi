package univpm.esame.ProgettoOOP.util.stats;

import java.util.ArrayList;
import univpm.esame.ProgettoOOP.model.AbstractObject;


public interface Stats {
    public ArrayList<AbstractObject> StatsType(ArrayList<AbstractObject> file,String extension);
    public ArrayList<AbstractObject> StatsSize(ArrayList<AbstractObject> file, String size);
    public ArrayList<AbstractObject> StatsShared(ArrayList<AbstractObject> file,Boolean shared);
}