package lesson_1_manual;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Product implements IProduct {

    private final int id;

    private final String name;

    private double cost;

    public Product(int id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
