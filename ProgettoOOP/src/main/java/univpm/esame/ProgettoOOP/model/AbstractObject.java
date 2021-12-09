package univpm.esame.ProgettoOOP.model;

public abstract class AbstractObject {
    //Name of the object
    protected String name;
    //Path of the object on Dropbox
    protected String path;
	//Tag of the object
	protected String tag;
	//Every folder or file has a id given by Dropbox
	protected String id;

    //Constructor of the Class without parameters
	public AbstractObject() {
		this.name=null;
		this.path=null;
		this.tag=null;
		this.id=null;
	}
	
    //Constructor of the Class with parameters
	public AbstractObject(String name, String path, String tag, String id) {
		this.name = name;
		this.path = path;
		this.tag = tag;
		this.id=id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
    public abstract String toString();
}
