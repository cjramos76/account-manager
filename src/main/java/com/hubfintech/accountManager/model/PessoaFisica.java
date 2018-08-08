package com.hubfintech.accountManager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
{
"id" : "1000",
"cpf" : "23601472856",
"nome" : "carlos jose ramos miguel",
"dataNascimento" : "1976-03-17 00:00:00"
}
*/

@SuppressWarnings("serial")
@Table(name="PESSOA_FISICA")
@Entity
public class PessoaFisica extends Pessoa {
	
	@Column(name="DATA_NASCIMENTO")
	private Date dataNascimento;
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

}
