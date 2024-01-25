package br.dev.tiagogomes.desafiodio.entities;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupaca ===");
		imprimirInfosComuns();
	}

}
