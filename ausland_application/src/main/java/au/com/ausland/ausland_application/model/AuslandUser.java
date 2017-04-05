package au.com.ausland.ausland_application.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class AuslandUser{

    //http://www.oracle.com/technetwork/middleware/ias/id-generation-083058.html
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(length=32,unique = true)
    @NotNull
    private String username; 
    
    @Column(length=108)
    @NotNull
    private String password;
    
    @Column(length=32)
    @NotNull
    private String role;
    
    @Column(length=1)
    @NotNull
    private Boolean active;
    
    @Temporal(TemporalType.DATE)
    @Column
    @NotNull
    private Date createddate;
    
    @Temporal(TemporalType.DATE)
    @Column
    private Date lastlogindate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getLastlogindate() {
		return lastlogindate;
	}

	public void setLastlogindate(Date lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	@Override
	public String toString() {
		return "AuslandUser [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", active=" + active + ", createddate=" + createddate + ", lastlogindate=" + lastlogindate + "]";
	}
  
    
}
