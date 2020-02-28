package teacherweb.example.demo.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teacherweb.example.demo.service.UserService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class UserApi {
    private UserService userService;

    @Autowired
    public UserApi(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(path = "/check/login", method = GET)
    public ResponseEntity checkLoggedIn() {
        return ResponseEntity.ok("1");
    }

    @RequestMapping(path = "/login", method = GET)
    public ResponseEntity login(@RequestParam("username") String username,
                                @RequestParam("password") String password) {
        return ResponseEntity.ok(userService.findUserByUserName(username));
//                );

    }
}
