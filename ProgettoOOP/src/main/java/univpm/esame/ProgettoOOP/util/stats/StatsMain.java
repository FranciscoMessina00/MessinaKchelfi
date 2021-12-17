package univpm.esame.ProgettoOOP.util.stats;

import java.util.ArrayList;
import univpm.esame.ProgettoOOP.model.File;

public interface StatsMain {
    public ArrayList<File> StatsType(ArrayList<File> file,String extension);
    public ArrayList<File> StatsSize(ArrayList<File> file, String size);
    public ArrayList<File> StatsShared(ArrayList<File> file,String shared);
}