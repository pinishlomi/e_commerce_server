package com.e_commerce.bl.users;

import com.e_commerce.bl.components.Cart;
import com.e_commerce.bl.components.Product;
import com.e_commerce.bl.general.Address;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Pini Shlomi At 07/06/2024
 */
public class Buyer extends User implements Serializable, Cloneable {
    private Address address;

    private Cart cart;
    private Cart[] history;
    private int numOfCarts;
    public Buyer(String name, String password, Address address) throws CloneNotSupportedException {
        super(name, password);
        this.address = address.clone();
        cart = new Cart();
        history = new Cart[2];
    }

    public Cart getCart() {
        return cart;
    }

    public Cart[] getHistory() {
        return history;
    }

    public int getNumOfCarts() {
        return numOfCarts;
    }

    public String getName() {
        return getUserName();
    }

    public Address getAddress() throws CloneNotSupportedException {
        return address.clone();
    }

    public boolean addProduct(Product p) {
        return cart.addProduct(p);
    }

    public double pay() throws CloneNotSupportedException {
        cart.setBuyDate(new Date());
        double totalPrice = cart.getPrice();
        addCartToHistory();
        cart = new Cart();
        return totalPrice;
    }

    private void addCartToHistory() throws CloneNotSupportedException {
        if (numOfCarts == history.length) {
            history = Arrays.copyOf(history, history.length * 2);
        }
        history[numOfCarts++] = cart.clone();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ")
                .append(getUserName())
                .append(", Password: ")
                .append(getPassword())
                .append("\n");
        if (cart.isEmpty()) {
            sb.append("Cart is empty...");
        } else {
            sb.append("Current cart:\n");
            sb.append(cart);
        }
        sb.append("\n");
        if (numOfCarts == 0) {
            sb.append("No history yet...\n");
        } else {
            sb.append("History carts:\n");
            for (int i = 0; i < numOfCarts; i++) {
                sb.append(history[i]);
            }
        }
        return sb.toString();
    }

    @Override
    public Buyer clone() throws CloneNotSupportedException {
        Buyer buyer = (Buyer) super.clone();
        buyer.address = address.clone();
        return buyer;
    }


    public boolean isCartEmpty() {
        return cart.isEmpty();
    }
}
