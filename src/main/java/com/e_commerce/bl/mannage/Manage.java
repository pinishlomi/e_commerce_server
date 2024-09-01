package com.e_commerce.bl.mannage;

import com.e_commerce.bl.components.Product;
import com.e_commerce.bl.components.ProductsCollection;
import com.e_commerce.bl.general.Address;
import com.e_commerce.bl.general.Category;
import com.e_commerce.bl.users.Buyer;
import com.e_commerce.bl.users.Seller;
import com.e_commerce.bl.utils.InputValidator;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Pini Shlomi At 07/06/2024
 */
@Component
public class Manage {
    private Buyer[] buyers;
    private int numOfBuyers;
    private Seller[] sellers;
    private int numOfSellers;

    public Manage() {
        buyers = new Buyer[0];
        sellers = new Seller[0];
    }

    public boolean addBuyer(String buyerName, String password, Address address) throws CloneNotSupportedException {
        if (isBuyerExist(buyerName)) {
            return false;
        }
        if (numOfBuyers == 0) {
            buyers = new Buyer[2];
        } else if (numOfBuyers == buyers.length) {
            buyers = Arrays.copyOf(buyers, buyers.length * 2);
        }
        buyers[numOfBuyers++] = new Buyer(buyerName, password, address);
        return true;
    }

    public void addBuyer(Buyer buyer) throws CloneNotSupportedException {
        if (isBuyerExist(buyer.getName())) {
            return;
        }
        if (numOfBuyers == 0) {
            buyers = new Buyer[2];
        } else if (numOfBuyers == buyers.length) {
            buyers = Arrays.copyOf(buyers, buyers.length * 2);
        }
        buyers[numOfBuyers++] = buyer.clone();
    }

    public boolean isBuyerExist(String buyerName) {
        for (int i = 0; i < numOfBuyers; i++) {
            if (buyers[i].getName().equals(buyerName)) {
                return true;
            }
        }
        return false;
    }

    public boolean addSeller(String name, String password) {
        if (isSellerExist(name)) {
            return false;
        }
        if (numOfSellers == 0) {
            sellers = new Seller[2];
        } else if (numOfSellers == sellers.length) {
            sellers = Arrays.copyOf(sellers, sellers.length * 2);
        }
        sellers[numOfSellers++] = new Seller(name, password);
        return true;
    }

    public void addSeller(Seller seller) throws CloneNotSupportedException {
        if (isSellerExist(seller.getName())) {
            return;
        }
        if (numOfSellers == 0) {
            sellers = new Seller[2];
        } else if (numOfSellers == sellers.length) {
            sellers = Arrays.copyOf(sellers, sellers.length * 2);
        }
        sellers[numOfSellers++] = seller.clone();
    }

    public boolean isSellerExist(String sellerName) {
        for (int i = 0; i < numOfSellers; i++) {
            if (sellers[i].getName().equals(sellerName)) {
                return true;
            }
        }
        return false;
    }

    public String showBuyers() {
        StringBuilder sb = new StringBuilder();
        if (numOfBuyers == 0) {
            sb.append("Buyers list are empty");
        } else {
            sb.append("All Buyers:\n");
            for (int i = 0; i < numOfBuyers; i++) {
                sb.append(i + 1)
                        .append(") ")
                        .append(buyers[i])
                        .append("\n");
            }
        }
        return sb.toString();
    }

    public String showSellers() {
        StringBuilder sb = new StringBuilder();
        if (numOfSellers == 0) {
            sb.append("Sellers list are empty");
        } else {
            sb.append("All Sellers:\n");
            for (int i = 0; i < numOfSellers; i++) {
                sb.append(i + 1)
                        .append(") ")
                        .append(sellers[i])
                        .append("\n");
            }
        }
        return sb.toString();
    }

    public String showProductsByCategory(Category category) {
        StringBuilder sb = new StringBuilder();
        if (numOfSellers == 0) {
            sb.append("Sellers list are empty");
        } else {
            sb.append("All Products By ").append(category.name()).append(" Category:\n");
            ProductsCollection productsCollection;
            Product p;
            for (int i = 0; i < numOfSellers; i++) {
                productsCollection = sellers[i].getProducts();
                for (int j = 0; j < productsCollection.getNumOfProduct(); j++) {
                    p = productsCollection.getProducts()[j];
                    if (p.getCategory().equals(category)) {
                        sb.append(p).append("\n");
                    }
                }
            }
        }
        return sb.toString();
    }

