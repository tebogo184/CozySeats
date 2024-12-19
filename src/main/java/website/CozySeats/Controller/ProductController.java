package website.CozySeats.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import website.CozySeats.Entity.Product;
import website.CozySeats.Service.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@CrossOrigin(origins="http://127.0.0.1:5500")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/allProducts")
    public ResponseEntity<?> findAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/findProductById/{id}")
    public ResponseEntity<Product> findProductById(@RequestParam Long id) {

        Product product =productService.findProductByID(id);
        
        return ResponseEntity.ok(product);
    }
    
    

    
}
