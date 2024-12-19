package website.CozySeats.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import website.CozySeats.Entity.CartItem;
import website.CozySeats.Entity.CartItemID;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem,CartItemID>{
    

    @Query("SELECT c FROM CartItem c WHERE c.cartID=:cartID")
    List<CartItem> findAllByID(@Param("cartID") Long cartID);
}
