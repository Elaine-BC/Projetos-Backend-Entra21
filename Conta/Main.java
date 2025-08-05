import conta.Cliente;
import conta.ContaBancaria;
import conta.subcontas.ContaCorrente;
import conta.subcontas.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        ContaBancaria contaCorrente = new ContaCorrente(
                new Cliente("Ronyeri", "123.456.789-10"), 0.0, 10.0
        );

        ContaPoupanca contaPoupanca = new ContaPoupanca(
                new Cliente("Maria", "109.876.543-21"), 0.0
        );

        Banco banco = new Banco();

        banco.depositar(contaCorrente, 20.0);
        banco.depositar(contaPoupanca, 10.0);

        banco.sacar(contaCorrente, 10.0);
        banco.sacar(contaPoupanca, 10.0);

        System.out.println("Saldo na conta corrente: R$ " + contaCorrente.getSaldo());
        System.out.println("Saldo na conta poupança: R$ " + contaPoupanca.getSaldo());
    }
}