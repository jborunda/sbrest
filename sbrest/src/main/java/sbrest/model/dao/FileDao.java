package sbrest.model.dao;

import java.util.List;

import sbrest.model.File;



public interface FileDao  {
	public List<File> getRootFiles();
	
	public File getFileById(int id);

	public List<File> getFilesByFolderId(int id);

	public File createFile( File file);

	public void DeleteFile(Integer id);

	
}
