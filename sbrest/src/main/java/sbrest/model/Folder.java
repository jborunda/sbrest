package sbrest.model;

import java.util.Date;

public class Folder {
	
	private Integer folderId;
	private String folderName;
	private Folder folderParent;
	private Date createdOn;
	
	
	
	//getters and setters 
	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public Folder getFolderParent() {
		return folderParent;
	}

	public void setFolderParent(Folder folderParent) {
		this.folderParent = folderParent;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
