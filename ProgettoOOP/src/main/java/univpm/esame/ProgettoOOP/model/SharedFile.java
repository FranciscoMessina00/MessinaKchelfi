package univpm.esame.ProgettoOOP.model;

public class SharedFile extends AbstractFile{
	//Nel caso di file condiviso specifichiamo l'autore
	private String author;
	//Costruttore della classe "File Condiviso" senza parametri
	public SharedFile() {
		super();
		this.author=null;
	}
	//Costruttore della classe "File Condiviso" con i parametri
	public SharedFile(String name, String extension, String type, long size , String path, String author) {
		super(name, extension, type, size, path, true);
		this.author=author;
	}
	
	//Getter e Setter dell'autore
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	//Override toString
	public String toString() {
		return "File Name: "+this.name+"."+this.extension+
				"\nType: "+this.type+
				"\nSize: "+this.size+" bytes"+
				"\nPath: "+this.path+
				"\nShared: Yes"+
				"\nAuthor: "+this.author;
	}
	
}
