package lesson_1_manual;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class ProductRepository implements IProductRepository{

    private final List<IProduct> productList;

    public ProductRepository(List<IProduct> productList) {
        this.productList = productList;
    }

    public List<IProduct> getProductList() {
        return productList;
    }

    public IProduct getProduct(int id) {
        Optional<IProduct> product = productList.stream().filter(s -> s.getId() == id).findAny();
        if (product.isPresent()){
            return product.get();
        }else throw new NoSuchElementException();
    }

}
