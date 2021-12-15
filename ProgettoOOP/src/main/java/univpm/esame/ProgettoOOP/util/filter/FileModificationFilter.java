package univpm.esame.ProgettoOOP.util.filter;

import univpm.esame.ProgettoOOP.model.File;
import univpm.esame.ProgettoOOP.util.filter_main.Filter;

public class FileModificationFilter extends Filter{
    private String input;

    public FileModificationFilter (Object input) throws Exception{
		if (input instanceof String) 
			this.input = (String) input;
		else throw new Exception("Error");
		}

       public boolean doFiltro (File file){
           if (/*(input)*/ false)     //Aggiungere Tag di ultima modifica
               return true;
           else return false;       
        }
    
}
