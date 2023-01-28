package tech.ada.banco.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tech.ada.banco.exceptions.SaldoInsuficienteException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class ContaTest {
    @Test
    void testeSaqueSaldoSuficiente() {
        Pessoa pessoa = Mockito.mock(Pessoa.class);
        Conta conta = new Conta(ModalidadeConta.CONTA_CORRENTE, pessoa);

        conta.deposito(BigDecimal.valueOf(10));

        conta.saque(BigDecimal.valueOf(1));

        assertEquals(BigDecimal.valueOf(9), conta.getSaldo());
    }

    @Test
    void testeSaqueSaldoInsuficiente() {
        Pessoa pessoa = Mockito.mock(Pessoa.class);
        Conta conta = new Conta(ModalidadeConta.CONTA_CORRENTE, pessoa);

        conta.deposito(BigDecimal.valueOf(1));

        assertThrows(SaldoInsuficienteException.class, () -> conta.saque(BigDecimal.valueOf(10)));
    }

    @Test
    void testeSaqueValorMenorQueZero() {
        Pessoa pessoa = Mockito.mock(Pessoa.class);
        Conta conta = new Conta(ModalidadeConta.CONTA_CORRENTE, pessoa);

        conta.deposito(BigDecimal.valueOf(100));

        assertThrows(RuntimeException.class, () -> conta.saque(BigDecimal.valueOf(-10)));
    }

    @Test
    void whenTest() {
        Pessoa pessoa = Mockito.mock(Pessoa.class);
        when(pessoa.getNome()).thenReturn("João");
    }
}