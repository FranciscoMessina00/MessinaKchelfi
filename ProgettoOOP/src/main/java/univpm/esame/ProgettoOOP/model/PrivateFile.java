package univpm.esame.ProgettoOOP.model;

public class PrivateFile extends AbstractFile{
	//Mancano i commenti qua aggiungere...
	public PrivateFile() {
		super();
	}
	
	public PrivateFile(String name, String extension, String type, long size, String path) {
		super(name, extension, type, size, path, false);
	}
	
	//Override toString
	public String toString() {
		return "File Name: "+this.name+"."+this.extension+
				"\nType: "+this.type+
				"\nSize: "+this.size+" bytes"+
				"\nPath: "+this.path+
				"\nShared: No";
	}
	
}
