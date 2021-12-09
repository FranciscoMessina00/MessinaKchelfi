package univpm.esame.ProgettoOOP.model;

public abstract class AbstractObject {
    //Name of the object
    protected String name;
    //Extension of the object
    protected String extension;
    //Size of the object
    protected long size;
    //Type of the object
    protected String type;
    //Path of the object on Dropbox
    protected String path;
	//Tag of the file
	protected String tag;
    //Boolean to indicate if the object is shared or not
    protected boolean shared;

    //Constructor of the Class without parameters
	public AbstractObject() {
		this.name=null;
		this.extension=null;
		this.type=null;
        this.size = 0;
		this.path=null;
		this.tag=null;
		this.shared = false;
	}
	
    //Constructor of the Class with parameters
	public AbstractObject(String name, String extension, String type, long size , String path, String tag, boolean shared) {
		this.name = name;
		this.extension = extension;
		this.type = type;
        this.size = size;
		this.path = path;
		this.tag = tag;
		this.shared = shared;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}
    public void setSize(long size) {
		this.size = size;
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

	public boolean getShared() {
		return shared;
	}
	public void setShared(boolean shared) {
		this.shared = shared;
	}
	
    public abstract String toString();
}
