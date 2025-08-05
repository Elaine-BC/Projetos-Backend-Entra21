import conta.Cliente;
import conta.ContaBancaria;
import conta.exception.SaldoInsuficienteException;
import conta.exception.ValorInvalidoException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Banco {
    private final Set<ContaBancaria> contas = new HashSet<>();

    public void abrirConta(ContaBancaria contaBancaria) {
        this.contas.add(contaBancaria);
    }

    public void cancelarConta(ContaBancaria contaBancaria) {
        this.contas.remove(contaBancaria);
    }

    public ContaBancaria buscarContaPorCpf(String cpf) {
        return this.contas
                .stream()
                .filter(contaBancaria -> contaBancaria.getTitular().cpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }

    public void imprimirInformacoesDosClientes() {
        Set<Cliente> clientes = this.contas
                .stream()
                .map(ContaBancaria::getTitular)
                .collect(Collectors.toSet());
    }

    public void sacar(ContaBancaria conta, double valor) {
        try {
            conta.sacar(valor);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Não foi possível realizar o saque: " + e.getMessage());
        } finally {
            System.out.println("Finalizando operação de saque...");
        }
    }

    public void depositar(ContaBancaria conta, double valor) {
        try {
            conta.depositar(valor);
        } catch (ValorInvalidoException e) {
            System.out.println("Não foi possível realizar o depósito: " + e.getMessage());
        } finally {
            System.out.println("Finalizando operação de depósito...");
        }
    }
}
