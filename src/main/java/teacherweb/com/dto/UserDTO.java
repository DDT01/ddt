package teacherweb.com.dto;

import lombok.Data;

@Data
public class UserDTO {
	private int id;
    private String username;
    private String name;
    private String password;
    private String email;
    private int phone;
    private String birthDate;
    private String infoJson;
    private RoleDTO roleDTO;
	public UserDTO() {
		super();
	}
	public UserDTO(int id, String username, String name, String password, String email, int phone, String birthDate,
			String infoJson, RoleDTO roleDTO) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.infoJson = infoJson;
		this.roleDTO = roleDTO;
	}
	public UserDTO(String username, String name, String password, String email, int phone, String birthDate,
			String infoJson) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.infoJson = infoJson;
	}
	
}
