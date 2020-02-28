package teacherweb.com.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teacherweb.com.entity.User;
import teacherweb.com.repository.UserRepository;
import teacherweb.com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;


    @Override
    public User findUserByUserName(String username){
         return userRepository.findUserByUsername(username);
    }


	@Override
	public List<User> getListUsers() {
		return userRepository.findAll();
	}

}
