package conta;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(String titular, double saldo) {
        super(titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            this.debitar(valor);
            System.out.println("Saque realizado com sucesso na conta poupança!");
        } else {
            System.out.println("O saldo é insuficiente ou o valor solicitado é inválido!");
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
