package website.CozySeats.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import website.CozySeats.Entity.Cart;
import website.CozySeats.Entity.CartItem;
import website.CozySeats.Entity.CartItemID;
import website.CozySeats.Entity.OrderItem;
import website.CozySeats.Entity.Product;
import website.CozySeats.Repository.CartItemRepo;
import website.CozySeats.Repository.CartRepo;
import website.CozySeats.Repository.OrderRepo;
import website.CozySeats.Repository.ProductRepo;

@Service
public class CartItemService {


    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private OrderService orderService;



    @Transactional(rollbackOn = Exception.class)
    public List<OrderItem> clearCartItem(Long userID){

      Cart cart=cartRepo.findCartById(userID).get();

      List<CartItem> cartItems=cartItemRepo.findAllByID(cart.getCartID());

      float cartTotal=0;
      List<OrderItem> newOrderItems=new ArrayList<>();
     for(CartItem item:cartItems){

      Product product=productRepo.findById(item.getProductID()).get();
       float cartItemTotal=item.getQuantity()*product.getPrice();
       cartTotal+=cartItemTotal;

       OrderItem orderItem=new OrderItem();
       orderItem.setOrderItemTotal(cartItemTotal);
       orderItem.setProductID(item.getProductID());
       orderItem.setQuantity(item.getQuantity());

       newOrderItems.add(orderItem);
     }

   
     List<OrderItem>savedOrderList=orderService.addOrderItem(newOrderItems, userID, cartTotal);
     cartItemRepo.deleteAll(cartItems);

     return savedOrderList;

     
    }

    @Transactional(rollbackOn = Exception.class)
    public List<CartItem> deleteCartItems(CartItem cartItem){

      cartItemRepo.deleteById(new CartItemID(cartItem.getCartID(),cartItem.getProductID()));

      return  cartItemRepo.findAllByID(cartItem.getCartID());
    }

    @Transactional(rollbackOn=Exception.class)
    public CartItem updateCartItem(CartItem cartItem){

    
      CartItem tempItem=cartItemRepo.findById(new CartItemID(cartItem.getCartID(),cartItem.getProductID())).get();

      tempItem.setQuantity(cartItem.getQuantity());


      cartItemRepo.save(tempItem);

      return tempItem;
    }

    @Transactional(rollbackOn = Exception.class)
    public List<CartItem> addCartItems(CartItem cartItem,Long userID){

      System.out.println("**********************inside the add cart method**************************");
          Optional<Cart> optionalCart=cartRepo.findCartById(userID);

        if(!optionalCart.isPresent()){


          System.out.println("Cart is being created");

            Cart cart =new Cart();

            cart.setDateCreated(new Date());
            cart.setUserID(userID);
            Cart tempCart= cartRepo.save(cart);


            Long cartID=tempCart.getCartID();
              cartItem.setCartID(cartID);
              cartItemRepo.save(cartItem);

         return cartItemRepo.findAllByID(cartID);
           
            
            
        }else{

          System.err.println("********Adding to the cartItems as cart is available***************");
            Cart cart=optionalCart.get();

            //update the cart item
             Optional<CartItem> optionalItem=cartItemRepo.findById(new CartItemID(cart.getCartID(),cartItem.getProductID()));

             if(optionalItem.isPresent()){
              
              CartItem item =optionalItem.get();

              System.err.println("****************cart item is availabe:"+item.toString());

              int newQuantity=item.getQuantity()+cartItem.getQuantity();

              item.setQuantity(newQuantity);
              cartItemRepo.save(item);
              System.err.println("*********item has been added************");

              return cartItemRepo.findAllByID(cart.getCartID());
              
             }else{

              //create a new cartItem

              System.err.println("**************Inew cartitem is being generated**********");
              CartItem newCartItem=new CartItem();

              newCartItem.setCartID(cart.getCartID());
              newCartItem.setProductID(cartItem.getProductID());
              newCartItem.setQuantity(cartItem.getQuantity());
              

              System.err.println("*************** new cart item has been added**********");
              cartItemRepo.save(newCartItem);
              return cartItemRepo.findAllByID(cart.getCartID());

             }
        }


        
    }

  
    public void deleteCartItem(CartItem cartItem){

       cartItemRepo.delete(cartItem);
    }
    
    public List<CartItem> getAllCartItems(Long userID){

      Optional<Cart> tempCart=cartRepo.findCartById(userID);
      

      if(tempCart.isPresent()){
        List<CartItem> cartItems= cartItemRepo.findAll().stream().toList();

        return cartItems.stream().filter(item-> item.getCartID()==tempCart.get().getCartID()).toList();
      }else{

        throw new RuntimeException("Could not find any items in the Order");
      }
      
    }
  
}
