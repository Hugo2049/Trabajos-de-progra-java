import java.util.ArrayList;
import java.util.List;

public class Plantilla {
    private ArrayList<Extremo> jugadoresextremos;
    private ArrayList<Portero> jugadoresporteros;

    public Plantilla(){
        jugadoresextremos = new ArrayList<Extremo>();
        jugadoresporteros = new ArrayList<Portero>();
    }

    public void agregarJugador(String nombre, String pais, int faltas, int golesdirectos, int totaldelanzamientos,int pases, int assistenciasefectivas, int paradasefectivas, int golesrecibidos, int tipoJugador  ){
        switch (tipoJugador) {
            case 1:
            Extremo ext = new Extremo( nombre,  pais,  faltas,  golesdirectos,  totaldelanzamientos, pases,  assistenciasefectivas);
            jugadoresextremos.add(ext);
            break;
            case 2:
            Portero port = new Portero(nombre,  pais,  faltas,  golesdirectos,  totaldelanzamientos,  paradasefectivas,  golesrecibidos);
            jugadoresporteros.add(port);
            break;
        }
    }

    public void mostrarJugadores() {
        System.out.println("Lista de Extremos:");
        for (Extremo extremo : jugadoresextremos) {
            System.out.println(extremo.toString());
        }
    
        System.out.println("\nLista de Porteros:");
        for (Portero portero : jugadoresporteros) {
            System.out.println(portero.toString());
        }
    }

    public List<Portero> getJugadoresPorteros() {
        return jugadoresporteros;
    }

    public List<Extremo> getJugadoresExtremos() {
        return jugadoresextremos;
    }
}

