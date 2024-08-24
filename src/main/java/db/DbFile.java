package db;

import bl.users.Buyer;
import bl.users.Seller;

import java.io.*;

/**
 * Created by Pini Shlomi At 23/08/2024
 */
public class DbFile extends Db{
    private static final String BUYERS_FILENAME = "buyers.dat";
    private static final String SELLERS_FILENAME = "sellers.dat";
    private final String filePath;

    public DbFile() {
        String packagePath = getClass().getPackage().getName().replace('.', File.separatorChar);
        filePath = System.getProperty("user.dir") + File.separator + "src"
                + File.separator + "main" + File.separator + "resources"+ File.separator + "db" + File.separator;
    }

    @Override
    public void saveBuyers(Buyer[] buyers){
        ObjectOutputStream file;
        try {
            file = new ObjectOutputStream(new FileOutputStream(filePath + BUYERS_FILENAME));
            file.writeObject(buyers);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Buyer[] readBuyers() {
        ObjectInputStream file;
        try {
            file = new ObjectInputStream(new FileInputStream(filePath + BUYERS_FILENAME));
            Buyer[] buyers = (Buyer[])file.readObject();
            file.close();
            return buyers;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveSellers(Seller[] sellers){
        ObjectOutputStream file;
        try {
            file = new ObjectOutputStream(new FileOutputStream(filePath + SELLERS_FILENAME));
            file.writeObject(sellers);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Seller[] readSellers() {
        ObjectInputStream file;
        try {
            file = new ObjectInputStream(new FileInputStream(filePath + SELLERS_FILENAME));
            Seller[] sellers = (Seller[])file.readObject();
            file.close();
            return sellers;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public void saveSeller(Seller seller) {
//        ObjectOutputStream file;
//        try {
//            file = new ObjectOutputStream(new FileOutputStream(filePath + SELLERS_FILENAME, true));
//            file.writeObject(seller);
//            file.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
