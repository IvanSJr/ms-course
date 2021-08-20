package com.navi.hrpayroll.entities;

import java.io.Serializable;


public class Worker implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Double valorPorDia;
	
	public Worker() {
		
	}
	
	public Worker(Long id, String nome, Double valorPorDia) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorPorDia = valorPorDia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValorPorDia() {
		return valorPorDia;
	}

	public void setValorPorDia(Double valorPorDia) {
		this.valorPorDia = valorPorDia;
	}
	
	
}
