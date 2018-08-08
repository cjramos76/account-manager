package com.hubfintech.accountManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
{
"id" : "1001",
"cpf" : "236014728560001",
"razaoSocial" : "razon social 1",
"nomeFantasia" : "nome fantasia 1"
}
*/

@SuppressWarnings("serial")
@Table(name="PESSOA_JURIDICA")
@Entity
public class PessoaJuridica extends Pessoa {
	
	@Column(name="NOME_FANTASIA")
	private String nomeFantasia;

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}
