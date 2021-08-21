package com.navi.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navi.hrpayroll.entities.Payment;
import com.navi.hrpayroll.entities.Worker;
import com.navi.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	
	@Autowired
	private WorkerFeignClient workFeignClient;
	
	public Payment getPayment(Long workerid, Integer dias) {
		
		Worker worker = workFeignClient.findById(workerid).getBody();	
		return new Payment(worker.getNome(), worker.getValorPorDia(), dias);
	}
}
