package ada.banco.exceptions;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException() {
        super("Limite acima do saldo disponível!");
    }
}
