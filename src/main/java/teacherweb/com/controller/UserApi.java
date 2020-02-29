package teacherweb.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import teacherweb.com.dto.UserDTO;
import teacherweb.com.dto.UserLoginDTO;
import teacherweb.com.service.UserService;

@Controller
@RequestMapping("account")
@Api(tags = "account")
public class UserApi {
	
	@Autowired
	private UserService userService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody UserLoginDTO user) {
        return ResponseEntity.ok(userService.login(user));
    }
    
    @RequestMapping(value = "/getListUsers", method = RequestMethod.GET)
	public ResponseEntity<?> getListUsers(){
		return ResponseEntity.ok(userService.getListUsers());
	}
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody UserDTO user){
		return ResponseEntity.ok(userService.register(user));
	}
    
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody UserDTO user){
		return ResponseEntity.ok(userService.updateUser(user));
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public ResponseEntity<?> deleteUser(@RequestBody UserDTO user){
		return ResponseEntity.ok(userService.deleteUser(user));
	}
}
