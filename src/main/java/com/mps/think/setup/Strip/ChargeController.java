package com.mps.think.setup.Strip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.Strip.ChargeRequest.Currency;
import com.mps.think.setup.vo.PublicKey;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Refund;

@RestController
public class ChargeController {

	@Autowired
	StripeService paymentsService;

//	@PostMapping("/charge")
//	public Charge charge(ChargeRequest chargeRequest, Model model) throws StripeException {
//		chargeRequest.setDescription("Example charge");
//		chargeRequest.setCurrency(Currency.EUR);
//		Charge charge = paymentsService.charge(chargeRequest);
//		model.addAttribute("id", charge.getId());
//		model.addAttribute("status", charge.getStatus());
//		model.addAttribute("chargeId", charge.getId());
//		model.addAttribute("balance_transaction", charge.getBalanceTransaction());
//		System.out.println(chargeRequest.toString());
//		System.out.println(charge.toString());
//		return charge;
//	}

	@ExceptionHandler(StripeException.class)
	public String handleError(Model model, StripeException ex) {
		model.addAttribute("error", ex.getMessage());
		return "result" + ex.getMessage();
	}

	@PostMapping("/chargeAPI")
	public ResponseEntity<?> chargeAPI(@RequestBody ChargeRequest chargeRequest) throws StripeException {
		chargeRequest.setDescription("Example charge");
		if (chargeRequest.getCurrency().EUR.toString() == "EUR") {
			chargeRequest.setCurrency(Currency.EUR);
		}
		chargeRequest.setCurrency(Currency.USD);
		Charge charge = paymentsService.charge(chargeRequest);
		PublicKey pk = new PublicKey();
		pk.setId(charge.getId());
		pk.setStatus(charge.getStatus());
		pk.setBalanceTransaction(charge.getBalanceTransaction());
		System.out.println(chargeRequest.toString());
		System.out.println(charge.toString());
		return ResponseEntity.ok(pk);
	}

	@PostMapping("/refundAPI")
	public ResponseEntity<?> refundAPI(String chargeId) throws StripeException {
//		Stripe.apiKey = "sk_test_FQFXEQMTnWlgu1ckpre5Ka4000VeYdxCdU";
//		Map<String, Object> params = new HashMap<>();
//		params.put("charge", chargeId);cus_NYjc8h13frsnR1
//		Refund refund = Refund.create(params);
		Refund refund = paymentsService.refund(chargeId);
		System.out.println(refund.toString());
		return ResponseEntity.ok(refund);
	}

}