import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObtenerUltimaAccionTest {

    private HistorialAcciones historial;

    @BeforeEach
    public void setUp() {
        historial = new HistorialAcciones();
    }

    @Test
    public void deberiaObtenerUltimaAccionSinEliminarla() {
        historial.registrarAccion("Escribió Hola");
        historial.registrarAccion("Pegó imagen");

        assertEquals("Pegó imagen", historial.obtenerUltimaAccion());
        assertEquals(2, historial.obtenerCantidadAcciones());
    }

    @Test
    public void deberiaRetornarMensajeSiNoHayUltimaAccion() {
        assertEquals("Sin acciones", historial.obtenerUltimaAccion());
    }
}
