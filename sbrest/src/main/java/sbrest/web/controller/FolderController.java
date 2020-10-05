package sbrest.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import sbrest.model.*;
import sbrest.model.dao.FolderDao;

@RestController
public class FolderController {
	
	@Autowired
	private FolderDao folderDao;
	
	@GetMapping("/folders")
	public List<Folder> list( ModelMap models){
		return folderDao.getFolders();
	}
	
}
