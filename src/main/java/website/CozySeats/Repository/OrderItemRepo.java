package website.CozySeats.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import website.CozySeats.Entity.OrderItem;
import website.CozySeats.Entity.OrderItemID;
@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,OrderItemID>{
    
}
