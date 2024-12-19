package website.CozySeats.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import website.CozySeats.Entity.Cart;
import website.CozySeats.Entity.CartUserID;

@Repository
public interface CartRepo  extends JpaRepository<Cart,CartUserID>{
    
    @Query("SELECT c FROM  Cart c WHERE c.userID=:userID")
    Optional<Cart> findCartById(@Param("userID") Long userID);
}
