package sbrest.model.dao.jpa;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import sbrest.model.File;
import sbrest.model.Folder;
import sbrest.model.dao.FileDao;

@Repository
public class FileDaoImpl implements FileDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<File> getRootFiles() {
		String query = "select f from Files f where f.parentFolder IS NULL";
		List<File> rootFiles = entityManager.createQuery(query, File.class).getResultList();
		if (rootFiles == null) {
			return null;
		} else
			return rootFiles;
	}

	@Override
	public File getFileById(int id) {
		
		return entityManager.find(File.class, id);
		
	}

	@Override
	public List<File> getFilesByFolderId(int id) {
		System.out.println("inside getfilesfoldertid");
		System.out.println(id);
		Folder fileParent = entityManager.find(Folder.class, id);
		System.out.println(fileParent.getFolderName());
		String query = "select f from Files f where f.parentFolder IS " + fileParent;
		List<File> files = entityManager.createQuery(query, File.class).getResultList();
		
		return files;
	}

	@Override
	public File createFile(File file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteFile(Integer id) {
		// TODO Auto-generated method stub
		
	}


}
