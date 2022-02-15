package ru.alov.lesson_3_mvc.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "cost")
    private double cost;

    @ManyToMany()
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JoinTable(
            name = "clients_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clientList;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product +
                ", cost=" + cost +
                '}';
    }
}
