package com.hubfintech.accountManager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubfintech.accountManager.model.Pessoa;
import com.hubfintech.accountManager.repository.PessoaRepository;
import com.hubfintech.accountManager.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {
	PessoaRepository pessoaRepository;
	
	@Autowired
	public PessoaServiceImpl(PessoaRepository pessoaRespository) {
		this.pessoaRepository = pessoaRespository;
	}
	public void guardarPessoa(Pessoa pessoa) {
		this.pessoaRepository.save(pessoa);
		
	}
	
	public List<Pessoa> listarPessoas() {
		return (List<Pessoa>) this.pessoaRepository.findAll();
	}
	public Pessoa obterPessoa(Long id) {
		return this.pessoaRepository.findById(id).get();
	}
	public void eliminarPessoa(Long id) {
		this.pessoaRepository.deleteById(id);
		
	}
	
	public Pessoa obterPessoaCpfCnpj(Long cpfCnpj) {
		return this.pessoaRepository.getByCpfCnpj(cpfCnpj);
	}
}
