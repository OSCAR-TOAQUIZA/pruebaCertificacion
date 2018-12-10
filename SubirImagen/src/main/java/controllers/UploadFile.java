package controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import servcies.UploadFileService;



@Controller
@RequestMapping("/img")
public class UploadFile {
	
	@Autowired
	private UploadFileService srv;
	
	@GetMapping("/form")
	public String index() {
		return "img/vista";
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
		if(file.isEmpty()) {
			return new ResponseEntity<Object>("Seleccionar Imagen", HttpStatus.OK);
		}
		 try {
			srv.saveFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return new ResponseEntity<Object>("Archivo sunido correctamente", HttpStatus.OK);
	}

}
