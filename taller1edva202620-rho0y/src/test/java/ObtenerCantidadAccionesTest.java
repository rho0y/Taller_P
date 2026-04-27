import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObtenerCantidadAccionesTest {

    private HistorialAcciones historial;

    @BeforeEach
    public void setUp() {
        historial = new HistorialAcciones();
    }

    @Test
    public void deberiaIniciarConCeroAcciones() {
        assertEquals(0, historial.obtenerCantidadAcciones());
    }

    @Test
    public void deberiaContarAccionesRegistradas() {
        historial.registrarAccion("Escribió Hola");
        historial.registrarAccion("Pegó imagen");
        historial.registrarAccion("Cambió título");

        assertEquals(3, historial.obtenerCantidadAcciones());
    }
}
