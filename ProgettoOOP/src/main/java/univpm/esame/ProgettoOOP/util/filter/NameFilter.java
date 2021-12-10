package univpm.esame.ProgettoOOP.util.filter;

import univpm.esame.ProgettoOOP.model.File;

public class NameFilter {
    private String input;

    public NameFilter (Object input) throws **{
		if (input instanceof String) 
			this.input = (String) input;
		else throw new **("L'input deve essere una parola");
		}

        public boolean doFilter (AbstractFile){
            if (file.getPath().toLowerCase().contains(input.toLowerCase()))
                return true;
            else return false;
        }

    
    
}
