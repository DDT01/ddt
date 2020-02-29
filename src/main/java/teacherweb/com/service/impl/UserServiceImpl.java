package teacherweb.com.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teacherweb.com.entity.User;
import teacherweb.com.repository.RoleRepository;
import teacherweb.com.repository.UserRepository;
import teacherweb.com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;

   private RoleRepository roleRepository;

    @Override
    public User findUserByUserName(String username){
         return userRepository.findUserByUsername(username);
    }


	@Override
	public List<User> getListUsers() {
		return userRepository.findAll();
	}


	@Override
	public boolean register(User user) {
		if (userRepository.findUserByUsername(user.getUsername()) != null) {
			return false;
		} else {
			user.setId(0);
			user.setRole(roleRepository.findById(user.getRole().getId()));
			userRepository.save(user);
			userRepository.save(user);
			return true;
		}
	}

}
