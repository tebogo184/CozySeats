package website.CozySeats.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import website.CozySeats.Entity.User;
import website.CozySeats.Entity.UserRole;
import website.CozySeats.Repository.UserRepo;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    @Lazy
    private  AuthenticationManager authenticationManager;



    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        userRepo.save(user);

        return user;
    }

    public Optional<User> login(User user){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));

        var userList=userRepo.findAll();

       Optional<User> tempUser=userList.stream().filter(entity-> entity.getEmail().equals(user.getEmail())).findFirst();

       System.out.println("**success**");
        return tempUser;
    
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> tempUser=userRepo.findUserByEmail(username);

        if(tempUser.isPresent()){
            return tempUser.get();
        }

        
        throw new UsernameNotFoundException("Could not find the username");
    }
}