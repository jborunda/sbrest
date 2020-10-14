package sbrest.model.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sbrest.model.Folder;
import sbrest.model.dao.FolderDao;

@Repository
public class FolderDaoImpl implements FolderDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Folder> getRootFolders() {
		String query = "select f from Folder f where f.folderParent IS NULL";
		List<Folder> rootFolders = entityManager.createQuery(query, Folder.class).getResultList();
		if (rootFolders == null) {
			return null;
		} else
			return rootFolders;
	}

	@Override
	public List<Folder> getFolders() {
		return entityManager.createQuery("from Folders", Folder.class).getResultList();
	}

	@Override
	public Folder getFolderById(int id) {
		return entityManager.find(Folder.class, id);
	}

	@Override
	public List<Folder> getSubFoldersById(int id) {
		String query = "select f from Folder f where f.folderParent IS " + id;
		List<Folder> subFolders = entityManager.createQuery(query, Folder.class).getResultList();
		for (Folder f : subFolders) {
			System.out.println(f);
		}
		return subFolders;
	}

	@Override
	public Folder goToParent(Folder currentFolder) {
		return entityManager.find(Folder.class, currentFolder.getFolderParent().getFolderId());
	}

	@Override
	@Transactional
	public Folder createFolder(Folder folder) {
		return entityManager.merge(folder);
	}
	
	
	
	@Override
	@Transactional
	public void DeleteSubFolders(Integer id) {
		Folder f = this.getFolderById(id);
		List<Folder> subFolders = getSubFoldersById(f.getFolderId());
		for(Folder tt : subFolders) {
			System.out.println(tt.getFolderName());
		}
		entityManager.remove(f);
		System.out.println("after remove");
		if (subFolders.size() != 0) {
			for (Folder fol : subFolders) {
				DeleteSubFolders(fol.getFolderId());
			}

		}

	}

	@Override
	@Transactional
	public void DeleteFolder(Integer id) {

		Folder f = this.getFolderById(id);

		entityManager.remove(f);
	}

}

/*
 * (20pt) List files and folders (either at the top-level or in a folder) Going
 * to do top level (20pt)Create new folder (either at the top-level or in a
 * folder). It's up to you to decide if multiple folders in a folder are allowed
 * to have the same name. (20pt) Upload a file (either at the top-level or in a
 * folder). If a file with the same name already exists in the folder, a new
 * version of the file will be created. (20pt) Download a file (either the
 * specified version or the latest version if no version number is given).
 * (30pt) Delete folder - all sub folders and files under the folder should be
 * deleted. The operation should return the total numbers of the folders and
 * files deleted. (10pt) Delete file - all versions of the file should be
 * deleted.
 */
