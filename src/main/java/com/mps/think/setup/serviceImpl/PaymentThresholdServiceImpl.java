package com.mps.think.setup.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.PaymentThreshold;
import com.mps.think.setup.repo.PaymentThresholdRepo;
import com.mps.think.setup.service.PaymentThresholdService;
import com.mps.think.setup.vo.PaymentThresholdVO;
@Service
public class PaymentThresholdServiceImpl implements PaymentThresholdService {

	@Autowired
	PaymentThresholdRepo paymentThresholdRepo;

	@Override
	public List<PaymentThreshold> getAllPaymentThresholdForPublisher(Integer pubId) {
		return paymentThresholdRepo.findByPublisherId(pubId);
	}

	@Override
	public PaymentThreshold savePaymentThreshold(PaymentThresholdVO paymentThresholdVO) {
		ObjectMapper obj = new ObjectMapper();
		PaymentThreshold pThreshold = obj.convertValue(paymentThresholdVO, PaymentThreshold.class);
		PaymentThreshold threshold = paymentThresholdRepo.saveAndFlush(pThreshold);
		return threshold;
	}

	@Override
	public PaymentThreshold updatePaymentThreshold(PaymentThresholdVO paymentThresholdVO) {
		ObjectMapper obj = new ObjectMapper();
		PaymentThreshold pThreshold = obj.convertValue(paymentThresholdVO, PaymentThreshold.class);
		PaymentThreshold threshold = paymentThresholdRepo.saveAndFlush(pThreshold);
		return threshold;
	}

	@Override
	public Optional<PaymentThreshold> findByPaymentThresholdId(Integer id) {
		return paymentThresholdRepo.findById(id);
	}

	@Override
	public HashMap<String, String> definePayment(double invoiceAmount, double paidAmount, Integer paymentThresholdId) {
		HashMap<String, String> payment = new HashMap<String, String>();
		PaymentThreshold threshold = paymentThresholdRepo.findById(paymentThresholdId).get();

		double paidPercentage = (paidAmount * 100) / invoiceAmount;
		double unPaidAmount = Math.abs(invoiceAmount - paidAmount);
		if (paidPercentage <= threshold.getPartialThreshold()) {
			System.out.println("1 Partial payments");
			payment.put("paymentStatus", "Partial payments");
			return payment;
		} else if (paidPercentage > threshold.getPartialThreshold() && paidPercentage < threshold.getUnderThreshold()) {
			if ((int) unPaidAmount <= threshold.getMaxUnderpaymentForPartial()) {
				System.out.println("2 Under payments");
				payment.put("paymentStatus", "Under payments");
				return payment;
			}
			System.out.println("3 Partial payments");
			payment.put("paymentStatus", "Partial payments");
			return payment;
		} else if (paidPercentage >= threshold.getUnderThreshold() && paidPercentage <= threshold.getOverThreshold()) {
			if ((int) unPaidAmount <= threshold.getMaxUnderpaymentForFull()) {
				System.out.println("4 Full payments");
				payment.put("paymentStatus", "Full payments");
				return payment;
			} else if ((int) unPaidAmount > threshold.getMaxUnderpaymentForPartial()) {
				System.out.println("7 Partial payments");
				payment.put("paymentStatus", "Partial payments");
				return payment;
			}
			System.out.println("5 Under payments");
			payment.put("paymentStatus", "Under payments");
			return payment;

		} else if (paidPercentage > threshold.getOverThreshold() && paidPercentage <= threshold.getRefundThreshold()) {
			if ((int) unPaidAmount <= threshold.getMaxOverpaymentForFull()) {
				System.out.println("6 Full payments");
				payment.put("paymentStatus", "Full payments");
				return payment;
			} else if ((int) unPaidAmount > threshold.getMaxOverpaymentForRefund()) {
				System.out.println("7 Refund payments");
				payment.put("paymentStatus", "Refund payments");
				return payment;
			}
			System.out.println("8 Over payments");
			payment.put("paymentStatus", "Over payments");
			return payment;
		} else if (paidPercentage > threshold.getRefundThreshold()) {
			System.out.println("9 Refund payments");
			payment.put("paymentStatus", "Refund payments");
			return payment;
		}
		payment.put("paymentStatus", "Not have vaild payment");
		return payment;
	}

	@Override
	public PaymentThreshold findByPaymentThresholdDefId(Integer id) {
		return paymentThresholdRepo.findByPaymentThresholdDefId(id);
	}
}
