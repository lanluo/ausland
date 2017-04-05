package au.com.ausland.ausland_application.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

import au.com.ausland.ausland_application.model.Record;


public interface RecordRepository extends CrudRepository<Record, Long> {

    Page<Record> findAll(Pageable pageable);

    ArrayList<Record> findBySendername(String sendername);
    ArrayList<Record> findBySenderaddress(String senderaddress);
    ArrayList<Record> findBySendercompany(String sendercompany);
    ArrayList<Record> findBySenderphone(String senderphone);
    ArrayList<Record> findBySenderpostcode(String senderpostcode);
    
    ArrayList<Record> findByReceivername(String receivername);
    ArrayList<Record> findByReceiveraddress(String receiveraddress);
    ArrayList<Record> findByReceivercompany(String receivercompany);
    
    @Query("select r from Record r where r.receiverphone = :receiverphone order by r.printdate DESC")
    ArrayList<Record> findByReceiverphone(String receiverphone);
    
    ArrayList<Record> findByReceiverpostcode(String receiverpostcode);
    
    ArrayList<Record> findByCouriercompany(String couriercompany);
    ArrayList<Record> findByCouriertemplate(String couriertemplate);
    ArrayList<Record> findByCourierid(String courierid);
    ArrayList<Record> findByPrintdate(Date printdate);
  
}