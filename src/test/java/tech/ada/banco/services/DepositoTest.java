package tech.ada.banco.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import tech.ada.banco.model.Conta;
import tech.ada.banco.model.ModalidadeConta;
import tech.ada.banco.utils.LeitorTeclado;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

class DepositoTest {
    MockedStatic<LeitorTeclado> leitorTecladoMockedStatic;
    Deposito deposito = new Deposito();

    @BeforeEach
    void abrir() {
        System.out.println("Abrindo teste");
        leitorTecladoMockedStatic = Mockito.mockStatic(LeitorTeclado.class);
    }

    @AfterEach
    void fecharMockito() {
        leitorTecladoMockedStatic.close();
    }

    @Test
    void testeExecutarContaNull() {
        leitorTecladoMockedStatic.when(() -> LeitorTeclado.getNumero(anyString())).thenReturn(10);
        deposito.executar(null);
    }

    @Test
    void testeDeposito() {
        // Dado conta com 10 reais de saldo
        leitorTecladoMockedStatic.when(() -> LeitorTeclado.getNumero(anyString())).thenReturn(10);
        Conta conta = new Conta(ModalidadeConta.CONTA_CORRENTE, null);
        conta.deposito(BigDecimal.valueOf(5));

        // Executa deposito de 5 reais
        deposito.executar(conta);

        // O Saldo final deve ser 15 reais
        assertEquals(BigDecimal.valueOf(15), conta.getSaldo());
    }

    @Test
    void testeDepositoNegativo() {
        // Given
        leitorTecladoMockedStatic.when(() -> LeitorTeclado.getNumero(anyString())).thenReturn(-1);
        Conta conta = new Conta(ModalidadeConta.CONTA_CORRENTE, null);
        conta.deposito(BigDecimal.valueOf(1));

        // Then
        assertThrows(RuntimeException.class, () -> deposito.executar(conta));
        assertEquals(BigDecimal.valueOf(1), conta.getSaldo());
    }
}