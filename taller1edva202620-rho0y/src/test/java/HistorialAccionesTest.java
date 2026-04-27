import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HistorialAccionesTest {

    private HistorialAcciones historial;

    @BeforeEach
    public void setUp() {
        historial = new HistorialAcciones();
    }

    @Test
    public void deberiaIniciarVacio() {
        assertTrue(historial.estaVacio());
        assertEquals(0, historial.obtenerCantidadAcciones());
    }

    @Test
    public void deberiaRegistrarAccionValida() {
        assertTrue(historial.registrarAccion("Escribió Hola"));
        assertEquals(1, historial.obtenerCantidadAcciones());
        assertFalse(historial.estaVacio());
    }

    @Test
    public void noDeberiaRegistrarAccionNulaOVacia() {
        assertFalse(historial.registrarAccion(null));
        assertFalse(historial.registrarAccion(""));
        assertFalse(historial.registrarAccion("   "));
        assertEquals(0, historial.obtenerCantidadAcciones());
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
