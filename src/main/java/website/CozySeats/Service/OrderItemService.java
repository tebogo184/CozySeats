package website.CozySeats.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import website.CozySeats.Repository.OrderItemRepo;

@Service
public class OrderItemService {
    
    @Autowired
    private OrderItemRepo orderItemRepo;
}
