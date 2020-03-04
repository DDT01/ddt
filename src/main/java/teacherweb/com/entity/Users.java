package teacherweb.com.entity;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "user")
@Data
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "birth_date")
	private String birthDate;

	@Column(name = "info_json")
	private String infoJson;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;



	public Users(String username, String name, String password, String email, String phone, String birthDate,
			String infoJson, Role role) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.infoJson = infoJson;
		this.role = role;
	}

	public Users(int id, String username, String name, String password, String email, String phone, String birthDate,
			String infoJson, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.infoJson = infoJson;
		this.role = role;
	}

	public Users() {
		super();
	}

	

}