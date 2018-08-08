package com.hubfintech.accountManager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hubfintech.accountManager.model.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Long>{
	Conta findByNome(String nome);
}
