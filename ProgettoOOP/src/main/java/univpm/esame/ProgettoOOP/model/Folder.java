package univpm.esame.ProgettoOOP.model;

public class Folder extends AbstractObject{

	private String id;
	
	public Folder() {
		this.id = null;
	}
	
	public Folder(String id) {
		this.id = id;
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
				"\nSize: "+this.size+" bytes"+
				"\nPath: "+this.path+
				"\nTag: "+this.tag+
				"\nShared: "+shared+
				"\nId: "+this.id+
				"\nAuthor: "+this.author;
	}
}
