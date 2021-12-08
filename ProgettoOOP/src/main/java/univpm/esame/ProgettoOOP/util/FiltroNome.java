package univpm.esame.ProgettoOOP.util;

import univpm.esame.ProgettoOOP.file.FileAstratto;

public class FiltroNome {
    private String input;

    public FiltroNome (Object input) throws **{
		if (input instanceof String) 
			this.input = (String) input;
		else throw new **("L'input deve essere una parola");
		}

        public boolean doFiltro (FileAstratto){
            if (file.getPath().toLowerCase().contains(input.toLowerCase()))
                return true;
            else return false;
        }

    }
    
}
