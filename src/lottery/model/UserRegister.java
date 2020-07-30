package lottery.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Entity
public class UserRegister {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String cnp;
	private String address;
	@OneToOne(cascade=CascadeType.ALL)
	@Valid
	private Login login;
	
	public UserRegister() {}
	
	public UserRegister(String name, String cnp, String address, Login login) {
		super();
		this.name = name;
		this.cnp = cnp;
		this.address = address;
		this.login = login;
	}
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
