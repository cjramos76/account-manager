package com.hubfintech.accountManager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hubfintech.accountManager.model.Pessoa;
import com.hubfintech.accountManager.model.PessoaFisica;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
	public Pessoa getByCpfCnpj(Long cpfCnpj);
}
