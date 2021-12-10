package univpm.esame.ProgettoOOP.util.filter;

import univpm.esame.ProgettoOOP.model.File;
import univpm.esame.ProgettoOOP.util.filter_main.Filter;

public class ExtensionFilter extends Filter{
    private String input;

    public ExtensionFilter (Object input){
		if (input instanceof String) 
			this.input = (String) input;
		else throw new Exception("Error");
		}

       public boolean doFiltro (File file){
           if (file.getExtension().equalsIgnoreCase(input))
               return true;
           else return false;       
        }
    }
}
