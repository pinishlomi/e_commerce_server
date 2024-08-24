package bl.components;

import bl.general.Category;

import java.io.Serializable;

/**
 * Created by Pini Shlomi At 08/06/2024
 */
public class Product implements Serializable, Cloneable {
    private final String id;
    private final String name;
    private final double price;
    private final Category category;
    private final String url;

    public Product(String id, String name, double price, Category category, String url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.url = url;
    }

    public Product(Product other) {
        id = other.id;
        name = other.name;
        price = other.price;
        category = other.category;
        url = other.url;
    }

    public String getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + "," + name + ", " + price + ", " + category;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Product p) {
            return id.equals(p.id);
        }
        return false;
    }

    @Override
    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }

}
