package controller;

import services.FileService;
import services.FormatFilesService;

public class FileController {
	String folderPath;	
	FileService fService = null;
	FormatFilesService fFilesService = new FormatFilesService();
	
	public FileController(String fPath) {
		this.folderPath = fPath;
		this.fService = new FileService(this.folderPath);
	}	
	public void processAccountsFromJSON(String jsonFilePath) {
	    fFilesService.readAccountsAndGenerateFiles(jsonFilePath, fService);
	}
}
