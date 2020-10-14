package sbrest.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbrest.model.FileDto;
import sbrest.model.dao.FileDao;
import sbrest.model.File;


@RestController
@RequestMapping("/files")
public class FileController {

	@Autowired
	private FileDao fileDao;
	
	
	@GetMapping("/{id}")
	public FileDto getFile(@PathVariable int id) {
		File f = fileDao.getFileById(id);
		return new FileDto(f);
	}
	// list all Files from root
	@GetMapping
	public List<FileDto> fileRoot(ModelMap models) {
		List<File> files = fileDao.getRootFiles();
		List<FileDto> dtos = new ArrayList<FileDto>();
		for (File f : files)
			dtos.add(new FileDto(f));

		return dtos;
	}
		
	//show files from a folder
	@GetMapping("folder/{id}")
	public List<FileDto> getFilesFromFolderId(@PathVariable int id){
		List<File> files = fileDao.getFilesByFolderId(id);
		for(File f : files) {
			System.out.println(f.getFileName());
		}
		List<FileDto> dtos = new ArrayList<FileDto>();
		for(File f : files) {
			dtos.add(new FileDto(f));
		}
		return dtos;
	}

}
