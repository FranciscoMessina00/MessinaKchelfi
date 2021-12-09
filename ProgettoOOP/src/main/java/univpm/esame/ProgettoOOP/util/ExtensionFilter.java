package univpm.esame.ProgettoOOP.util;

import univpm.esame.ProgettoOOP.model.AbstractFile;

public class ExtensionFilter {
    private String input;

    public ExtensionFilter (Object input) throws **{
		if (input instanceof String) 
			this.input = (String) input;
		else throw new **("L'input deve essere una parola");
		}

        public boolean doFiltro (AbstractFile){
            if (file.getExtension().equalsIgnoreCase(input))
                return true;
            else return false;
        }

    }
    
}
