package website.CozySeats.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import website.CozySeats.Entity.Product;
import website.CozySeats.Repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;


    public List<Product> getAllProducts(){
        
        return productRepo.findAll();
    }

    public Product findProductByID(Long id){

       Optional<Product> product= productRepo.findById(id);

       if(product.isPresent()){
        return product.get();
       }
        throw new RuntimeException("Could not find the product"); 
    }
    
}
