package com.navi.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.navi.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	public Payment getPayment(Long workerid, Integer dias) {
		return new Payment("Ivan", 200.00, dias);
	}
}
