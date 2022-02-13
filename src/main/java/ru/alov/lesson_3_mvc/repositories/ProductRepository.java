package ru.alov.lesson_3_mvc.repositories;

import org.springframework.stereotype.Component;
import ru.alov.lesson_3_mvc.models.IProduct;
import ru.alov.lesson_3_mvc.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ProductRepository implements Repository {

    private static int PRODUCT_COUNT;

    private final List<IProduct> productList;

    {
        productList = new ArrayList<>();

        productList.add(new Product(++PRODUCT_COUNT, "Phone", 100.55));
        productList.add(new Product(++PRODUCT_COUNT, "Refrigerator", 225.66));
        productList.add(new Product(++PRODUCT_COUNT, "TV", 122.25));
        productList.add(new Product(++PRODUCT_COUNT, "Computer", 346.58));
    }

    public List<IProduct> getProductList() {
        return productList;
    }

    @Override
    public List<IProduct> getAllProducts() {
        return productList;
    }

    @Override
    public void update(IProduct product, int id) {
        IProduct productToUpdate = this.getProduct(id);
        productToUpdate.setName(product.getName());
        productToUpdate.setCost(product.getCost());
    }

    @Override
    public void delete(int id) {
        productList.removeIf(p -> p.getId() == id);
    }

    @Override
    public IProduct getProduct(int id) {
        return productList.stream().filter(s -> s.getId() == id).findAny().orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void addProduct(IProduct product) {
        product.setId(++PRODUCT_COUNT);
        productList.add(product);
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "productList=" + productList +
                '}';
    }
}
