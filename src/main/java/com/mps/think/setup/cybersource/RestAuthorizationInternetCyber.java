package com.mps.think.setup.cybersource;

import java.util.Properties;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybersource.authsdk.core.MerchantConfig;

import Api.PaymentsApi;
import Invokers.ApiClient;
import Model.CreatePaymentRequest;
import Model.PtsV2PaymentsPost201Response;
import Model.Ptsv2paymentsClientReferenceInformation;
import Model.Ptsv2paymentsOrderInformation;
import Model.Ptsv2paymentsOrderInformationAmountDetails;
import Model.Ptsv2paymentsOrderInformationBillTo;
import Model.Ptsv2paymentsPaymentInformation;
import Model.Ptsv2paymentsPaymentInformationCard;
import Model.Ptsv2paymentsProcessingInformation;

@RestController
public class RestAuthorizationInternetCyber {
	private static String responseCode = null;
	private static String status = null;
	private static Properties merchantProp;
	public static boolean userCapture = false;

	@PostMapping("/paymentCybersource")
	public ResponseEntity<PtsV2PaymentsPost201Response> paymentCybersource(
			@RequestBody CyberSourceRequest cyberSourceRequest) {

		CreatePaymentRequest requestObj = new CreatePaymentRequest();

		Ptsv2paymentsClientReferenceInformation clientReferenceInformation = new Ptsv2paymentsClientReferenceInformation();
//		clientReferenceInformation.code("TC50171_3");TC50171_3
		clientReferenceInformation.code("think_mpstest");
		requestObj.clientReferenceInformation(clientReferenceInformation);

		Ptsv2paymentsProcessingInformation processingInformation = new Ptsv2paymentsProcessingInformation();
		processingInformation.capture(false);
		if (userCapture) {
			processingInformation.capture(true);
		}

		requestObj.processingInformation(processingInformation);

		Ptsv2paymentsPaymentInformation paymentInformation = new Ptsv2paymentsPaymentInformation();
		Ptsv2paymentsPaymentInformationCard paymentInformationCard = new Ptsv2paymentsPaymentInformationCard();
//		paymentInformationCard.number("4111111111111111");
//		paymentInformationCard.expirationMonth("12");
//		paymentInformationCard.expirationYear("2031");
		paymentInformationCard.number(cyberSourceRequest.getNumber());
		paymentInformationCard.expirationMonth(cyberSourceRequest.getExpirationMonth());
		paymentInformationCard.expirationYear(cyberSourceRequest.getExpirationYear());
		paymentInformation.card(paymentInformationCard);

		requestObj.paymentInformation(paymentInformation);

		Ptsv2paymentsOrderInformation orderInformation = new Ptsv2paymentsOrderInformation();
		Ptsv2paymentsOrderInformationAmountDetails orderInformationAmountDetails = new Ptsv2paymentsOrderInformationAmountDetails();
//		orderInformationAmountDetails.totalAmount("102.21");
//		orderInformationAmountDetails.currency("USD");
		orderInformationAmountDetails.totalAmount(cyberSourceRequest.getTotalAmount());
		orderInformationAmountDetails.currency(cyberSourceRequest.getCurrency());
		orderInformation.amountDetails(orderInformationAmountDetails);

		Ptsv2paymentsOrderInformationBillTo orderInformationBillTo = new Ptsv2paymentsOrderInformationBillTo();
//		orderInformationBillTo.firstName("John");
//		orderInformationBillTo.lastName("Doe");
//		orderInformationBillTo.address1("1 Market St");
//		orderInformationBillTo.locality("san francisco");
//		orderInformationBillTo.administrativeArea("CA");
//		orderInformationBillTo.postalCode("94105");
//		orderInformationBillTo.country("US");
//		orderInformationBillTo.email("test@cybs.com");
//		orderInformationBillTo.phoneNumber("4158880000");
		orderInformationBillTo.firstName(cyberSourceRequest.getFirstName());
		orderInformationBillTo.lastName(cyberSourceRequest.getLastName());
		orderInformationBillTo.address1(cyberSourceRequest.getAddress1());
		orderInformationBillTo.locality(cyberSourceRequest.getLocality());
		orderInformationBillTo.administrativeArea(cyberSourceRequest.getAdministrativeArea());
		orderInformationBillTo.postalCode(cyberSourceRequest.getPostalCode());
		orderInformationBillTo.country(cyberSourceRequest.getCountry());
		orderInformationBillTo.email(cyberSourceRequest.getEmail());
		orderInformationBillTo.phoneNumber(cyberSourceRequest.getPhoneNumber());
		orderInformation.billTo(orderInformationBillTo);

		requestObj.orderInformation(orderInformation);

		PtsV2PaymentsPost201Response result = null;
		try {
			merchantProp = Configuration.getMerchantDetails();
			ApiClient apiClient = new ApiClient();
			MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
			apiClient.merchantConfig = merchantConfig;

			PaymentsApi apiInstance = new PaymentsApi(apiClient);
			result = apiInstance.createPayment(requestObj);

			responseCode = apiClient.responseCode;
			status = apiClient.status;
			System.out.println("ResponseCode :" + responseCode);
			System.out.println("ResponseMessage :" + status);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(result);
	}
}
