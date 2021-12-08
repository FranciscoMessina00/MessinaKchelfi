package univpm.esame.ProgettoOOP.file;

public class FilePrivato extends FileAstratto{
	//mancano i commenti qua aggiungere...
	public FilePrivato() {
		super();
	}
	
	public FilePrivato(String nome, String estensione, String tipo, long grandezza , String path) {
		super(nome, estensione, tipo, grandezza, path, false);
	}
	
	//Override toString
	public String toString() {
		return "Nome file: "+this.nome+"."+this.estensione+
				"\nTipo: "+this.tipo+
				"\nGrandezza: "+this.grandezza+" bytes"+
				"\nPath: "+this.path+
				"\nCondiviso: No";
	}
	
}
