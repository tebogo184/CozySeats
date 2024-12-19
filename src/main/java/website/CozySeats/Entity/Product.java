package website.CozySeats.Entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String imgSrc;

    @Column(nullable = false)
    private float price;

    @Column(nullable=false)
    private String description;

    @Column(nullable=false)
    private int quantity;


}
