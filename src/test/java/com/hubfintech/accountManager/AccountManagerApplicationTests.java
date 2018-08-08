package com.hubfintech.accountManager;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hubfintech.accountManager.model.Conta;
import com.hubfintech.accountManager.model.Pessoa;
import com.hubfintech.accountManager.model.PessoaFisica;
import com.hubfintech.accountManager.model.PessoaJuridica;
import com.hubfintech.accountManager.service.ContaService;
import com.hubfintech.accountManager.service.PessoaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountManagerApplicationTests {

	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	ContaService contaService;
	
	@Test
	public void inserirPessoaJuridica() {
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		long cpfCnpj = new Random().nextLong();
		pessoaJuridica.setCpfCnpj(cpfCnpj);
		pessoaJuridica.setNomeFantasia("Nome Fantasia " + new Random().nextInt());
		pessoaJuridica.setNome("Razon Social " + new Random().nextInt());
		this.pessoaService.guardarPessoa(pessoaJuridica);
		
		Pessoa pessoa = this.pessoaService.obterPessoaCpfCnpj(cpfCnpj);
		assertEquals(pessoaJuridica.getNome(), pessoa.getNome());
	}

	@Test
	public void inserirPessoaFisica() throws ParseException {
		PessoaFisica pessoaFisica = new PessoaFisica();
		long cpfCnpj = new Random().nextLong();
		pessoaFisica.setCpfCnpj(cpfCnpj);
		pessoaFisica.setDataNascimento((new SimpleDateFormat("YYYY/mm/DD").parse("1976/03/17")));
		pessoaFisica.setNome("miguel " + new Random().nextInt());
		this.pessoaService.guardarPessoa(pessoaFisica);

		Pessoa pessoa = this.pessoaService.obterPessoaCpfCnpj(cpfCnpj);
		assertEquals(pessoaFisica.getNome(), pessoa.getNome());
	}
	
	@Test 
	public void inserirConta() throws ParseException {
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setCpfCnpj(new Random().nextLong());
		pessoaFisica.setDataNascimento((new SimpleDateFormat("YYYY/mm/DD").parse("1976/03/17")));
		pessoaFisica.setNome("Carlos Jose Ramos Miguel");
		Conta conta = new Conta();
		conta.setDataCriacao((new SimpleDateFormat("YYYY/mm/DD").parse("2017/03/17")));
		conta.setNome("conta inicial");
		conta.setPessoa(pessoaFisica);
		this.contaService.guardarConta(conta);
	
	}
	
	@Test
	public void inserirContaPessoa() throws Exception {
		PessoaFisica pessoaFisica = (PessoaFisica)criarPessoaFisica();
		Pessoa pessoaInserida = this.pessoaService.obterPessoaCpfCnpj(pessoaFisica.getCpfCnpj());
		Conta conta = new Conta();
		conta.setDataCriacao((new SimpleDateFormat("YYYY/mm/DD").parse("2017/03/17")));
		conta.setNome("conta " + new Random().nextInt());
		conta.setPessoa(pessoaInserida);
		this.contaService.guardarConta(conta);
		
	}
	
	@Test
	public void transferirSaldo() throws Exception {
		PessoaFisica pessoaFisica = (PessoaFisica)criarPessoaFisica();
		Pessoa pessoaInserida = this.pessoaService.obterPessoaCpfCnpj(pessoaFisica.getCpfCnpj());
		float saldoPaiOriginal = 100;
		Conta contaPai = new Conta();
		contaPai.setDataCriacao((new SimpleDateFormat("YYYY/mm/DD").parse("2017/03/17")));
		String nomeContaPai = "conta " + new Random().nextInt();
		contaPai.setNome(nomeContaPai);
		contaPai.setPessoa(pessoaInserida);
		contaPai.setSaldo(100);
		this.contaService.guardarConta(contaPai);
		
		float saldoFilhaOriginal = 50;
		Conta contaFilha = new Conta();
		contaFilha.setDataCriacao((new SimpleDateFormat("YYYY/mm/DD").parse("2017/03/17")));
		contaFilha.setNome("conta " + new Random().nextInt());
		contaFilha.setPessoa(pessoaInserida);
		contaFilha.setSaldo(50);
//		contaFilha.setContaPai(this.contaService.obterContaPorNombre(nomeContaPai));
		contaFilha.setContaPai(contaPai);
																																																																											
		this.contaService.guardarConta(contaFilha);
		
		float saldo = 10;
		
		this.contaService.transferirSaldo(contaPai, contaFilha, saldo);
		
		Conta newContaPai = this.contaService.obterContaPorNombre(contaPai.getNome());
		Conta newContaFilha = this.contaService.obterContaPorNombre(contaFilha.getNome());
		boolean saldoCorreto = contaPai.getSaldo() == saldoPaiOriginal - 10 && 
				contaFilha.getSaldo() == saldoFilhaOriginal + 10; 
		System.out.println("newContaPai.getSaldo(): " + newContaPai.getSaldo());
		System.out.println("contaPai.getSaldo(): " + contaPai.getSaldo());
		System.out.println("newContaFilha.getSaldo(): " + newContaFilha.getSaldo());
		System.out.println("contaFilha.getSaldo(): " + contaFilha.getSaldo());
		assertEquals(saldoCorreto, Boolean.TRUE);
		
		
	}
	
	private Pessoa criarPessoaFisica() throws Exception {
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setCpfCnpj(new Random().nextLong());
		pessoaFisica.setDataNascimento((new SimpleDateFormat("YYYY/mm/DD").parse("1976/03/17")));
		pessoaFisica.setNome("miguel " + new Random().nextInt());
		this.pessoaService.guardarPessoa(pessoaFisica);
		return pessoaFisica;
	}

}
