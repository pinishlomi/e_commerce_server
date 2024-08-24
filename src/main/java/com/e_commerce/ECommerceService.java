package com.e_commerce;

import bl.components.Product;
import bl.general.Address;
import bl.general.Category;
import bl.mannage.Manage;
import bl.users.Buyer;
import bl.users.Seller;
import db.DbFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pini Shlomi At 21/07/2024
 */

@Service
public class ECommerceService {
    @Autowired
    private static Manage manage;

    public ECommerceService() {
        this.manage = new Manage();
        try {
            init();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void init() throws CloneNotSupportedException {
        DbFile dbFile = new DbFile();
//        initStartData(dbFile, manage);
        readFromFile(dbFile, manage);
    }

    private static void readFromFile(DbFile dbFile, Manage manage) throws CloneNotSupportedException {
        Seller[] sellers = dbFile.readSellers();
        for (Seller seller: sellers){
            manage.addSeller(seller);
        }

        Buyer[] buyers = dbFile.readBuyers();
        for (Buyer buyer: buyers){
            manage.addBuyer(buyer);
        }
    }

    public Buyer[] getBuyers() {
        try {
            return manage.getBuyers();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Seller[] getSellers() {
        try {
            return manage.getSellers();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    private static void initStartData(DbFile dbFile, Manage manage) throws CloneNotSupportedException {
        Seller[] sellers = {
                new Seller("Moshe Cohen", "123"),
                new Seller("Ofri Gilad", "114"),
                new Seller("David Barak", "241"),
                new Seller("Dor Azulay", "671"),
                new Seller("Yuval Dar", "982"),
        };
        Product[] products = {
                new Product("C01", "Building Blocks", 8.2, Category.CHILDREN, "https://c.media-amazon.com/images/I/71qdyT0I8DL._AC_SL1500_.jpg"),
                new Product("C02", "Dollhouse", 24.2, Category.CHILDREN, "https://images.squarespace-cdn.com/content/v1/53cee4fee4b0068e79bee0c4/1597516889263-V8DWS1UT71WE9UMM9WUH/IMG_5817.JPG"),
                new Product("C03", "Coloring Books", 1.2, Category.CHILDREN, "https://c.media-amazon.com/images/I/61mqoTWhYnL._SL1294_.jpg"),
                new Product("C04", "Play-Doh", 5.7, Category.CHILDREN, "https://digitalcontent.api.tesco.com/v2/media/ghs/524c0466-53c0-4cea-b984-df4a5b5b1f3a/db36d418-2a0c-4a56-b20f-413c16cd15f7_673834.jpeg"),
                new Product("C05", "Puzzles", 15.4, Category.CHILDREN, "https://c.media-amazon.com/images/I/81MSWbZ7ALL._AC_SL1500_.jpg"),
                new Product("E01", "Power Bank", 15.2, Category.ELECTRICITY, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTPEEXqYDtZ22nFeHk0xomIc2LRqdTYv23QKaUIlyNoQfLhvlHJde32ESYEgDY_"),
                new Product("E02", "Smart Light Bulb", 6.2, Category.ELECTRICITY, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSzSynlr92FmQjOZizBWDfczjfwBQfGfA4LR24i7MWSybu5AZiE9g9j7kOF0m9g"),
                new Product("E03", "Bluetooth Speaker", 31.5, Category.ELECTRICITY, "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcT483WPoK0y-LHdEMQ0XfuNLQHd7BRGezoraEEl_7wq4j7MVj_04-1fUXCbduu3"),
                new Product("E04", "Wireless Charger", 17.2, Category.ELECTRICITY, "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSOxjBwJbq6Gqg7NHQJyByrZEuArM7Ahd4CNiIngahWl7pbW4-q9ralXSif_FY7"),
                new Product("E05", "Smart Plug", 42.2, Category.ELECTRICITY, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsyAVirzlRHhwX8jDepUZx5RJQQF8H16UQusWmK0fXXrqg7jSB2iWvlaU8ODrL"),
                new Product("O01", "Notebook", 0.2, Category.OFFICE, "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcREUpFu8YyvPilyUJeJ4jEgR8XJxk3Vn6rNo4zLMntFkZqrqWopZif592XP-xWA"),
                new Product("O02", "Pens", 0.8, Category.OFFICE, "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRRNU-UsTMxcIZr1vYgLCkHIkLWh0jQ-NX3DVzg3vOrbn9TAkswAMyCa-saVatd"),
                new Product("O03", "Desk Organizer", 2.2, Category.OFFICE, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTU6q-RkFmPzmDxTRu8P0-kp6566JakALbbBj4EAyE5Uj-ACOPPcPmRgqAVpvMT"),
                new Product("O04", "Sticky Notes", 0.85, Category.OFFICE, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFpoOowYJkSmRdx8X0_vee_YGFWhu5unA3mWNrzRC3bfp-GXpeqB8vEyoU43wr"),
                new Product("O05", "Highlighter", 0.7, Category.OFFICE, "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcStBYP66X19s9OPOt-dezgInTDcXhw_sv1uV_uNCucqVIffM-fTqyjLWQPunt0O"),
                new Product("C11", "T-shirt", 3.2, Category.CLOTHING, "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSHlpiDdQknPYN-yhU_U6YHGSIpTzFXeXKJAvvmfnVptpbPjnhAstxTjnOXodqm"),
                new Product("C12", "Jeans", 13.2, Category.CLOTHING, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQ3G87F4oIcbMRfFebcOF0T7g6istjXuv_fjHTCdvauktQV_LWPTcZcAVTF10QB"),
                new Product("C13", "Dress", 6.7, Category.CLOTHING, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTTmMAzsLM3k1CILxrG76_vEuB9sOx3jdjMCVRQel5vHgnVmnEVaTQDNXiyyaic"),
                new Product("C14", "Socks", 2.09, Category.CLOTHING, "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTMHX4zb-rGPB6yQH_DaRq4bXoMBKfcdpK44ed36n33CQqDppbyOi5hHPfUtFNt"),
                new Product("C15", "Shoes", 17.64, Category.CLOTHING, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoV6Bx62MJrc3RdhBqNgzeMjWcxRzRCQnAd_E0cLnawDDv-X8QasCA91B51-Mw"),
        };
        sellers[0].addProduct(products[0]);
        sellers[0].addProduct(products[5]);
        sellers[0].addProduct(products[6]);
        sellers[0].addProduct(products[13]);
        sellers[0].addProduct(products[14]);
        sellers[0].addProduct(products[18]);
        sellers[1].addProduct(products[1]);
        sellers[1].addProduct(products[2]);
        sellers[1].addProduct(products[7]);
        sellers[1].addProduct(products[8]);
        sellers[1].addProduct(products[9]);
        sellers[2].addProduct(products[3]);
        sellers[2].addProduct(products[4]);
        sellers[2].addProduct(products[16]);
        sellers[2].addProduct(products[17]);

        for (Seller seller: sellers){
            manage.addSeller(seller);
        }

        Buyer[] buyers = {
                new Buyer("Yael Shalom", "123", new Address("Herzel", 44, "Tel Aviv", "Israel")),
                new Buyer("Barak Ben-David", "435", new Address("Golda Meir", 22, "Modiin", "Israel")),
                new Buyer("Dafna Shapira", "871", new Address("King Gorge", 154, "Jerusalem", "Israel")),
                new Buyer("Eran Katz", "346", new Address("Shalom", 7, "Tel Aviv", "Israel")),
                new Buyer("Idan Rosenberg", "438", new Address("Herzel", 25, "Hadera", "Israel")),
                new Buyer("Nimrod Gal", "142", new Address("David", 254, "Jerusalem", "Israel")),
                new Buyer("Keren Karmon", "203", new Address("Herzel", 28, "Jerusalem", "Israel")),
                new Buyer("Lea Shilo", "528", new Address("Shabazi", 181, "Tel Aviv", "Israel")),
        };
        buyers[0].addProduct(products[0]);
        buyers[0].addProduct(products[17]);
        buyers[1].addProduct(products[5]);
        buyers[1].addProduct(products[2]);

        for (Buyer buyer: buyers){
            manage.addBuyer(buyer);
        }
        dbFile.saveSellers(sellers);
        dbFile.saveBuyers(buyers);
    }

}
