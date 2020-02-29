package teacherweb.com.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Data;

@Data
public class UserLoginDTO {

	private String userName;
	private String password;
	private List<String> roles;

	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	public UserLoginDTO(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public UserLoginDTO() {
	}
}
