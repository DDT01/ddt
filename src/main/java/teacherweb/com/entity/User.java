package teacherweb.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User{

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
    private int phone;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "info_json")
    private String infoJson;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleId;

	public User(int id, String username, String name, String password, String email, int phone, String birthDate,
			String infoJson, Role roleId) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.infoJson = infoJson;
		this.roleId = roleId;
	}

	public User(String username, String name, String password, String email, int phone, String birthDate,
			String infoJson, Role roleId) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.infoJson = infoJson;
		this.roleId = roleId;
	}

	public User() {
		super();
	}

	

}