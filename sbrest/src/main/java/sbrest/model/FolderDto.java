package sbrest.model;

import java.util.Date;


public class FolderDto {
	private Integer folderId;
	private String folderName;
	private String parentName;
	private Integer parentId;
	private Date createdOn;
	
	public FolderDto() {}
	public FolderDto(Folder f) {
		folderId = f.getFolderId();
		folderName = f.getFolderName();
		if(f.getFolderParent() != null) {
			parentId = f.getFolderParent().getFolderId();
			parentName = f.getFolderParent().getFolderName();
	}
		
	}
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
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
