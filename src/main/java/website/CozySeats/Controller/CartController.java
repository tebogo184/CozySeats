package website.CozySeats.Controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import website.CozySeats.Entity.CartItem;
import website.CozySeats.Entity.OrderItem;
import website.CozySeats.Service.CartItemService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
public class CartController {
    
       @Autowired
       private CartItemService cartItemService;

    @PutMapping("/updateCartItem")
    public ResponseEntity<?> updareCartItem( @RequestBody CartItem cartItem) {
        
        return ResponseEntity.ok(cartItemService.updateCartItem(cartItem));
    }

    @GetMapping("/getAllCartItems/{userID}")
    public ResponseEntity<?> getAllCartItems(@PathVariable Long userID) {
        return ResponseEntity.ok(cartItemService.getAllCartItems(userID));
    }

    @PostMapping("/addCartItem/{userID}")
    public ResponseEntity<?> addCartItems(@RequestBody CartItem cartItem,@PathVariable Long userID){

        return ResponseEntity.ok(cartItemService.addCartItems(cartItem,userID));
    }

    @PostMapping("/checkout/{userID}")
    public ResponseEntity<?> clearCart(@PathVariable Long userID) {
        //TODO: process POST request
        
        System.out.println("INSIDE THE CLEAR CART METHOD");
        return ResponseEntity.ok(cartItemService.clearCartItem(userID));
    }
    
    @DeleteMapping("/deleteItem")
    public  ResponseEntity<?> deleteCartItem(@RequestBody CartItem cartItem){

        return ResponseEntity.ok(cartItemService.deleteCartItems(cartItem));
    }

    
    
}
