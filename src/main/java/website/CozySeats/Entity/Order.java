package website.CozySeats.Entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@IdClass(UserOrderID.class)
@Table(name="`Order`")
@Data
@ToString
public class Order {
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderID;
    @Column(name="purchase_date")
    private Date purchaseDate;
    @Id
    private Long userID;
    @Column(name = "total_amount")
    private float totalAmount;

    

    



}
