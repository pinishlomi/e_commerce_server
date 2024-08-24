package db;

import bl.users.Buyer;
import bl.users.Seller;

/**
 * Created by Pini Shlomi At 23/08/2024
 */
public abstract class Db {
    abstract public void saveBuyers(Buyer[] buyers);

    abstract public Buyer[] readBuyers();

    abstract public void saveSellers(Seller[] buyers);

    abstract public Seller[] readSellers();
}
