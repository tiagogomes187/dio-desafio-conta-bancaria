package br.dev.tiagogomes.desafiodio.entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public abstract class Conta implements IConta {

	private final static int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	private static Instant DATA_EXTRATO = Instant.now();

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Instant data;
	private Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.data = DATA_EXTRATO;
	}


	public int getAgencia() {
		return agencia;
	}


	public int getNumero() {
		return numero;
	}


	public double getSaldo() {
		return saldo;
	}

	public Instant getData() {
		return data;
	}

	public void sacar() {
	}

	public void depositar() {

	}

	public void transferir() {

	}

	@Override
	public void sacar(double valor) {
		this.saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	protected void imprimirInfosComuns() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Conta: %d", this.numero));
		System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
		System.out.println("Data: " + fmt.format(data));
		System.out.println();
	}
}
