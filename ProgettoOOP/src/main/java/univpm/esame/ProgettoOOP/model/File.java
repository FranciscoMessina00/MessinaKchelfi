package univpm.esame.ProgettoOOP.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import univpm.esame.ProgettoOOP.converters.*;
/**
 * File class that extends the abstract class AbstractObject
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public class File extends AbstractObject{
	private String extension;
	private long size;
	private boolean shared;
	private String version;
	private String url;
	private Timestamp modification_date;

	/**
	 * Constructor of the class "File" without parameters
	 */
	public File() {
		super();
		this.extension=null;
		this.size=0;
		this.shared=false;
		this.version=null;
		this.url=null;
		this.modification_date=null;
	}

	/**
	 * Constructor of the class "File" with parameters
	 * @param name String name of file
	 * @param extension	String extension of file
	 * @param size Long size of file in bytes
	 * @param path String path of file in DropBox folder
	 * @param id String identifier of file in DropBox
	 * @param shared Boolean states if the file is shared
	 * @param version String is a code that identifies the version of the file
	 */
	public File(String name, String extension, long size , String path, String id, boolean shared, String version, Timestamp modification_date) {
		super(name, path, "File", id);
		Converter converter= new Converter();
		this.url=((String)converter.APIToJSONObject("https://api.dropboxapi.com/2/files/get_temporary_link", "{\r\n    \"path\": \""+this.path+"\"\r\n}").get("link"));
		this.extension=extension;
		this.size=size;
		this.shared=shared;
		this.version=version;
		this.modification_date=modification_date;
		
	}
	/**
	 * Returns the file's extension
	 * @return extension
	 */
	public String getExtension() {
		return extension;
	}
	/**
	 * Sets the file's extension
	 * @param extension file's extension
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	/**
	 * Returns the file size
	 * @return size
	 */
	public long getSize() {
		return size;
	}
	/**
	 * Sets the file size
	 * @param size the file size
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
	 * @param shared if the file is shared
	 */
	public void setShared(boolean shared) {
		this.shared = shared;
	}
	/**
	 * Returns the file version
	 * @return version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * Sets the file's version
	 * @param version the file's version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * Returns the downloadable URL
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * Sets the downloadable URL
	 * @param url the downloadable URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getModification_Date() {
		return modification_date;
	}

	public void setModification_Date(Timestamp modification_date) {
		this.modification_date = modification_date;
	}

	/**
	 * Returns the file's full name with etension
	 * @return name+extension
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
				"\nDownload file: "+this.url+
				"\nModification date: "+this.modification_date+"\n";
	}
	/**
	 * Still to define
	 * @return null
	 */
    public static ArrayList<AbstractObject> getFile() {
        return null;
    }
	
}
