package sbrest.model.dao;

import java.util.List;
import sbrest.model.*;

public interface FolderDao {

	public List<Folder> getFolders();
	
	public List<Folder> getRootFolders();

	// returns the folder by ID
	public Folder getFolderById(int id);

	// returns sub folders
	public List<Folder> getSubFoldersById(int id);

	public Folder goToParent(Folder currentFolder);

	public Folder createFolder( Folder folder);

	public void DeleteFolder(Integer id);

	public void DeleteSubFolders(Integer id);

}
