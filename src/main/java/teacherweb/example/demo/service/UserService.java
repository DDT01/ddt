package teacherweb.example.demo.service;

import teacherweb.example.demo.entity.User;

public interface UserService {
    User findUserByUserName(String username);
}
