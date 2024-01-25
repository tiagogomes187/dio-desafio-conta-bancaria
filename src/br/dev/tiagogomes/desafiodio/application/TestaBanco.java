package br.dev.tiagogomes.desafiodio.application;

import br.dev.tiagogomes.desafiodio.entities.Cliente;
import br.dev.tiagogomes.desafiodio.entities.Conta;
import br.dev.tiagogomes.desafiodio.entities.ContaCorrente;
import br.dev.tiagogomes.desafiodio.entities.ContaPoupanca;

public class TestaBanco {
	public static void main(String[] args) {

		Cliente tiago = new Cliente();
		tiago.setNome("Tiago Gomes");

		Conta cc = new ContaCorrente(tiago);
		cc.depositar(100);


		Conta cp = new ContaPoupanca(tiago);
		cc.transferir(20, cp);
		cp.depositar(850);

		cc.imprimirExtrato();
		cp.imprimirExtrato();
	}
}
