package univpm.esame.ProgettoOOP.model;

public class Folder extends AbstractObject{
	
	public Folder() {
		super();
	}
	
	public Folder(String name, String path, String id) {
		super(name, path,"Folder", id);
	}

	@Override
	public String toString() {
		return 	"\nFolder Name: "+this.name+
				"\nPath: "+this.path+
				"\nTag: "+this.tag+
				"\nId: "+this.id+"\n";
	}
}
