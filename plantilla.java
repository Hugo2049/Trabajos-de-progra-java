import java.util.ArrayList;
import java.util.List;

public class plantilla {
    private List<jugador> jugadores;

    public plantilla() {
        jugadores = new ArrayList<jugador>();
    }

    // Método para agregar un jugador a la plantilla
    public void agregarJugador(jugador nuevoJugador) {
        jugadores.add(nuevoJugador);
    }

    // Otros métodos y operaciones relacionadas con la plantilla

    // Obtener todos los jugadores de la plantilla
    public List<jugador> obtenerJugadores() {
        return jugadores;
    }
}
