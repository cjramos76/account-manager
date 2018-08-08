package com.hubfintech.accountManager.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hubfintech.accountManager.model.Pessoa;
import com.hubfintech.accountManager.service.PessoaService;

@Controller
public class PessoaResource {
	PessoaService pessoaService;
	
	@Autowired
	public PessoaResource(PessoaService pessoaSerice) {
		this.pessoaService = pessoaSerice;
	}
	
	@PostMapping("/pessoa")
	public ResponseEntity<Pessoa> guardarPessoa(@RequestBody Pessoa pessoa) {
		this.pessoaService.guardarPessoa(pessoa);
		ResponseEntity<Pessoa> response = new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/pessoa")
	public ResponseEntity<List<Pessoa>> listarPessoas() {
		List<Pessoa> listaPessoa = this.pessoaService.listarPessoas();
		ResponseEntity<List<Pessoa>> response = new ResponseEntity<List<Pessoa>>(listaPessoa, HttpStatus.OK);
		return response;
		
	}
	
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> obterPessoa(@PathVariable Long id) {
		ResponseEntity<Pessoa> response = null;
		try {
			Pessoa pessoa = this.pessoaService.obterPessoa(id);
			response = new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);

		} catch (NoSuchElementException nseex) {
			response = new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@DeleteMapping("/pessoa/{id}")
	public ResponseEntity<Long> eliminarPessoa(Long id) {
		this.pessoaService.eliminarPessoa(id);
		ResponseEntity<Long> response = new ResponseEntity<Long>(id, HttpStatus.OK);
		return response;
	}

}
