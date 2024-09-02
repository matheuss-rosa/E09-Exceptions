import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Cliente joao = new PessoaFisica("João", "Av. Antonio Carlos, 6627", new Date(), "111.111.111-11", 36, 'm');
        Cliente lojinha = new PessoaJuridica("Loja R$1,99", "Av. Afonso Pena, 3000", new Date(), "000.00000.0000/0001", 25, "Comércio");

        Conta cc = new ContaCorrente(1234, joao, 0, 1500);
        Conta cp = new ContaUniversitaria(12121, lojinha, 10000, 1500);

        boolean correto = false;
        while (!correto) {
            System.out.println("Valor do depósito");
            double valor = entrada.nextDouble();

            try {
                cc.depositar(valor);
                correto = true;
            } catch (ValorNegativoException exception) {
                System.out.println("Nao foi possivel realizar o depósito");
                System.out.println(exception.getMessage());
            }
        }

        correto = false;

        while (!correto) {

            System.out.println("Valor do saque");
            double valor = entrada.nextDouble();

            try {
                    cc.sacar(valor);
                correto = true;

            } catch (ValorNegativoException | SemLimiteException exception) {
                    System.out.println("Nao foi possivel realizar o saque");

                System.out.println(exception.getMessage());
            }
        }
    }
}
