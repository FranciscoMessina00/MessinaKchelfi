package univpm.esame.ProgettoOOP.file;

public class FileCondiviso extends FileAstratto{
	//Nel caso di file condiviso specifichiamo l'autore
	private String autore;
	//Costruttore della classe "File Condiviso" senza parametri
	public FileCondiviso() {
		super();
		this.autore=null;
	}
	//Costruttore della classe "File Condiviso" con i parametri
	public FileCondiviso(String nome, String estensione, String tipo, long grandezza , String path, String autore) {
		super(nome, estensione, tipo, grandezza, path, true);
		this.autore=autore;
	}
	
	//Getter e Setter dell'autore
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
				"\nPath: "+this.path+
				"\nCondiviso: Si"+
				"\nAutore: "+this.autore;
	}
	
}
