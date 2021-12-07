package univpm.esame.ProgettoOOP.file;

public class FilePrivato extends File{
	//mancano i commenti qua aggiungere...
	public FilePrivato() {
		super();
	}
	
	public FilePrivato(String nome, String estensione, String tipo, int grandezza , String link, boolean condivisione) {
		super(nome, estensione, tipo, grandezza, link, condivisione);
	}
	
	//Override toString
	public String toString() {
		return "Nome file: "+this.nome+"."+this.estensione+
				"\nTipo: "+this.tipo+
				"\nGrandezza: "+this.grandezza+" bytes"+
				"\nPath: "+this.link+
				"\nCondiviso: no";
	}
	
}
