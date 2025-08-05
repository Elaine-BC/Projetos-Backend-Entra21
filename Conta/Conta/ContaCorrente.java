package conta;

public class ContaCorrente extends ContaBancaria implements Tributavel {
    private double limite;

    public ContaCorrente(String titular, double saldo, double limite) {
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
    public void sacar(double valor) {
        if (valor > 0 && (super.getSaldo() + this.limite) >= valor) {
            super.debitar(valor);
            System.out.println("Saque realizado com sucesso na conta corrente!");
        } else {
            System.out.println("O saldo ou o limite são insuficientes ou o valor é inválido!");
        }
    }
}
