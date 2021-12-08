package univpm.esame.ProgettoOOP.file;

public class FilePrivato extends FileAstratto{
	//mancano i commenti qua aggiungere...
	public FilePrivato() {
		super();
	}
	
	public FilePrivato(String nome, String estensione, String tipo, long grandezza , String link) {
		super(nome, estensione, tipo, grandezza, link, false);
	}
	
	//Override toString
	public String toString() {
		return "Nome file: "+this.nome+"."+this.estensione+
				"\r\nTipo: "+this.tipo+
				"\r\nGrandezza: "+this.grandezza+" bytes"+
				"\r\nPath: "+this.link+
				"\r\nCondiviso: no";
	}
	
}
