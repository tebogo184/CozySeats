package website.CozySeats.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OrderItem")
@IdClass(OrderItemID.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
   

    @Id
    private Long orderID;

    @Id
    private Long productID;

    @Column(name = "quantity")
    private int quantity;

    @Column(name="order_item_total")
    private float  orderItemTotal;



}
