package services;

import java.io.FileWriter;
import java.io.IOException;

public class FileService {
	int auxCont = 0;
	String folderPath = "";

	public FileService(String fPath) {
		this.folderPath = fPath;
	}
	
	public String createAccountFile(String fileName, String content) {
	    String fullPath = folderPath + fileName;
	    try {
	        FileWriter writer = new FileWriter(fullPath);
	        writer.write(content);
	        writer.close();
	        System.out.println("Archivo creado EXITOSAMENTE (" + fileName + ")");
	        return fullPath;
	    } catch (IOException e) {
	        System.out.println("ERROR al crear el archivo: " + e.getMessage());
	        return "";
	    }
	}

}
