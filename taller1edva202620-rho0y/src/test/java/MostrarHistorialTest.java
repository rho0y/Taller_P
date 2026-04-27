import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MostrarHistorialTest {

    private HistorialAcciones historial;

    @BeforeEach
    public void setUp() {
        historial = new HistorialAcciones();
    }

    @Test
    public void deberiaMostrarHistorialConTodasLasAcciones() {
        historial.registrarAccion("Escribió Hola");
        historial.registrarAccion("Pegó imagen");
        historial.registrarAccion("Cambió título");

        String resultado = historial.mostrarHistorial();

        assertTrue(resultado.contains("Escribió Hola"));
        assertTrue(resultado.contains("Pegó imagen"));
        assertTrue(resultado.contains("Cambió título"));
    }

    @Test
    public void deberiaMostrarMensajeSiHistorialEstaVacio() {
        assertEquals("Historial vacío", historial.mostrarHistorial());
    }
}
