package sbrest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.resource.beans.internal.FallbackBeanInstanceProducer;

@Entity
@Table(name = "folders")
public class Folder implements Serializable{

	private static final long serialVersionUID = 1L;


	//Folders( folder_id(pk) , user_id(fk) , parent_id , name , access )
	@Id
	@GeneratedValue
	private Integer folderId;
	private String folderName;
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Folder folderParent;
	@GeneratedValue
	@Column(updatable = false)
	@org.hibernate.annotations.CreationTimestamp
	private Date createdOn;
	
	
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