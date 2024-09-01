package com.e_commerce;

import com.e_commerce.bl.components.Product;
import com.e_commerce.bl.components.ProductsCollection;
import com.e_commerce.bl.users.Buyer;
import com.e_commerce.bl.users.Seller;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Pini Shlomi At 21/07/2024
 */

@RestController
public class ECommerceController {

    @Autowired
    private final ECommerceService eCommerceService;

    public ECommerceController(ECommerceService eCommerceService) {
        this.eCommerceService = eCommerceService;
    }

    @PostMapping("/addSeller")
    public String addSeller(@RequestBody Seller seller) {
        return eCommerceService.addSeller(seller);
    }

    @PostMapping("/addBuyer")
    public String addBuyer(@RequestBody Buyer buyer) {
        return eCommerceService.addBuyer(buyer);
    }

    @PostMapping("/addProductToSeller/{sellerName}")
    public String addProductToSeller(@PathVariable String sellerName, @RequestBody Product product) {
        return eCommerceService.addProductToSeller(sellerName, product);
    }

    @PostMapping("/addProductToBuyer/{buyerName}")
    public String addProductToBuyer(@PathVariable String buyerName, @RequestBody Product product) {
        return eCommerceService.addProductToBuyer(buyerName, product);
    }

    @PutMapping("/pay/{buyerName}")
    public String payCart(@PathVariable String buyerName) {
        return eCommerceService.pay(buyerName);
    }

    @GetMapping("/getBuyers")
    public Buyer[] getBuyers() {
        return eCommerceService.getBuyers();
    }

    @GetMapping("/getSellers")
    public Seller[] getSellers() {
        return eCommerceService.getSellers();
    }

    @GetMapping("/getProducts/{category}")
    public Product[] getProductsByCategory(@PathVariable String category) {
        return eCommerceService.getProductsByCategory(category);
    }

}
