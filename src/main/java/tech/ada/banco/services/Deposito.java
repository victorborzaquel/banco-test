package tech.ada.banco.services;

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
        if (valor < 0) {
            throw new IllegalArgumentException("Valor do depósito não pode ser negativo.");
        }
        // Etapa 4
        try {
            conta.deposito(BigDecimal.valueOf(valor));
            System.out.println("O saldo da conta é de: R$" + conta.getSaldo());
        } catch (Exception e) {
            System.err.println("Depósito não pode ser efetuado.");
        }
    }
}
