package univpm.esame.ProgettoOOP.util;

import univpm.esame.ProgettoOOP.file.FileAstratto;

public class FiltroEstensione {
    private String input;

    public FiltroEstensione (Object input) throws **{
		if (input instanceof String) 
			this.input = (String) input;
		else throw new **("L'input deve essere una parola");
		}

        public boolean doFiltro (FileAstratto){
            if (file.getEstensione().equalsIgnoreCase(input))
                return true;
            else return false;
        }

    }
    
}
