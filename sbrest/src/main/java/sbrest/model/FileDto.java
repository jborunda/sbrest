package sbrest.model;

import java.util.Date;

public class FileDto {

	private Integer fileId;
	private byte[] data;
	private String size;
	private String type;
	private String fileName;
	private Integer version;
	private Date createdOn;
	private Integer parentId;
	private String parentName;
	
	public FileDto(File f){
		fileId = f.getFileId();
		data = f.getData(); 
		size = f.getSize();
		type = f.getType();
		fileName = f.getFileName();
		version = f.getVersion();
		createdOn = f.getCreatedOn();
		if(f.getParentFolder() != null) {
			parentId = f.getParentFolder().getFolderId();
			parentName = f.getParentFolder().getFolderName();
		}
	}
	public FileDto(){
	
	}
	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
}
