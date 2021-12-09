package univpm.esame.ProgettoOOP.model;

public class Folder extends AbstractObject{

	private String id;
	private String name;
	private String path;
	
	public Folder() {
		this.id = null;
		this.name=null;
		this.path=null;
	}
	
	public Folder(String name, String path, String id) {
		super(name, path,"Folder", id);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	//Override toString
	public String toString() {
		return "Folder Name: "+this.name+
				"\nPath: "+this.path+
				"\nTag: "+this.tag+
				"\nId: "+this.id;
	}
}
