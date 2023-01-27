import ada.banco.services.Deposito;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositoTest {
    @Test
    void testeExecutarContaNull() {
        Deposito deposito = new Deposito();
        deposito.executar(null);
        assertThrows(IllegalArgumentException.class, () -> deposito.executar(null));
    }
}