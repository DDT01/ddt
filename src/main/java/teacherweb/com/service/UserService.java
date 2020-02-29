package teacherweb.com.service;

import java.util.List;

import teacherweb.com.dto.UserDTO;
import teacherweb.com.dto.UserLoginDTO;
import teacherweb.com.entity.Users;

public interface UserService {
	
    Users findUserByUserName(String username);
    
    List<Users> getListUsers();
    
    boolean register(UserDTO user);
    
    String login(UserLoginDTO user);
    
    boolean updateUser(UserDTO user);

	boolean deleteUser(UserDTO user);
}
