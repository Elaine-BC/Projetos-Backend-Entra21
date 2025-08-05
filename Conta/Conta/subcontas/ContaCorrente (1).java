package conta.subcontas;

import conta.Cliente;
import conta.ContaBancaria;
import conta.Tributavel;
import conta.exception.SaldoInsuficienteException;

import java.util.Objects;

public class ContaCorrente extends ContaBancaria implements Tributavel {
    private double limite;

    public ContaCorrente(Cliente titular, double saldo, double limite) {
        super(titular, saldo);
        this.limite = limite;
    }

    public void ajustarLimite(double novoLimite) {
        this.limite = novoLimite;
    }

    @Override
    public double calcularTributo() {
        return super.getSaldo() * 0.01;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > 0 && (super.getSaldo() + this.limite) >= valor) {
            super.debitar(valor);
            System.out.println("Saque realizado com sucesso na conta corrente!");
        } else {
           throw new SaldoInsuficienteException("O saldo ou o limite são insuficientes ou o valor é inválido!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ContaCorrente that = (ContaCorrente) o;
        return Double.compare(limite, that.limite) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), limite);
    }
}
