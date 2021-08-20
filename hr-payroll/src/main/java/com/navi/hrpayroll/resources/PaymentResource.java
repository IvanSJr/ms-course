package com.navi.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navi.hrpayroll.entities.Payment;
import com.navi.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	@Autowired
	private PaymentService service;
	
	@GetMapping(value = "/{workerid}/days/{dias}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerid, @PathVariable Integer dias){
		Payment payment = service.getPayment(workerid, dias);
		return ResponseEntity.ok().body(payment);
	}
}
