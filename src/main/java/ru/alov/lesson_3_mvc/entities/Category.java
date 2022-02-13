package ru.alov.lesson_3_mvc.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "SELECT a FROM Category a"),
})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('TV','COMPUTER','PHONE')")
    private Product.CategoryTypes categoryType;

    @Transient
    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product.CategoryTypes getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Product.CategoryTypes categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryType=" + categoryType +
                '}';
    }
}
