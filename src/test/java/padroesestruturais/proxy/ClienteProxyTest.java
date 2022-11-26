package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClienteProxyTest {

    @BeforeEach
    void setUp() {
        BD.addCliente(new Cliente(123456789, "Godo Fredo", "Guarujá", 807.23f, 9991.1f));
        BD.addCliente(new Cliente(987654321, "Maria Joaquim", "Santana", 1001.10f, 0.21f));
        BD.addCliente(new Cliente(111111112, "Pedrito Ventura", "Las Venturas", 8765.87f, 90222.34f));
    }

    @Test
    void deveRetornarDadosCadastraisCliente() {
        ClienteProxy cliente = new ClienteProxy(987654321);
        assertEquals(Arrays.asList("Maria Joaquim", "Santana"), cliente.obterDadosCadastrais());
    }

    @Test
    void deveRetonarSaldosCliente() {
        Gerente gerente = new Gerente("Julião", true);
        ClienteProxy cliente = new ClienteProxy(123456789);
        assertEquals(Arrays.asList(807.23f, 9991.1f), cliente.obterSaldos(gerente));
    }

    @Test
    void deveRetonarExcecaoGerenteNaoAutorizadoConsultarSaldosCliente() {
        try {
            Gerente gerente = new Gerente("Luffy", false);
            ClienteProxy cliente = new ClienteProxy(111111112);
            cliente.obterSaldos(gerente);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Gerente não autorizado", e.getMessage());
        }
    }
}