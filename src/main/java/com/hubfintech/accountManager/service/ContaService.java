package com.hubfintech.accountManager.service;

import java.util.List;
import java.util.Optional;

import com.hubfintech.accountManager.model.Conta;

public interface ContaService {
	void guardarConta(Conta conta);
	List<Conta> listarContas();
	Conta obterConta(Long id);
	void eliminarConta(Long id);
	void transferirSaldo(Conta contaDestino, Conta contaInicial, Float saldo);
	Conta obterContaPorNombre(String nome);
}
