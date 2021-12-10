package univpm.esame.ProgettoOOP.util.filter;

import univpm.esame.ProgettoOOP.model.File;
import univpm.esame.ProgettoOOP.util.filter_main.Filter;

public class NameFilter extends Filter{
    private String input;

    public NameFilter (Object input) throws Exception{
		if (input instanceof String) 
			this.input = (String) input;
		else throw new Exception("Error");
		}

        public boolean doFilter (File file){
            if (file.getPath().toString().toLowerCase().contains(input.toLowerCase()))
                return true;
            else return false;
        }
}
