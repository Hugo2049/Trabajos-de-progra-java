import java.util.Scanner;
import java.util.Collections;
import java.util.List;

public class Principal {
    public static void main(String[] args){
        Plantilla ispjae = new Plantilla();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de gestión de jugadores.");

        while (true) {
            System.out.println("¿Qué tipo de jugador desea agregar?");
            System.out.println("1. Extremo");
            System.out.println("2. Portero");
            System.out.println("3. Mostrar todos los jugadores");
            System.out.println("4. Mostrar los 3 mejores porteros por efectividad");
            System.out.println("5. Mostrar cantidad de extremos con más de un 85% de efectividad");
            System.out.println("0. Salir");
            
            int opcion = teclado.nextInt();
            teclado.nextLine();  

            if (opcion == 0) {
                break;  // Salir del bucle si el usuario elige 0
            } else if (opcion == 1 || opcion == 2) {
                System.out.print("Nombre: ");
                String nombre = teclado.nextLine();
                System.out.print("Pais: ");
                String pais = teclado.nextLine();
                System.out.print("Faltas: ");
                int faltas = teclado.nextInt();
                System.out.print("Goles directos: ");
                int golesdirectos = teclado.nextInt();
                System.out.print("Total de lanzamientos: ");
                int totaldelanzamientos = teclado.nextInt();
                teclado.nextLine();  // Limpiar el buffer de entrada

                double efectividad = 0.0;

                if (opcion == 1) {
                    System.out.print("Pases: ");
                    int pases = teclado.nextInt();
                    System.out.print("Asistencias efectivas: ");
                    int assistenciasefectivas = teclado.nextInt();
                    efectividad = ((pases + assistenciasefectivas) * 100) / (pases + assistenciasefectivas);
                    ispjae.agregarJugador(nombre, pais, faltas, golesdirectos, totaldelanzamientos, pases, assistenciasefectivas, 0, 0, opcion);
                } else if (opcion == 2) {
                    System.out.print("Paradas efectivas: ");
                    int paradasefectivas = teclado.nextInt();
                    System.out.print("Goles recibidos: ");
                    int golesrecibidos = teclado.nextInt();
                    efectividad = ((paradasefectivas - golesrecibidos) * 100) / (paradasefectivas + golesrecibidos);
                    ispjae.agregarJugador(nombre, pais, faltas, golesdirectos, totaldelanzamientos, 0, 0, paradasefectivas, golesrecibidos, opcion);
                }

                System.out.println("Efectividad del jugador: " + efectividad + "%");
                System.out.println("Jugador agregado con éxito.");
            } else if (opcion == 3) {
                System.out.println("Lista de todos los jugadores:");
                ispjae.mostrarJugadores();
            } else if (opcion == 4) {
                List<Portero> porteros = ispjae.getJugadoresPorteros();

                // Ordenar la lista de porteros en función de su efectividad (de mayor a menor)
                Collections.sort(porteros, (p1, p2) -> Double.compare(p2.efectividadJugador(), p1.efectividadJugador()));

                System.out.println("Los 3 mejores porteros por efectividad:");

                int numPorterosAMostrar = Math.min(3, porteros.size());
                for (int i = 0; i < numPorterosAMostrar; i++) {
                    Portero portero = porteros.get(i);
                    System.out.println("Nombre: " + portero.getNombre() + ", Efectividad: " + portero.efectividadJugador() + "%");
                }
            } else if (opcion == 5) {
                int extremosCon85MasEfectividad = contarExtremosCon85MasEfectividad(ispjae);
                System.out.println("Cantidad de extremos con más de un 85% de efectividad: " + extremosCon85MasEfectividad);
            } else {
                System.out.println("Opción no válida. Por favor, elija 1 para Extremo, 2 para Portero, 3 para mostrar jugadores, 4 para mostrar los 3 mejores porteros por efectividad, 5 para mostrar cantidad de extremos con más de un 85% de efectividad o 0 para salir.");
            }
        }

        teclado.close(); // Cierra el Scanner cuando hayas terminado de usarlo.
    }

    // Método para contar extremos con más de un 85% de efectividad
    private static int contarExtremosCon85MasEfectividad(Plantilla plantilla) {
        int contador = 0;
        for (Extremo extremo : plantilla.getJugadoresExtremos()) {
            if (extremo.efectividadJugador() > 85.0) {
                contador++;
            }
        }
        return contador;
    }
}