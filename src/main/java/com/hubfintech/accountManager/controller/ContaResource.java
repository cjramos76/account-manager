package com.hubfintech.accountManager.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hubfintech.accountManager.model.Conta;
import com.hubfintech.accountManager.service.ContaService;

@Controller
public class ContaResource {
	ContaService contaService;
	
	@Autowired
	public ContaResource(ContaService contaSerice) {
		this.contaService = contaSerice;
	}
	
	@PostMapping("/conta")
	public ResponseEntity<Conta> guardarConta(@RequestBody Conta conta) {
		this.contaService.guardarConta(conta);
		ResponseEntity<Conta> response = new ResponseEntity<Conta>(conta, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(path="/conta", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Conta>> listarContas() {
		List<Conta> listaConta = this.contaService.listarContas();
		ResponseEntity<List<Conta>> response = new ResponseEntity<List<Conta>>(listaConta, HttpStatus.OK);
		return response;
		
	}
	
	@GetMapping("/conta/{id}")
	public ResponseEntity<Conta> obterConta(@PathVariable Long id) {
		ResponseEntity<Conta> response = null;
		try {
			Conta conta = this.contaService.obterConta(id);
			response = new ResponseEntity<Conta>(conta, HttpStatus.OK);

		} catch (NoSuchElementException nseex) {
			response = new ResponseEntity<Conta>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@DeleteMapping("/conta/{id}")
	public ResponseEntity<Long> eliminarConta(Long id) {
		this.contaService.eliminarConta(id);
		ResponseEntity<Long> response = new ResponseEntity<Long>(id, HttpStatus.OK);
		return response;
	}

}
