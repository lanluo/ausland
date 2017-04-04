package au.com.ausland.ausland_application.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Record{

    //http://www.oracle.com/technetwork/middleware/ias/id-generation-083058.html
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", initialValue = 1, allocationSize = 1, name = "CUST_SEQ")
    Long id;
    
    @Column(length=32)
    String sender_name; 
    
    @Column(length=108)
    String sender_address;
    
    @Column(length=32)
    String sender_company;
    
    @Column(length=12)
    Integer sender_phone;
    
    @Column(length=12)
    Integer sender_postcode;
    
    @Column(length=32)
    @NotNull
    String receiver_name;
    
    @Column(length=256)
    @NotNull
    String receiver_address;
    
    @Column(length=32)
    String receiver_company;
    
    @Column(length=12)
    @NotNull
    Integer receiver_phone;
    
    @Column(length=12)
    Integer receiver_postcode;
    
    @Column(length=32)
    String purchaser_id;
    
    @Column(length=256)
    @NotNull
    String product_name;
    
    @Column(length=32)
    @NotNull
    String courier_company;
    
    @Column(length=32)
    @NotNull
    String courier_template;
    
    @Column(length=32)
    @NotNull
    String courier_id;

    @Temporal(TemporalType.DATE)
    Date print_date;

    public Record() {
    }
  
}
