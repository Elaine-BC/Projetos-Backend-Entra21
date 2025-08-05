package conta.subcontas;

import conta.Cliente;
import conta.ContaBancaria;
import conta.exception.SaldoInsuficienteException;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(Cliente titular, double saldo) {
        super(titular, saldo);
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > 0 && this.getSaldo() >= valor) {
            this.debitar(valor);
            System.out.println("Saque realizado com sucesso na conta poupança!");
        } else {
            throw new SaldoInsuficienteException("O saldo ou o limite são insuficientes ou o valor é inválido!");
        }
    }

    public void renderJuros(double taxa) {
        if (taxa > 0) {
            double rendimento = super.getSaldo() * taxa;
            super.creditar(rendimento);
            System.out.println("Rendimento: R$ " + rendimento);
        }
    }
}
