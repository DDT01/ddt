package teacherweb.com.service;

import java.util.List;

import teacherweb.com.entity.User;

public interface UserService {
	
    User findUserByUserName(String username);
    List<User> getListUsers();
    boolean register(User user);
}
