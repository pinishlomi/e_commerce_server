package bl.components;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Pini Shlomi At 08/06/2024
 */
public class Cart implements Serializable, Cloneable {
    private ProductsCollection products;
    private Date buyDate;

    public Cart() {
        products = new ProductsCollection();
    }

    public boolean addProduct(Product p) {
        return products.addProduct(p);
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public double getPrice() {
        return products.getTotalPrice();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public String toString() {
        if (buyDate != null) {
            return "date: " + buyDate + "\n" + products.show();
        }
        return products.show();
    }

    @Override
    public Cart clone() throws CloneNotSupportedException {
        Cart cart = (Cart) super.clone();
        cart.products = products.clone();
        cart.buyDate = new Date(buyDate.getTime());
        return cart;
    }


}
