package au.com.ausland.ausland_application.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

import au.com.ausland.ausland_application.model.Record;

public interface RecordRepository extends CrudRepository<Record, Long> {

    Page<Record> findAll(Pageable pageable);

    List<Record> findBySender_name(String sender_name);
    List<Record> findBySender_address(String sender_address);
    List<Record> findBySender_company(String sender_company);
    List<Record> findBySender_phone(Integer sender_phone);
    List<Record> findBySender_postcode(Integer sender_postcode);
    
    List<Record> findByReceiver_name(String receiver_name);
    List<Record> findByReceiver_address(String receiver_address);
    List<Record> findByReceiver_company(String receiver_company);
    List<Record> findByReceiver_phone(Integer receiver_phone);
    List<Record> findByReceiver_postcode(Integer receiver_postcode);
    
    List<Record> findByCourier_company(String courier_company);
    List<Record> findByCourier_template(String courier_template);
    List<Record> findByCourier_id(String courier_id);
    List<Record> findByPrint_date(Date print_date);
     
}