package univpm.esame.ProgettoOOP.model;

import java.net.URL;
import java.util.ArrayList;

import univpm.esame.ProgettoOOP.converters.*;
/**
 * File class that extends the abstract class AbstractObject
 * @author Francisco Messina
 *
 */
public class File extends AbstractObject{
	private String extension;
	private long size;
	private boolean shared;
	private String version;
	private String url;

	/**
	 * Costruttore della classe "File" senza parametri
	 */
	public File() {
		super();
		this.extension=null;
		this.size=0;
		this.shared=false;
		this.version=null;
		this.url=null;
	}

	/**
	 * Costruttore della classe "File" con i parametri
	 * @param name String name of file
	 * @param extension	String extension of file
	 * @param size Long size of file in bytes
	 * @param path String path of file in DropBox folder
	 * @param id String identifier of file in DropBox
	 * @param shared Boolean states if the file is shared
	 * @param version String is a code that identifies the version of the file
	 */
	public File(String name, String extension, long size , String path, String id, boolean shared, String version) {
		super(name, path, "File", id);
		Converter converter= new Converter();
		this.url=((String)converter.APIToJSONObject("https://api.dropboxapi.com/2/files/get_temporary_link", "{\r\n    \"path\": \""+this.path+"\"\r\n}").get("link"));
		this.extension=extension;
		this.size=size;
		this.shared=shared;
		this.version=version;
		
	}
	/**
	 * Returns the extension of the file
	 * @return extension
	 */
	public String getExtension() {
		return extension;
	}
	/**
	 * Sets the extension of the file
	 * @return void
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	/**
	 * Returns the size of the file
	 * @return size
	 */
	public long getSize() {
		return size;
	}
	/**
	 * Sets the size of the file
	 * @return void
	 */
	public void setSize(long size) {
		this.size = size;
	}
	/**
	 * Returns if the file is shared
	 * @return shared
	 */
	public boolean isShared() {
		return shared;
	}
	/**
	 * Sets if the file is shared
	 * @return void
	 */
	public void setShared(boolean shared) {
		this.shared = shared;
	}
	/**
	 * Returns the version of the file
	 * @return extension
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * Sets the version of the file
	 * @return void
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * Returns the downloadable URL of the file
	 * @return extension
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * Sets the downloadable URL of the file
	 * @return void
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * Returns the full name of the file with etension
	 * @return name + extension
	 */
	public String fullName() {
		return this.name+"."+this.extension;
	}
	@Override
	public String toString() {
		return 	"\nFile Name: "+this.name+"."+this.extension+
				"\nExtension: "+this.extension+
				"\nSize: "+this.size+" bytes"+
				"\nPath: "+this.path+
				"\nTag: "+this.tag+
				"\nShared: "+shared+
				"\nVersion: "+this.version+
				"\nDownload file: "+this.url+"\n";
	}

    public static ArrayList<AbstractObject> getFile() {
        return null;
    }
	
}
