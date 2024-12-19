package website.CozySeats.Controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import website.CozySeats.Entity.User;
import website.CozySeats.Service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="http://127.0.0.1:5500")
public class AuthenticationController {
    

    @Autowired
    @Lazy
    private final UserService userService;

    @GetMapping("/home")
    public String home() {
        return "html/home";
    }

    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody User user) {
         
        return ResponseEntity.ok(userService.registerUser(user)) ;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User entity) {
        Optional<User> user=userService.login(entity);

        if(user.isPresent())
        {
            return ResponseEntity.ok(user.get());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");

    
    }
    


    
    
    
}
