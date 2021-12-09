package univpm.esame.ProgettoOOP.model;

public class File extends AbstractObject{
		
	private String extension;
	private String type;
	private long size;
	private boolean shared;
	private String version;

	//Costruttore della classe "File" senza parametri
	public File() {
		super();
		this.extension=null;
		this.type=null;
		this.size=0;
		this.shared=false;
		this.version=null;
	}

	//Costruttore della classe "File" con i parametri
	public File(String name, String extension, String type, long size , String path, String id, boolean shared, String version) {
		super(name, path, "File", id);
		this.extension=extension;
		this.type=type;
		this.size=size;
		this.shared=shared;
		this.version=version;
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

	public boolean isShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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
