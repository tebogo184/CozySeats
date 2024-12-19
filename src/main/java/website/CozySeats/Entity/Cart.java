package website.CozySeats.Entity;

import java.math.BigDecimal;
import java.util.Date;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;

@Entity
@Table( name="Cart")
@Data
@IdClass(CartUserID.class)
@NoArgsConstructor
@AllArgsConstructor
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cartID;

    @Id
    private Long userID;


    @Column(name="date_created", nullable = false)
    
    private Date dateCreated;
    


    
}
