package univpm.esame.ProgettoOOP.model;

public class File extends AbstractObject{
	private String extension;
	private long size;
	private boolean shared;
	private String version;

	//Costruttore della classe "File" senza parametri
	public File() {
		super();
		this.extension=null;
		this.size=0;
		this.shared=false;
		this.version=null;
	}

	//Costruttore della classe "File" con i parametri
	public File(String name, String extension, long size , String path, String id, boolean shared, String version) {
		super(name, path, "File", id);
		this.extension=extension;
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

	@Override
	public String toString() {
		return 	"\nFile Name: "+this.name+"."+this.extension+
				"\nExtension: "+this.extension+
				"\nSize: "+this.size+" bytes"+
				"\nPath: "+this.path+
				"\nTag: "+this.tag+
				"\nShared: "+shared+
				"\nVersion: "+this.version+"\n";
	}
	
}
