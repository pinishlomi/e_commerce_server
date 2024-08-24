package bl.components;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Pini Shlomi At 08/06/2024
 */
public class ProductsCollection implements Serializable, Cloneable {
    private Product[] products;
    private int numOfProduct;

    public ProductsCollection() {
        products = new Product[0];
    }

    public ProductsCollection(ProductsCollection other) throws CloneNotSupportedException {
        this.products = new Product[other.numOfProduct];
        for (int i = 0; i < other.numOfProduct; i++) {
            products[i] = other.getProductByIndex(i).clone();
        }
        numOfProduct = other.numOfProduct;
    }

    public Product[] getProducts() {
        return products;
    }

    public int getNumOfProduct() {
        return numOfProduct;
    }

    public boolean addProduct(Product p) {
        if (isProductExist(p)) {
            return false;
        }
        if (numOfProduct == 0) {
            products = new Product[2];
        } else if (numOfProduct == products.length) {
            products = Arrays.copyOf(products, products.length * 2);
        }
        products[numOfProduct++] = p;
        return true;
    }

    public boolean isProductExist(Product product) {
        for (int i = 0; i < numOfProduct; i++) {
            if (products[i].equals(product)) {
                return true;
            }
        }
        return false;
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        if (numOfProduct == 0) {
            sb.append("products list are empty\n");
        } else {
            for (int i = 0; i < numOfProduct; i++) {
                sb.append(i + 1)
                        .append(") ")
                        .append(products[i])
                        .append("\n");
            }
        }
        return sb.toString();
    }


    public Product getProductByIndex(int index) {
        if (index < 0 || index >= numOfProduct) {
            return null;
        }
        return products[index];
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < numOfProduct; i++) {
            totalPrice += products[i].getPrice();
        }
        return totalPrice;
    }

    public boolean isEmpty() {
        return numOfProduct == 0;
    }

    @Override
    public ProductsCollection clone() throws CloneNotSupportedException {
        ProductsCollection productsCollection = (ProductsCollection) super.clone();
        productsCollection.products = new Product[numOfProduct];
        for (int i = 0; i < numOfProduct; i++) {
            productsCollection.products[i] = getProductByIndex(i).clone();
        }
        productsCollection.numOfProduct = numOfProduct;
        return productsCollection;
    }

}
