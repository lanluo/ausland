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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSender_name() {
		return sender_name;
	}

	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}

	public String getSender_address() {
		return sender_address;
	}

	public void setSender_address(String sender_address) {
		this.sender_address = sender_address;
	}

	public String getSender_company() {
		return sender_company;
	}

	public void setSender_company(String sender_company) {
		this.sender_company = sender_company;
	}

	public Integer getSender_phone() {
		return sender_phone;
	}

	public void setSender_phone(Integer sender_phone) {
		this.sender_phone = sender_phone;
	}

	public Integer getSender_postcode() {
		return sender_postcode;
	}

	public void setSender_postcode(Integer sender_postcode) {
		this.sender_postcode = sender_postcode;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getReceiver_address() {
		return receiver_address;
	}

	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}

	public String getReceiver_company() {
		return receiver_company;
	}

	public void setReceiver_company(String receiver_company) {
		this.receiver_company = receiver_company;
	}

	public Integer getReceiver_phone() {
		return receiver_phone;
	}

	public void setReceiver_phone(Integer receiver_phone) {
		this.receiver_phone = receiver_phone;
	}

	public Integer getReceiver_postcode() {
		return receiver_postcode;
	}

	public void setReceiver_postcode(Integer receiver_postcode) {
		this.receiver_postcode = receiver_postcode;
	}

	public String getPurchaser_id() {
		return purchaser_id;
	}

	public void setPurchaser_id(String purchaser_id) {
		this.purchaser_id = purchaser_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCourier_company() {
		return courier_company;
	}

	public void setCourier_company(String courier_company) {
		this.courier_company = courier_company;
	}

	public String getCourier_template() {
		return courier_template;
	}

	public void setCourier_template(String courier_template) {
		this.courier_template = courier_template;
	}

	public String getCourier_id() {
		return courier_id;
	}

	public void setCourier_id(String courier_id) {
		this.courier_id = courier_id;
	}

	public Date getPrint_date() {
		return print_date;
	}

	public void setPrint_date(Date print_date) {
		this.print_date = print_date;
	}

	public Record(String sender_name, String sender_address, String sender_company, Integer sender_phone,
			Integer sender_postcode, String receiver_name, String receiver_address, String receiver_company,
			Integer receiver_phone, Integer receiver_postcode, String purchaser_id, String product_name,
			String courier_company, String courier_template, String courier_id, Date print_date) {
		super();
		this.sender_name = sender_name;
		this.sender_address = sender_address;
		this.sender_company = sender_company;
		this.sender_phone = sender_phone;
		this.sender_postcode = sender_postcode;
		this.receiver_name = receiver_name;
		this.receiver_address = receiver_address;
		this.receiver_company = receiver_company;
		this.receiver_phone = receiver_phone;
		this.receiver_postcode = receiver_postcode;
		this.purchaser_id = purchaser_id;
		this.product_name = product_name;
		this.courier_company = courier_company;
		this.courier_template = courier_template;
		this.courier_id = courier_id;
		this.print_date = print_date;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", sender_name=" + sender_name + ", sender_address=" + sender_address
				+ ", sender_company=" + sender_company + ", sender_phone=" + sender_phone + ", sender_postcode="
				+ sender_postcode + ", receiver_name=" + receiver_name + ", receiver_address=" + receiver_address
				+ ", receiver_company=" + receiver_company + ", receiver_phone=" + receiver_phone
				+ ", receiver_postcode=" + receiver_postcode + ", purchaser_id=" + purchaser_id + ", product_name="
				+ product_name + ", courier_company=" + courier_company + ", courier_template=" + courier_template
				+ ", courier_id=" + courier_id + ", print_date=" + print_date + "]";
	}
  
}
