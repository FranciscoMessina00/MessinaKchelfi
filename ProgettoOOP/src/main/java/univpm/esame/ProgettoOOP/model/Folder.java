package univpm.esame.ProgettoOOP.model;
/**
 * Folder class that extends the abstract class AbstractObject
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public class Folder extends Model{
	/**
	 * Constructor of the class "Folder" without parameters
	 */
	public Folder() {
		super();
	}
	/**
	 * Constructor of the class "Folder" with parameters
	 * @param name the folder's name
	 * @param path the Dropbox path
	 * @param id the folder's id
	 */
	public Folder(String name, String path, String id) {
		super(name, path,"Folder", id);
	}
	/**
	 * Better way to display the information
	 */
	@Override
	public String toString() {
		return 	"\nFolder Name: "+this.name+
				"\nPath: "+this.path+
				"\nTag: "+this.tag+
				"\nId: "+this.id+"\n";
	}
}
