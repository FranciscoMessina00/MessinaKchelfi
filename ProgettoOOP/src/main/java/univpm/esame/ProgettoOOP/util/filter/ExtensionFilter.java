package univpm.esame.ProgettoOOP.util.filter;
import univpm.esame.ProgettoOOP.model.File;

public class ExtensionFilter {
    private String input;

    public ExtensionFilter (Object input){
		if (input instanceof String) 
			this.input = (String) input;
		else throw new Exception("L'input deve essere una parola");
		}

       public boolean doFiltro (File file){
           if (file.getExtension().equalsIgnoreCase(input))
               return true;
           else return false;       
        }
    }
}
