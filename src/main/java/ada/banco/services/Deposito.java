package ada.banco.services;

import tech.ada.banco.model.Conta;
import tech.ada.banco.utils.LeitorTeclado;

import java.math.BigDecimal;

public class Deposito {

    public void executar() {
        // Etapa 1
        int numeroConta = LeitorTeclado.getNumero("Digite um número de conta.");

        executar(numeroConta);
    }

    public void executar(int numeroConta) {
        // Etapa 2
        Conta conta = Conta.obtemContaPeloNumero(numeroConta);

        executar(conta);
    }

    public void executar(Conta conta) {
        // Etapa 3
        int valor = LeitorTeclado.getNumero("Digite o valor que será depositado.");
        executar(conta, valor);
    }

    public void executar(Conta conta, int valor) {
        // Etapa 4
        conta.deposito(BigDecimal.valueOf(valor));
        System.out.println("O saldo da conta é de: R$" + conta.getSaldo());
    }
}
