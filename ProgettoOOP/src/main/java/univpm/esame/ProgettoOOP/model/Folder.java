package univpm.esame.ProgettoOOP.model;

public class Folder extends AbstractObject{

	private String id;
	
	public Folder() {
		this.id = null;
	}

	
	public Folder(String name, String path, String id) {
		this.name = name;
		this.path = path;
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return null;
	}
}
