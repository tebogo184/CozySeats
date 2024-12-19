package website.CozySeats.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CartItem")
@Data
@IdClass(CartItemID.class)
public class CartItem {
    
   @Id
    private Long productID;

    @Id
    private Long cartID;

    @Column(name = "quantity",nullable=false)
    private int quantity;
}
