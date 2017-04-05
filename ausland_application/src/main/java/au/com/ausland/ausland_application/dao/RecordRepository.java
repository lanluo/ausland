package au.com.ausland.ausland_application.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

import au.com.ausland.ausland_application.model.Record;


public interface RecordRepository extends CrudRepository<Record, Long> {

    Page<Record> findAll(Pageable pageable);

    List<Record> findBySendername(String sendername);
    List<Record> findBySenderaddress(String senderaddress);
    List<Record> findBySendercompany(String sendercompany);
    List<Record> findBySenderphone(Integer senderphone);
    List<Record> findBySenderpostcode(Integer senderpostcode);
    
    List<Record> findByReceivername(String receivername);
    List<Record> findByReceiveraddress(String receiveraddress);
    List<Record> findByReceivercompany(String receivercompany);
    List<Record> findByReceiverphone(Integer receiverphone);
    List<Record> findByReceiverpostcode(Integer receiverpostcode);
    
    List<Record> findByCouriercompany(String couriercompany);
    List<Record> findByCouriertemplate(String couriertemplate);
    List<Record> findByCourierid(String courierid);
    List<Record> findByPrintdate(Date printdate);
     
}