package com.e_commerce;
import bl.users.Buyer;
import bl.users.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/post")
    public String post(@RequestBody String data) {
        return "POST request received with data: " + data;
    }
}
