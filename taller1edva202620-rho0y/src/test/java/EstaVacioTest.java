import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstaVacioTest {

    private HistorialAcciones historial;

    @BeforeEach
    public void setUp() {
        historial = new HistorialAcciones();
    }

    @Test
    public void deberiaEstarVacioAlInicio() {
        assertTrue(historial.estaVacio());
    }

    @Test
    public void noDeberiaEstarVacioDespuesDeRegistrar() {
        historial.registrarAccion("Escribió Hola");
        assertFalse(historial.estaVacio());
    }
}
