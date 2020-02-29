package teacherweb.com.dto;

import lombok.Data;

@Data
public class RoleDTO {
	private int id;
	private String name;
	public RoleDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public RoleDTO() {
		super();
	}
	
}
