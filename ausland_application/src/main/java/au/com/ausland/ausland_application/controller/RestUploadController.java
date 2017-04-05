package au.com.ausland.ausland_application.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import au.com.ausland.ausland_application.dao.RecordRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestUploadController {

    private final Logger logger = LoggerFactory.getLogger(RestUploadController.class);

    @Autowired
    RecordRepository recordRepositoy;
    
    //Single file upload
    @PostMapping("/api/upload")
    // If not @RestController, uncomment this
    //@ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile uploadfile) {

        if (uploadfile.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }
        int totalRows = 0; // No of rows
        int uploadedRows = 0;
		logger.debug("upload the excel file: "+uploadfile.getName());
	    try {
	         POIFSFileSystem fs = new POIFSFileSystem(uploadfile.getInputStream());
	         HSSFWorkbook wb = new HSSFWorkbook(fs);
	         HSSFSheet sheet = wb.getSheetAt(0);
	         HSSFRow row;
	         HSSFCell cell;
	
	         
	         totalRows = sheet.getPhysicalNumberOfRows();
	
	         int cols = 0; // No of columns
	         int tmp = 0;
	
	         // This trick ensures that we get the data properly even if it doesn't start from first few rows
	         for(int i = 0; i < totalRows; i++) {
	             row = sheet.getRow(i);
	             if(row != null) {
	                 tmp = sheet.getRow(i).getPhysicalNumberOfCells();
	                 if(tmp > cols) cols = tmp;
	             }
	         }
	         
	         if(cols != 16)
	         {
	        	 return new ResponseEntity("upload file name: " + uploadfile.getOriginalFilename() + "total column is " + cols + ", it is not 16 so cannot upload", 
	             		new HttpHeaders(), HttpStatus.OK);
	         }
	
	         for(int r = 0; r < totalRows; r++) {
	             row = sheet.getRow(r);
	             if(row != null) {
	                 for(int c = 0; c < cols; c++) {
	                     cell = row.getCell((short)c);
	                     if(cell != null) {
	                        
	                    	 
	                    	 
	                     	logger.debug("rows: "+r+"columns "+c+":"+cell+";");
	                     }
	                 }
	             }
	         }

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("upload file name: " + uploadfile.getOriginalFilename() + ",total rows: " + totalRows + ", Successfully uploaded rows:" + totalRows, 
        		new HttpHeaders(), HttpStatus.OK);

    }


    
}
