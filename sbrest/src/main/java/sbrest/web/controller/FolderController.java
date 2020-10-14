package sbrest.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.spi.ThrowableProxyVO;
import sbrest.model.*;
import sbrest.model.dao.FolderDao;

@RestController
@RequestMapping("/folders")
public class FolderController {

	@Autowired
	private FolderDao folderDao;
	//list all folders from root
	@GetMapping
	public List<FolderDto> folderRoot(ModelMap models) {
		List<Folder> folders = folderDao.getRootFolders();
		List<FolderDto> dtos = new ArrayList<FolderDto>();
		for (Folder f : folders)
			dtos.add(new FolderDto(f));

		return dtos;
	}

	@GetMapping("/{id}")
	public FolderDto getFolder(@PathVariable int id) {
		Folder folder = folderDao.getFolderById(id);
		FolderDto dto = new FolderDto(folder);

		return dto;
	}
	//add a folder to the root
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public FolderDto add(@RequestBody FolderDto dto) {
		Folder folder = new Folder();
		folder.setFolderName(dto.getFolderName());
		
		folder = folderDao.createFolder(folder);
		return new FolderDto(folder);
	}
	
	//Create a new folder in an existing folder
	@PostMapping("/add/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public FolderDto addToFolder(@RequestBody FolderDto dto, @PathVariable int id ) {
		
		Folder folder = new Folder();
		Folder parent = folderDao.getFolderById(id);
		if(parent != null) {
			folder.setFolderParent(parent);
		}
		folder.setFolderName(dto.getFolderName());
		folder = folderDao.createFolder(folder);
		return new FolderDto(folder);
	}
	//done
	// List sub folders of specific folder by id
	@GetMapping("/{id}/folders")
	public List<FolderDto> subFolders(@PathVariable int id) {
		List<Folder> f = folderDao.getSubFoldersById(id);
		List<FolderDto> dto = new ArrayList<FolderDto>();
		for (Folder fol : f) {
			dto.add(new FolderDto(fol));
		}
		return dto;
	}

	// removes folder by id and removes sub folders  
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		try {
			folderDao.DeleteFolder(id);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "deleted folder id : "+id;
	}
	
	

}
