package univpm.esame.ProgettoOOP.file;

public abstract class FileAstratto {
    //Nome del file
    protected String nome;
    //Estensione del file
    protected String estensione;
    //Grandezza del file
    protected long grandezza;
    //Tipo del file
    protected String tipo;
    //Percorso del file all'interno di Dropbox
    protected String link;
    //Boolean per indicare se il file è condiviso o non accessibile
    protected boolean condivisione;

    //Costruttore della classe "File" senza parametri
	public FileAstratto() {
		this.nome=null;
		this.estensione=null;
		this.tipo=null;
        this.grandezza = 0;
		this.link=null;
		this.condivisione = false;
	}
	
    //Costruttore della classe "File" con parametri
	public FileAstratto(String nome, String estensione, String tipo, int grandezza , String link, boolean condivisione) {
		this.nome = nome;
		this.estensione = estensione;
		this.tipo = tipo;
        this.grandezza = grandezza;
		this.link = link;
		this.condivisione = condivisione;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

    
	public String getEstensione() {
		return estensione;
	}
	public void setEstensione(String estensione) {
		this.estensione = estensione;
	}


	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}


	public boolean getCondivisione() {
		return condivisione;
	}
	public void setCondivisione(boolean condivisione) {
		this.condivisione = condivisione;
	}


	public long getGrandezza() {
		return grandezza;
	}
    public void setGrandezza(long grandezza) {
		this.grandezza = grandezza;
	}
	
    public abstract String toString();
}
