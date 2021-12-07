package univpm.esame.ProgettoOOP.file;

public class FileCondiviso extends File{
	//Nel caso di file condiviso specifichiamo l'autore
	private String autore;
	//Costruttore della classe "File" senza parametri
	public FileCondiviso() {
		super();
		this.autore=null;
	}
	//Costruttore della classe "File" con i parametri
	public FileCondiviso(String nome, String estensione, String tipo, int grandezza , String link, boolean condivisione, String autore) {
		super(nome, estensione, tipo, grandezza, link, condivisione);
		this.autore=autore;
	}
	
	//Getter e setter dell'autore
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	
	//Override toString
	public String toString() {
		return "Nome file: "+this.nome+"."+this.estensione+
				"\nTipo: "+this.tipo+
				"\nGrandezza: "+this.grandezza+" bytes"+
				"\nPath: "+this.link+
				"\nCondiviso: si"+
				"\nAutore: "+this.autore;
	}
	
}
