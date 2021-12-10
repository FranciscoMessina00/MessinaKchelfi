package univpm.esame.ProgettoOOP.model;

public class File extends AbstractObject{
	private long size;
	private boolean shared;
	private String version;

	//Costruttore della classe "File" senza parametri
	public File() {
		super();
		this.size=0;
		this.shared=false;
		this.version=null;
	}

	//Costruttore della classe "File" con i parametri
	public File(String name, long size , String path, String id, boolean shared, String version) {
		super(name, path, "File", id);
		this.size=size;
		this.shared=shared;
		this.version=version;
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
		return 	"\nFile Name: "+this.name+
				"\nSize: "+this.size+" bytes"+
				"\nPath: "+this.path+
				"\nTag: "+this.tag+
				"\nShared: "+shared+
				"\nVersion: "+this.version+"\n";
	}
	
}
