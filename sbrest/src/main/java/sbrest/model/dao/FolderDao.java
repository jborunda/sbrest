package sbrest.model.dao;

import java.util.List;
import com.sun.istack.Nullable;
import sbrest.model.*;

public interface FolderDao {

	public List<Folder> getFolders();
	
	public List<Folder> getRootFolders();

	// returns the folder by ID
	public Folder getFolderById(int id);

	// returns sub folders
	public List<Folder> getSubFoldersById(int id);

	// returns the folder parent
	public Folder goToParent(Folder currentFolder);

	// creates a new folder and set the folder passed as the parent
	public void createFolder(String folderName, @Nullable Folder folderParent);

	
	public int DeleteFolder(Folder folder,int x);



}
