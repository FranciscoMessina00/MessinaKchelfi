package univpm.esame.ProgettoOOP.file;

public class File {
    private String nome;
	private String estensione;
    private long grandezza;
	private String tipo;
	private String link;
	private boolean condivisione;


	public File() {
		this.nome=null;
		this.estensione=null;
		this.tipo=null;
        this.grandezza = 0;
		this.link=null;
		this.condivisione = false;
	}
	
	public File(String nome, String estensione, String tipo, int grandezza , String link, boolean condivisione) {
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


	public void getLink(String link) {
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
	
}
