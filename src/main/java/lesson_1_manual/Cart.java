package lesson_1_manual;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@Scope("prototype")
public class Cart implements ICart{

    private final List<IProduct> productListCart;

    private final ProductRepository productRepository;

    public Cart(List<IProduct> productListCart,ProductRepository productRepository) {
        this.productListCart = productListCart;
        this.productRepository = productRepository;
    }

    @Override
    public void add(int id) {
        try {
            productListCart.add(productRepository.getProduct(id));
        }catch (NoSuchElementException e){
            System.out.println("Not found product with this id");
        }
    }

    @Override
    public void remove(int id) {
        try {
            productListCart.remove(productRepository.getProduct(id));
        }catch (NoSuchElementException e){
            System.out.println("Not found product with this id");
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productListCart=" + productListCart +
                '}';
    }
}
