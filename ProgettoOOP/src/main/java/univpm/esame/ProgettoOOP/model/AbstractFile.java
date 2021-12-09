package univpm.esame.ProgettoOOP.model;

public abstract class AbstractFile {
    //Nome del file
    protected String name;
    //Estensione del file
    protected String extension;
    //Grandezza del file
    protected long size;
    //Tipo del file
    protected String type;
    //Percorso del file all'interno di Dropbox
    protected String path;
    //Boolean per indicare se il file è condiviso o non accessibile
    protected boolean shared;

    //Costruttore della classe "File" senza parametri
	public AbstractFile() {
		this.name=null;
		this.extension=null;
		this.type=null;
        this.size = 0;
		this.path=null;
		this.shared = false;
	}
	
    //Costruttore della classe "File" con parametri
	public AbstractFile(String name, String extension, String type, long size , String path, boolean shared) {
		this.name = name;
		this.extension = extension;
		this.type = type;
        this.size = size;
		this.path = path;
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


	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}


	public boolean getShared() {
		return shared;
	}
	public void setShared(boolean shared) {
		this.shared = shared;
	}


	public long getSize() {
		return size;
	}
    public void setSize(long size) {
		this.size = size;
	}
	
    public abstract String toString();
}
