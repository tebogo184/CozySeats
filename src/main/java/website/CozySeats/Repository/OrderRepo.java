package website.CozySeats.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import website.CozySeats.Entity.Order;
import website.CozySeats.Entity.UserOrderID;

@Repository
public interface OrderRepo extends JpaRepository<Order,UserOrderID> {

    @Query("SELECT o FROM Order o WHERE o.userID=:userID ")
    Optional<Order> getUserOrder(@Param("userID")Long userID);
    
}
