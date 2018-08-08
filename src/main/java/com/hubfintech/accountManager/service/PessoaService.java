package com.hubfintech.accountManager.service;

import java.util.List;

import com.hubfintech.accountManager.model.Pessoa;

public interface PessoaService {
	public void guardarPessoa(Pessoa pessoaFisica);
	public List<Pessoa> listarPessoas();
	public Pessoa obterPessoa(Long id);
	public void eliminarPessoa(Long id);
	public Pessoa obterPessoaCpfCnpj(Long cpfCnpj);
}
