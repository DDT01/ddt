package teacherweb.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import teacherweb.com.entity.User;
import teacherweb.com.service.UserService;

@Controller
@RequestMapping("account")
@Api(tags = "account")
public class UserApi {
	
	@Autowired
	private UserService userService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(userService.findUserByUserName(user.getUsername()));
    }
    
    @RequestMapping(value = "/getListUsers", method = RequestMethod.GET)
	public ResponseEntity<?> getListUsers(){
		return ResponseEntity.ok(userService.getListUsers());
	}
}
