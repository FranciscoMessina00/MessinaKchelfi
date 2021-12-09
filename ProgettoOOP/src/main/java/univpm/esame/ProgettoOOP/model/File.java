package univpm.esame.ProgettoOOP.model;

public class File extends AbstractObject{
		
	private String extension;
	private String type;
	private long size;
	private boolean shared;

	//Costruttore della classe "File Condiviso" senza parametri
	public File() {
		super();
		this.extension=null;
		this.type=null;
		this.size=0;
		this.shared=false;
	}

	//Costruttore della classe "File Condiviso" con i parametri
	public File(String name, String extension, String type, long size , String path, String id, boolean shared) {
		super(name, path, "File", id);
		this.extension=extension;
		this.type=type;
		this.size=size;
		this.shared=shared;
	}

	//Override toString
	public String toString() {
		return "File Name: "+this.name+"."+this.extension+
				"\nType: "+this.type+
				"\nSize: "+this.size+" bytes"+
				"\nPath: "+this.path+
				"\nTag: "+this.tag+
				"\nShared: "+shared;
	}
	
}
