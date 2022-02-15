package ru.alov.lesson_3_mvc.entities;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT a FROM Product a"),
        @NamedQuery(name = "Product.findProductsByCategoryId", query = "SELECT a FROM Product a WHERE a.category.id = :id")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @Column(name = "cost",nullable = false)
    @Min(value = 0, message = "Cost should be greater than 0")
    private double cost;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Order> orderList;

//    @ManyToMany()
//    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
//    @JoinTable(
//            name = "clients_products",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "client_id")
//    )
//    private List<Client> clientList;
//
//    public List<Client> getClientList() {
//        return clientList;
//    }

    public Product() {
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

//    public void setClientList(List<Client> clientList) {
//        this.clientList = clientList;
//    }

    @Transient
    private CategoryTypes categoryType;

    public Product(Long id, String name, double cost, CategoryTypes categoryType) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.categoryType = categoryType;
    }

    public enum CategoryTypes {
        TV("Tv"),
        PHONE("Phone"),
        COMPUTER("Computer"),
        NONE("None");

        private final String displayName;

        CategoryTypes(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public CategoryTypes getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryTypes categoryType) {
        this.categoryType = categoryType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public double getCost() {
        return cost;
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
