package com.navi.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.navi.hrpayroll.entities.Payment;
import com.navi.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	public Payment getPayment(Long workerid, Integer dias) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerid);
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getNome(), worker.getValorPorDia(), dias);
	}
}
