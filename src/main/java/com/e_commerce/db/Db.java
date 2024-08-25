package com.e_commerce.db;

import com.e_commerce.bl.users.Buyer;
import com.e_commerce.bl.users.Seller;

/**
 * Created by Pini Shlomi At 23/08/2024
 */
public abstract class Db {
    abstract public void saveBuyers(Buyer[] buyers);

    abstract public Buyer[] readBuyers();

    abstract public void saveSellers(Seller[] sellers);

    abstract public Seller[] readSellers();
//    abstract public void saveSeller(Seller seller);
}
