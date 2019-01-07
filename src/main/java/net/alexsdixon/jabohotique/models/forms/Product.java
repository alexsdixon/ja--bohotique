package net.alexsdixon.jabohotique.models.forms;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URL;
import java.time.LocalDateTime;

@Entity
public class Product {


    @Id
    @GeneratedValue
    private int id;

    @GeneratedValue
    public LocalDateTime upload_date  = LocalDateTime.now();

    @NotNull
    @Size(min = 1, message= "Please enter the name of the item!")
    private String product_name;

    private int price;

    private String size;
    private URL first_image;
    private URL second_image;
    private ProductCategory category;
    private ProductType type;


    public Product() {  }

    public Product(String product_name,String size,int price, URL first_image, URL second_image){

        this.product_name = product_name;
        this.size = size;
        this.price = price;
        this.first_image = first_image;
        this.second_image = second_image;
    }

    public int getId() {
        return id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public URL getFirst_image() {
        return first_image;
    }

    public void setFirst_image(URL first_image) {
        this.first_image = first_image;
    }

    public URL getSecond_image() {
        return second_image;
    }

    public void setSecond_image(URL second_image) {
        this.second_image = second_image;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }


}
