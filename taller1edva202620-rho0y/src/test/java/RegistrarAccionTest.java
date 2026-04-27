import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrarAccionTest {

    private HistorialAcciones historial;

    @BeforeEach
    public void setUp() {
        historial = new HistorialAcciones();
    }

    @Test
    public void deberiaRegistrarAccionValida() {
        assertTrue(historial.registrarAccion("Escribió Hola"));
        assertEquals(1, historial.obtenerCantidadAcciones());
        assertEquals("Escribió Hola", historial.obtenerUltimaAccion());
    }

    @Test
    public void noDeberiaRegistrarAccionNulaOVacia() {
        assertFalse(historial.registrarAccion(null));
        assertFalse(historial.registrarAccion(""));
        assertFalse(historial.registrarAccion("   "));
        assertEquals(0, historial.obtenerCantidadAcciones());
    }
}
