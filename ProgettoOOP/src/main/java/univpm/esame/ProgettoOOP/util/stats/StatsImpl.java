package univpm.esame.ProgettoOOP.util.stats;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import univpm.esame.ProgettoOOP.model.AbstractObject;



@Service
public class StatsImpl implements Stats {

    
    @Override
    public ArrayList<AbstractObject> StatsType(ArrayList<AbstractObject> file, String extension) {
     
        return null;
    }

    @Override
    public ArrayList<AbstractObject> StatsSize(ArrayList<AbstractObject> file, String size) {
      
        return null;
    }

    @Override
    public ArrayList<AbstractObject> StatsShared(ArrayList<AbstractObject> file, Boolean shared) {
     
        return null;
    }
}

