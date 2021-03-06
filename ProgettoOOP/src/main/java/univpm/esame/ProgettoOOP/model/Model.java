package univpm.esame.ProgettoOOP.model;
/**
 * The abstract class is defined to by extended for example by "file" or "folder"
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public abstract class Model {
    
    protected String name;
    protected String path;
	protected String tag;
	protected String id;
	protected String modification_date;
    /**
     * Constructor of the Class without parameters
     */
	public Model() {
		this.name=null;
		this.path=null;
		this.tag=null;
		this.id=null;
	}
	
    
	/**
	 * Constructor of the Class with parameters
	 * @param name Name of file
	 * @param path Dropbox path
	 * @param tag Defines the type of "object" es. "File" or "Folder"
	 * @param id Identifier of the object
	 */
	public Model(String name, String path, String tag, String id) {
		this.name = name;
		this.path = path;
		this.tag = tag;
		this.id=id;
	}
	/**
	 * Returns the object's ID
	 * @return id the object's id
	 */
	public String getId() {
		return id;
	}
	/**
	 * Sets the object's ID
	 * @param id object's id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Returns the object's name
	 * @return name object's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the object's name
	 * @param name object's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns the Dropbox path
	 * @return path Dropbox path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * Sets the Dropbox path
	 * @param path Dropbox path
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * Returns the object's tag 
	 * @return tag object's tag
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * Sets the object's tag
	 * @param tag the object's tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * toString()
	 */
    public abstract String toString();
}
