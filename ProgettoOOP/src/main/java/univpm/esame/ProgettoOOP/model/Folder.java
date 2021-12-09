package univpm.esame.ProgettoOOP.model;

public class Folder extends AbstractObject{

	private String id;
	private String name;
	private String path;
	
	public Folder() {
		super();
	}
	
	public Folder(String name, String path, String id) {
		super(name, path,"Folder", id);
	}

	//Override toString
	public String toString() {
		return "Folder Name: "+this.name+
				"\nPath: "+this.path+
				"\nTag: "+this.tag+
				"\nId: "+this.id;
	}
}
