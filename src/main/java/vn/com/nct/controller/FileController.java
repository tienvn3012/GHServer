package vn.com.nct.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

	@RequestMapping(value="/image",method = RequestMethod.GET)
	@ResponseBody 
	public void loadVideoFile(@RequestParam String image , HttpServletResponse response) {
		String img[] = image.split(Pattern.quote(".")); 
		String subfix = img[img.length - 1];
	    try {           
	        String filePath = "D:/TienVN/GH/img/"+image;        
	        int fileSize = (int) new File(filePath).length();
	        response.setContentLength(fileSize);
	        response.setContentType("image/"+subfix);
	        FileInputStream inputStream = new FileInputStream(filePath);
	        ServletOutputStream outputStream = response.getOutputStream();
	        int value = IOUtils.copy(inputStream, outputStream);
	        System.out.println("File Size :: "+fileSize);
	        System.out.println("Copied Bytes :: "+value);
	        IOUtils.closeQuietly(inputStream);
	        IOUtils.closeQuietly(outputStream);
	        response.setStatus(HttpServletResponse.SC_OK);
	    } catch (java.io.FileNotFoundException e) {         
	        response.setStatus(HttpStatus.NOT_FOUND.value());
	    } catch (Exception e) {         
	        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    }
	}
	
}
