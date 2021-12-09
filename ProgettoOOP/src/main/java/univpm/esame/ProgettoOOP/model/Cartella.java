package univpm.esame.ProgettoOOP.model;

public class Cartella {
	private String nome;
	private String path;
	private String id;
	public Cartella() {
		this.nome = null;
		this.path = null;
		this.id = null;
	}
	public Cartella(String nome, String path, String id) {
		this.nome = nome;
		this.path = path;
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
}
