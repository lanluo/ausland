package au.com.ausland.ausland_application.controller;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import au.com.ausland.ausland_application.dao.RecordRepository;
import au.com.ausland.ausland_application.model.Record;

@RestController
public class RestUploadController {

    private final Logger logger = LoggerFactory.getLogger(RestUploadController.class);

    @Autowired
    RecordRepository recordRepository;
    
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
		POIFSFileSystem fs = null;
		HSSFWorkbook wb = null;
	    try {
	         fs = new POIFSFileSystem(uploadfile.getInputStream());
	         wb = new HSSFWorkbook(fs);
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
	        	 return new ResponseEntity("upload file name: " + uploadfile.getOriginalFilename() + "total column is " + cols + ", it is not 16 columns so cannot be uploaded.", 
	             		new HttpHeaders(), HttpStatus.OK);
	         }
	
	         for(int r = 0; r < totalRows; r++) 
	         {
	        	 try
	        	 {
	        		 row = sheet.getRow(r);
		             
		             if(row != null) {
		            	 Record record = new Record();
	                     if(row.getCell(0) != null)
	                     {
	                    	 record.setSendername(row.getCell(0).getStringCellValue());
	                     }
	                     if(row.getCell(1) != null)
	                     {
	                    	 record.setSenderaddress(row.getCell(1).getStringCellValue());
	                     }
	                     if(row.getCell(2) != null)
	                     {
	                    	 record.setSendercompany(row.getCell(2).getStringCellValue());
	                     }
	                     if(row.getCell(3) != null)
	                     {
	                    	 record.setSenderphone(row.getCell(3).getStringCellValue());
	                     }
	                     if(row.getCell(4) != null)
	                     {
	                    	 record.setSenderpostcode(row.getCell(4).getStringCellValue()); 
	                     }
	                     if(row.getCell(5) != null)
	                     {
	                    	 record.setReceivername(row.getCell(5).getStringCellValue());
	                     }
	                     if(row.getCell(6) != null)
	                     {
	                    	 record.setReceiveraddress(row.getCell(6).getStringCellValue());
	                     }
	                     if(row.getCell(7) != null)
	                     {
	                    	 record.setReceivercompany(row.getCell(7).getStringCellValue());
	                     }
	                     if(row.getCell(8) != null)
	                     {
	                    	 record.setReceiverphone(row.getCell(8).getStringCellValue());
	                     }
	                     if(row.getCell(9) != null)
	                     {
	                    	 record.setReceiverpostcode(row.getCell(9).getStringCellValue());
	                     }
	                     if(row.getCell(10) != null)
	                     {
	                    	 record.setPurchaserid(row.getCell(10).getStringCellValue());
	                     }
	                     if(row.getCell(11) != null)
	                     {
	                    	 record.setProductname(row.getCell(11).getStringCellValue());
	                     }
	                     if(row.getCell(12) != null)
	                     {
	                    	 record.setCouriercompany(row.getCell(12).getStringCellValue());
	                     }
	                     if(row.getCell(13) != null)
	                     {
	                    	 record.setCouriertemplate(row.getCell(13).getStringCellValue());
	                     }
	                     if(row.getCell(14) != null)
	                     {
	                    	 record.setCourierid(row.getCell(14).getStringCellValue());
	                     }
	                     if(row.getCell(15) != null)
	                     {
	                    	 record.setPrintdate(row.getCell(15).getDateCellValue());
	                     }
	                     logger.debug("uploaded record: "+record.toString());
	                     recordRepository.save(record);
	                     uploadedRows ++;
	                     logger.debug("saved record: "+record.toString());
		             }
	        	 }
	        	 catch(Exception e)
	        	 {
	        		 logger.debug("caught exception during upload the excel file"+ 
	        	 uploadfile.getOriginalFilename() + ": process the row "+ r + ", exception: " + e.getMessage());
	        		 continue;
	        	 }
	             
	         }

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
	    finally
	    {
	    	if(wb != null)
	    	{
	    		try {
					wb.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(fs != null)
	    	{
	    		try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    }

        return new ResponseEntity("upload file name: " + uploadfile.getOriginalFilename() + ",total rows: " + totalRows + ", Successfully uploaded rows:" + uploadedRows, 
        		new HttpHeaders(), HttpStatus.OK);

    }


    
}
