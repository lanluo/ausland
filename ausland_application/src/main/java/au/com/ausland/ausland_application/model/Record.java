package au.com.ausland.ausland_application.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.Date;

@Entity
public class Record{

    //http://www.oracle.com/technetwork/middleware/ias/id-generation-083058.html
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(length=32)
    private String sendername; 
    
    @Column(length=108)
    private String senderaddress;
    
    @Column(length=32)
    private String sendercompany;
    
    @Column(length=12)
    private String senderphone;
    
    @Column(length=12)
    private String senderpostcode;
    
    @Column(length=32)
    @NotNull
    private String receivername;
    
    @Column(length=256)
    @NotNull
    private String receiveraddress;
    
    @Column(length=32)
    private String receivercompany;
    
    @Column(length=12)
    @NotNull
    @Pattern(regexp = "[0-9]+", message = "wrong number")
    private String receiverphone;
    
    @Column(length=12)
    private String receiverpostcode;
    
    @Column(length=32)
    private String purchaserid;
    
    @Column(length=256)
    @NotNull
    private String productname;
    
    @Column(length=32)
    @NotNull
    private String couriercompany;
    
    @Column(length=32)
    @NotNull
    private String couriertemplate;
    
    @Column(length=32, unique = true)
    @NotNull
    private String courierid;

    @Temporal(TemporalType.DATE)
    @Column
    private Date printdate;

    public Record() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public String getSenderaddress() {
		return senderaddress;
	}

	public void setSenderaddress(String senderaddress) {
		this.senderaddress = senderaddress;
	}

	public String getSendercompany() {
		return sendercompany;
	}

	public void setSendercompany(String sendercompany) {
		this.sendercompany = sendercompany;
	}

	public String getSenderphone() {
		return senderphone;
	}

	public void setSenderphone(String senderphone) {
		this.senderphone = senderphone;
	}

	public String getSenderpostcode() {
		return senderpostcode;
	}

	public void setSenderpostcode(String senderpostcode) {
		this.senderpostcode = senderpostcode;
	}

	public String getReceivername() {
		return receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public String getReceiveraddress() {
		return receiveraddress;
	}

	public void setReceiveraddress(String receiveraddress) {
		this.receiveraddress = receiveraddress;
	}

	public String getReceivercompany() {
		return receivercompany;
	}

	public void setReceivercompany(String receivercompany) {
		this.receivercompany = receivercompany;
	}

	public String getReceiverphone() {
		return receiverphone;
	}

	public void setReceiverphone(String receiverphone) {
		this.receiverphone = receiverphone;
	}

	public String getReceiverpostcode() {
		return receiverpostcode;
	}

	public void setReceiverpostcode(String receiverpostcode) {
		this.receiverpostcode = receiverpostcode;
	}

	public String getPurchaserid() {
		return purchaserid;
	}

	public void setPurchaserid(String purchaserid) {
		this.purchaserid = purchaserid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getCouriercompany() {
		return couriercompany;
	}

	public void setCouriercompany(String couriercompany) {
		this.couriercompany = couriercompany;
	}

	public String getCouriertemplate() {
		return couriertemplate;
	}

	public void setCouriertemplate(String couriertemplate) {
		this.couriertemplate = couriertemplate;
	}

	public String getCourierid() {
		return courierid;
	}

	public void setCourierid(String courierid) {
		this.courierid = courierid;
	}

	public Date getPrintdate() {
		return printdate;
	}

	public void setPrintdate(Date printdate) {
		this.printdate = printdate;
	}
	
    public Record(String sendername, String senderaddress, String sendercompany, String senderphone,
    		String senderpostcode, String receivername, String receiveraddress, String receivercompany,
    		String receiverphone, String receiverpostcode, String purchaserid, String productname,
			String couriercompany, String couriertemplate, String courierid, Date printdate) {
		super();
		this.sendername = sendername;
		this.senderaddress = senderaddress;
		this.sendercompany = sendercompany;
		this.senderphone = senderphone;
		this.senderpostcode = senderpostcode;
		this.receivername = receivername;
		this.receiveraddress = receiveraddress;
		this.receivercompany = receivercompany;
		this.receiverphone = receiverphone;
		this.receiverpostcode = receiverpostcode;
		this.purchaserid = purchaserid;
		this.productname = productname;
		this.couriercompany = couriercompany;
		this.couriertemplate = couriertemplate;
		this.courierid = courierid;
		this.printdate = printdate;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + "sendername=" + sendername + ", senderaddress=" + senderaddress
				+ ", sendercompany=" + sendercompany + ", senderphone=" + senderphone + ", senderpostcode="
				+ senderpostcode + ", receivername=" + receivername + ", receiveraddress=" + receiveraddress
				+ ", receivercompany=" + receivercompany + ", receiverphone=" + receiverphone
				+ ", receiverpostcode=" + receiverpostcode + ", purchaserid=" + purchaserid + ", productname="
				+ productname + ", couriercompany=" + couriercompany + ", couriertemplate=" + couriertemplate
				+ ", courierid=" + courierid + ", printdate=" + printdate + "]";
	}
  
}
