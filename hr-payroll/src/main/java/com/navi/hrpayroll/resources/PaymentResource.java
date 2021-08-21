package com.navi.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navi.hrpayroll.entities.Payment;
import com.navi.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerid}/days/{dias}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerid, @PathVariable Integer dias){
		Payment payment = service.getPayment(workerid, dias);
		return ResponseEntity.ok().body(payment);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerid, Integer dias){
		Payment payment = new Payment("Bryam", 400.0, dias);
		return ResponseEntity.ok().body(payment);
	}
}
