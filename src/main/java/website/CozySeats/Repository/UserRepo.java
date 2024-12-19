package website.CozySeats.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.CozySeats.Entity.User;

import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findUserByEmail(String email);

    

}
