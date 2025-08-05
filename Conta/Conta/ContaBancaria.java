package conta;

import conta.exception.SaldoInsuficienteException;
import conta.exception.ValorInvalidoException;

import java.util.Objects;

public abstract class ContaBancaria {
    private final Cliente titular;
    private double saldo;

    protected ContaBancaria(Cliente titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public abstract void sacar(double valor) throws SaldoInsuficienteException;

    public void depositar(double valor) {
        if (valor > 0) {
            System.out.println("Depósito na conta de: " + this.titular.nome());
            this.creditar(valor);
        } else {
            throw new ValorInvalidoException("O valor para depósito deve ser positivo e maior que zero!");
        }
    }

    protected void debitar(double valor) {
        this.saldo -= valor;
    }

    protected void creditar(double valor) {
        this.saldo += valor;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContaBancaria that = (ContaBancaria) o;
        return Double.compare(saldo, that.saldo) == 0 && Objects.equals(titular, that.titular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titular, saldo);
    }
}
