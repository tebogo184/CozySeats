package website.CozySeats.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import website.CozySeats.Entity.Cart;
import website.CozySeats.Repository.CartItemRepo;
import website.CozySeats.Repository.CartRepo;

@Service
public class CartService {
    
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private CartItemRepo cartItemRepo;



    public void createCart(Cart cart){
        
        var userID=cart.getUserID();

    }
}
