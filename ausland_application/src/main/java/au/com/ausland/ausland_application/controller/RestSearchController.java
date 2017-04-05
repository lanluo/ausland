package au.com.ausland.ausland_application.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.ausland.ausland_application.dao.RecordRepository;
import au.com.ausland.ausland_application.model.Record;

@RestController
public class RestSearchController {

    private final Logger logger = LoggerFactory.getLogger(RestSearchController.class);

    @Autowired
    RecordRepository recordRepository;
    
    @PostMapping("/api/search")
    public ResponseEntity<?> searchFile(
             @RequestParam("receivername") String receivername, 
             @RequestParam("receiverphone") String receiverphone,
             @RequestParam("courierid") String courierid) 
    {

	    if (StringUtils.isEmpty(receivername) && StringUtils.isEmpty(receiverphone) && StringUtils.isEmpty(courierid)) 
	    {
            return new ResponseEntity("请输入收件人姓名或电话或运单号来完成搜索!", HttpStatus.OK);
        }
        
        ArrayList<Record> recordList = null;
        if(!StringUtils.isEmpty(receivername))
        {
        	recordList = recordRepository.findByReceivername(receivername);
        }
        else 
        {
        	if(!StringUtils.isEmpty(receiverphone))
            {
            	recordList = recordRepository.findByReceiverphone(receiverphone);
            }
        	else
        	{
        		if(!StringUtils.isEmpty(courierid))
                {
                	recordList = recordRepository.findByCourierid(courierid);
                } 
        	}
        }
        ObjectMapper objMapper = new ObjectMapper();
        try {
			String json = objMapper.writeValueAsString(recordList);
			logger.debug("found the record:"+json);
			return new ResponseEntity(json, 
	        		new HttpHeaders(), HttpStatus.OK); 
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return new ResponseEntity("cannot parse to json string", 
        		new HttpHeaders(), HttpStatus.OK); 
        

    }


    
}
