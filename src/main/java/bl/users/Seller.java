package bl.users;

import bl.components.Product;
import bl.components.ProductsCollection;

import java.io.Serializable;

/**
 * Created by Pini Shlomi At 07/06/2024
 */
public class Seller extends User implements Serializable, Cloneable {

    private ProductsCollection products;

    public Seller(String name, String password) {
        super(name, password);
        products = new ProductsCollection();
    }

    public String getName() {
        return getUserName();
    }

    public boolean addProduct(Product p) {
        return products.addProduct(p);
    }


    public String show() {
        return products.show();
    }

    public ProductsCollection getProducts() {
        return products;
    }

    public Product getProductByIndex(int index) {
        return products.getProductByIndex(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ")
                .append(getUserName())
                .append(", Password: ")
                .append(getPassword())
                .append("\n");
        sb.append(products.show());
        return sb.toString();
    }

    @Override
    public Seller clone() throws CloneNotSupportedException {
        Seller seller = (Seller) super.clone();
        seller.products = products.clone();
        return seller;
    }

}
