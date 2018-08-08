package com.hubfintech.accountManager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubfintech.accountManager.model.Conta;
import com.hubfintech.accountManager.repository.ContaRepository;
import com.hubfintech.accountManager.service.ContaService;

@Service
public class ContaServiceImpl implements ContaService {
	ContaRepository contaRepository;

	@Autowired
	public ContaServiceImpl(ContaRepository contaRespository) {
		this.contaRepository = contaRespository;
	}

	public void guardarConta(Conta conta) {
		this.contaRepository.save(conta);

	}

	public List<Conta> listarContas() {
		return (List<Conta>) this.contaRepository.findAll();
	}

	public Conta obterConta(Long id) {
		return this.contaRepository.findById(id).get();
	}

	public Conta obterContaPorNombre(String nome) {
		return this.contaRepository.findByNome(nome);
	}

	public void eliminarConta(Long id) {
		this.contaRepository.deleteById(id);

	}

	public void transferirSaldo(Conta contaFonte, Conta contaDestino, Float saldo) {
		boolean esFilha = esFilha(contaDestino, contaFonte);
		if (esFilha) {
			contaDestino.setSaldo(contaDestino.getSaldo() + saldo);
			contaFonte.setSaldo(contaFonte.getSaldo() - saldo);
			this.contaRepository.save(contaDestino);
			this.contaRepository.save(contaFonte);
		}
	}

	private boolean esFilha(Conta contaDestino, Conta contaFonte) {
		if (contaFonte != null && contaFonte.getContaPai() != null) {
			if (contaDestino.getNome() == contaFonte.getNome()) {
				return true;
			} else {
				return esFilha(contaDestino, this.contaRepository.findByNome(contaFonte.getContaPai().getNome()));
			}
		} else {
			return false;
		}
	}

}
