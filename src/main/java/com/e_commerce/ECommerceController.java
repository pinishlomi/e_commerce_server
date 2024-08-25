package com.e_commerce;
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
    private ECommerceService eCommerceService;

    public ECommerceController(ECommerceService eCommerceService) {
        this.eCommerceService = eCommerceService;
    }

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

    @PutMapping("/pay/{buyerName}/payCart")
    public String payCart(@PathVariable String buyerName){
        return eCommerceService.pay(buyerName);
    }
}
