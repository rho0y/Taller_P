import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeshacerAccionTest {

    private HistorialAcciones historial;

    @BeforeEach
    public void setUp() {
        historial = new HistorialAcciones();
    }

    @Test
    public void deberiaDeshacerUltimaAccion() {
        historial.registrarAccion("Escribió Hola");
        historial.registrarAccion("Borró línea");

        assertEquals("Borró línea", historial.deshacerAccion());
        assertEquals(1, historial.obtenerCantidadAcciones());
        assertEquals("Escribió Hola", historial.obtenerUltimaAccion());
    }

    @Test
    public void deberiaRetornarMensajeSiNoHayNadaQueDeshacer() {
        assertEquals("Nada que deshacer", historial.deshacerAccion());
    }
}