    public Product[] getProductsByCategory(String categoryStr) {
        ProductsCollection productsByCategory = new ProductsCollection();
        Category category = ManageUtils.getCategory(categoryStr);
        if (category == null || numOfSellers == 0) {
            return productsByCategory.getProducts();
        } else {
            ProductsCollection productsCollection;
            Product p;
            for (int i = 0; i < numOfSellers; i++) {
                productsCollection = sellers[i].getProducts();
                for (int j = 0; j < productsCollection.getNumOfProduct(); j++) {
                    p = productsCollection.getProducts()[j];
                    if (p.getCategory().equals(category)) {
                        productsByCategory.addProduct(p);
                    }
                }
            }
        }
        Product[] products = new Product[productsByCategory.getNumOfProduct()];
        for (int i = 0; i < productsByCategory.getNumOfProduct(); i++) {
            products[i] = productsByCategory.getProducts()[i];
        }
        return products;
    }

    public int getNumOfBuyers() {
        return numOfBuyers;
    }

    public int getNumOfSellers() {
        return numOfSellers;
    }

    public Seller getSellerByIndex(int index) {
        if (index < 0 || index >= numOfSellers) {
            return null;
        }
        return sellers[index];
    }

    public boolean addProductToSeller(Seller seller, String id, String name, double price, Category category, String url) {
        Product p = new Product(id, name, price, category, url);
        return seller.addProduct(p);
    }

    public boolean addProductToSeller(String sellerName, Product p) {
        for (Seller seller : sellers) {
            if (seller.getName().equals(sellerName)) {
                return seller.addProduct(p);
            }
        }
        return false;
    }

    public Buyer getBuyerByIndex(int index) {
        if (index < 0 || index >= numOfBuyers) {
            return null;
        }
        return buyers[index];
    }

    public boolean addProductToBuyer(Buyer buyer, Product p) {
        return buyer.addProduct(p);
    }

    public boolean addProductToBuyer(String buyerName, Product p) {
        for (Buyer buyer : buyers) {
            if (buyer.getName().equals(buyerName)) {
                return buyer.addProduct(p);
            }
        }
        return false;
    }

    public double payBuyerOrder(String buyerName) throws CloneNotSupportedException {
        for (Buyer buyer : buyers) {
            if (buyer.getName().equals(buyerName)) {
                return buyer.pay();
            }
        }
        return -1;
    }

    public double payBuyerOrder(Buyer buyer) throws CloneNotSupportedException {
        return buyer.pay();
    }

    public String showSellersList() {
        StringBuilder sb = new StringBuilder();
        if (numOfSellers == 0) {
            sb.append("Sellers list are empty");
        } else {
            sb.append("All Sellers:\n");
            for (int i = 0; i < numOfSellers; i++) {
                sb.append(i + 1)
                        .append(") ")
                        .append(sellers[i].getName())
                        .append("\n");
            }
        }
        return sb.toString();
    }

    public String showBuyersList() {
        StringBuilder sb = new StringBuilder();
        if (numOfBuyers == 0) {
            sb.append("Buyers list are empty");
        } else {
            sb.append("All Buyers:\n");
            for (int i = 0; i < numOfBuyers; i++) {
                sb.append(i + 1)
                        .append(") ")
                        .append(buyers[i].getName())
                        .append("\n");
            }
        }
        return sb.toString();
    }

    public Seller[] getSellers() throws CloneNotSupportedException {
        Seller[] tempSellers = new Seller[numOfSellers];
        for (int i = 0; i < numOfSellers; i++) {
            tempSellers[i] = sellers[i].clone();
        }
        return tempSellers;
    }

    public Buyer[] getBuyers() throws CloneNotSupportedException {
        Buyer[] tempBuyers = new Buyer[numOfBuyers];
        for (int i = 0; i < numOfBuyers; i++) {
            tempBuyers[i] = buyers[i].clone();
        }
        return tempBuyers;
    }
}
