package website.CozySeats.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.CozySeats.Entity.Product;


@Repository
public interface ProductRepo  extends JpaRepository<Product,Long> {
}
