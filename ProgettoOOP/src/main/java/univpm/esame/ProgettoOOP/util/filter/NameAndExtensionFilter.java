package univpm.esame.ProgettoOOP.util.filter;

import java.util.ArrayList;

import univpm.esame.ProgettoOOP.model.*;

public class NameAndExtensionFilter {
	public static ArrayList<AbstractObject> filterByExtension(ArrayList<AbstractObject> allFiles,String extension) {
		for (int i=allFiles.size()-1;i>=0;i--) {
			if (allFiles.get(i) instanceof File) {
				File file=(File)allFiles.get(i);
				if(!file.getExtension().equals(extension)) {
					allFiles.remove(i);
				}
			} else if(allFiles.get(i) instanceof Folder) {
				allFiles.remove(i);
			}
		}

		return allFiles;
	}

	public static ArrayList<AbstractObject> filterByName(ArrayList<AbstractObject> allFiles,String name) {
		for (int i=allFiles.size()-1;i>=0;i--) {
			if (allFiles.get(i) instanceof File) {
				File file=(File)allFiles.get(i);
				if(!file.getName().equals(name)) {
					allFiles.remove(i);
				}
			}else if(allFiles.get(i) instanceof Folder) {
				allFiles.remove(i);
			}
		}

		return allFiles;
	}
	
	public static ArrayList<AbstractObject> filterBoth(ArrayList<AbstractObject> allFiles,String fullName) {
		for (int i=allFiles.size()-1;i>=0;i--) {
			if (allFiles.get(i) instanceof File) {
				File file=(File)allFiles.get(i);
				if(!file.fullName().equals(fullName)) {
					allFiles.remove(i);
				}
			}else if(allFiles.get(i) instanceof Folder) {
				allFiles.remove(i);
			}
		}

		return allFiles;
	}
	
}
