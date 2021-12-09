package univpm.esame.ProgettoOOP.model;

public class File extends AbstractObject{
		
	//Costruttore della classe "File Condiviso" senza parametri
	public File() {
		super();
	}

	//Costruttore della classe "File Condiviso" con i parametri
	public File(String name, String extension, String type, long size , String path, String tag, String author, boolean shared) {
		super(name, extension, type, size, path, tag, shared, author);
	}

	//Override toString
	public String toString() {
		return "File Name: "+this.name+"."+this.extension+
				"\nType: "+this.type+
				"\nSize: "+this.size+" bytes"+
				"\nPath: "+this.path+
				"\nTag: "+this.tag+
				"\nShared: "+shared+
				"\nAuthor: "+this.author;
	}
	
}
