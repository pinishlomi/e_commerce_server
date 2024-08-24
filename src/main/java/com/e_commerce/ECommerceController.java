package com.e_commerce;
import bl.users.Buyer;
import bl.users.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Pini Shlomi At 21/07/2024
 */

@RestController
public class ECommerceController {

    @Autowired
    private ECommerceService eCommerceService;

    @GetMapping("/getBuyers")
    public Buyer[] getBuyers() {
        return eCommerceService.getBuyers();
    }

    @GetMapping("/getSellers")
    public Seller[] getSellers() {
        return eCommerceService.getSellers();
    }

    @PostMapping("/addSeller")
    public String post(@RequestBody Seller seller) {
        return eCommerceService.addSeller(seller);
    }
}
