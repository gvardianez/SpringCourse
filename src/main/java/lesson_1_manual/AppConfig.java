package lesson_1_manual;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public Product productOne(){
        return new Product(1,"one",1.1);
    }

    @Bean
    public Product productTwo(){
        return new Product(2,"two",2.2);
    }

    @Bean
    public Product productThree(){
        return new Product(3,"three",3.3);
    }

    @Bean
    public Product productFour(){
        return new Product(4,"four",4.4);
    }

    @Bean
    public Product productFife(){
        return new Product(5,"fife",5.5);
    }

    @Bean
    public List<IProduct> productListCart(){
        return new ArrayList<>();
    }

    @Bean
    public List<IProduct> productList(){
        return new ArrayList<>(Arrays.asList(productOne(),productTwo(),productThree(),productFour(),productFife()));
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepository(productList());
    }

    @Bean
    public Cart cart(){
        return new Cart(productListCart(),productRepository());
    }

}
