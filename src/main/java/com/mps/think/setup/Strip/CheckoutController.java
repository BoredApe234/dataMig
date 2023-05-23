package com.mps.think.setup.Strip;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.vo.PublicKey;

@RestController
public class CheckoutController {

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

//    @RequestMapping("/checkout")
//    public String checkout(Model model) {
//        model.addAttribute("amount", 50 * 100); // in cents
//        model.addAttribute("stripePublicKey", stripePublicKey);
//        model.addAttribute("currency", ChargeRequest.Currency.EUR);
//        return "checkout";
//    }
    
    // Get Public  key to start the Transition 1st API for Strip  call 
    @GetMapping("/checkOutThePublicKey")
    public  ResponseEntity<?> checkOutThePublicKey() {
    	PublicKey pk= new PublicKey();
    	pk.setStrippublick(stripePublicKey);
        return ResponseEntity.ok(pk);
    }
  
    
}