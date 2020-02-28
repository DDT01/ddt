package teacherweb.example.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teacherweb.example.demo.entity.User;
import teacherweb.example.demo.repository.UserRepo;
import teacherweb.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepo userRepo;


    @Override
    public User findUserByUserName(String username){
         return userRepo.findUserByUsername(username);
    }

}
