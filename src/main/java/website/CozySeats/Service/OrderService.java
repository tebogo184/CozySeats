package website.CozySeats.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import website.CozySeats.Entity.Order;
import website.CozySeats.Entity.OrderItem;
import website.CozySeats.Entity.UserOrderID;
import website.CozySeats.Repository.OrderItemRepo;
import website.CozySeats.Repository.OrderRepo;

@Service

public class OrderService {

    @Autowired 
    private OrderRepo orderRepo;
    @Autowired
    private OrderItemRepo orderItemRepo;



    public List<Order> getUserOrders(int userID){

        return null;
    }

    public List<OrderItem> getAllOrderItems(Long userID){


        Long orderID=orderRepo.getUserOrder(userID).get().getOrderID();
        List<OrderItem>orderList=orderItemRepo.findAll().stream().toList();

        return orderList.stream().filter(item-> item.getOrderID()==orderID).toList();
    }
    public List<OrderItem> addOrderItem(List<OrderItem> orderItems,Long userID,float totalOrderAmount){

        Order tempOrder=new Order();

        tempOrder.setPurchaseDate(new Date());
        tempOrder.setTotalAmount(totalOrderAmount);
        tempOrder.setUserID(userID);

       Order savedOrder= orderRepo.save(tempOrder);


       System.out.println("ORder details:"+savedOrder.toString());
        orderItems.forEach(item->{
            item.setOrderID(savedOrder.getOrderID());
        });

        return orderItemRepo.saveAll(orderItems);
    }

    
}
