import java.util.Stack;

public class HistorialAcciones {

    private Stack<String> historial;


    public HistorialAcciones() {

        historial = new Stack<>();
    }

    public boolean registrarAccion(String accion) {
        if (accion == null || accion.isEmpty()) {
           return false;
        }
        historial.push(accion);
        return true;
    }

    public String obtenerUltimaAccion() {
        if (historial.isEmpty()){
            return "Sin Acciones";
        }
        return historial.peek();
    }

    public String deshacerAccion() {
        if (historial.isEmpty()) {
            return "Nada que deshacer";
        }
        return historial.pop();
    }

    public int obtenerCantidadAcciones() {
        return historial.size();
    }

    public boolean estaVacio() {
        return historial.isEmpty();
    }

    public String mostrarHistorial() {
        if (historial.isEmpty()) {
            return "Historial Vacio";
        }
        StringBuilder resultado= new StringBuilder();
        for (int i = historial.size()-1; i>=0 ; i--) {
            resultado.append(historial.get(i)).append("\n");
        }
        return resultado.toString();
    }
}
