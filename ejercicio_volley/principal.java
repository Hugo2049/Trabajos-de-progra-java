
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class principal {
    public static void main(String[] args) {
        plantilla ispjae = new plantilla();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de gestión de jugadores.");

        while (true) {
            System.out.println("1. Mostrar todos los jugadores inscritos en el torneo.");
            System.out.println("2. Los 3 mejores líberos.");
            System.out.println("3. La cantidad de pasadores con más de un 80% de efectividad.");
            System.out.println("4. Guardar catálogo en un archivo CSV");
            System.out.println("5. Cargar catálogo de un archivo CSV.");
            System.out.println("6. Agregar un nuevo jugador.");
            System.out.println("0. Salir");

            int opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 0) {
                break;  // Salir del bucle si el usuario elige 0
            } else if (opcion == 1) {
                // Mostrar todos los jugadores inscritos en el torneo
                List<jugador> jugadores = ispjae.obtenerJugadores();
                for (jugador jugador : jugadores) {
                    System.out.println(jugador);
                }
            } else if (opcion == 2) {
                 // Los 3 mejores líberos
                    List<jugador> jugadores = ispjae.obtenerJugadores();
                    List<libero> liberos = new ArrayList<>();
    
    // Filtra y obtén solo a los jugadores de tipo libero
                    for (jugador jugador : jugadores) {
                    if (jugador instanceof libero) {
                    liberos.add((libero) jugador); // Convierte jugador a libero
                    }
                }

    // Ordena la lista de liberos en función de su efectividad
                    Collections.sort(liberos, (l1, l2) -> Double.compare(l2.calcularEfectividad(), l1.calcularEfectividad()));

                    int contadorLiberos = 0;
                    for (libero libero : liberos) {
                    if (contadorLiberos < 3) {
                    System.out.println(libero);
                    contadorLiberos++;
                    }
                }
            } else if (opcion == 3) {
                // La cantidad de pasadores con más de un 80% de efectividad
                List<jugador> jugadores = ispjae.obtenerJugadores();
                int contadorPasadoresEfectivos = 0;
                for (jugador jugador : jugadores) {
                    if (jugador instanceof pasador && ((pasador)jugador).calcularEfectividad() > 80) {
                        contadorPasadoresEfectivos++;
                    }
                }
                System.out.println("Cantidad de pasadores con más de un 80% de efectividad: " + contadorPasadoresEfectivos);;
            } else if (opcion == 4) {
            } else if (opcion == 5) {



                //


/*  El cuatro y el cinco no loa hice porque sinceramente no comprendí como se hacea lo de el csv, por lo que realice un codigo
similar al anterior de herencia donde agrego yo los jugadores y los muetro. 
}*/

                //






            } else if (opcion == 6) {
                // Agregar un nuevo jugador
                System.out.println("Nombre del jugador: ");
                String nombre = teclado.nextLine();
                System.out.println("País del jugador: ");
                String pais = teclado.nextLine();
                System.out.println("Errores: ");
                int errores = teclado.nextInt();
                System.out.println("Aces: ");
                int aces = teclado.nextInt();
                System.out.println("Total de servicios: ");
                int totalServicios = teclado.nextInt();
                
                teclado.nextLine(); // Limpia el buffer de entrada
                
                System.out.println("Posición del jugador (libero/pasador/auxiliares): ");
                String posicion = teclado.nextLine();
                
                jugador nuevoJugador;
                
                if ("libero".equalsIgnoreCase(posicion)) {
                    System.out.println("Recibos efectivos: ");
                    int recibosEfectivos = teclado.nextInt();
                    nuevoJugador = new libero(nombre, pais, errores, aces, totalServicios, recibosEfectivos);
                } else if ("pasador".equalsIgnoreCase(posicion)) {
                    System.out.println("Pases efectivos: ");
                    int pasesEfectivos = teclado.nextInt();
                    System.out.println("Jugadas de engaño: ");
                    int jugadasDeEngaño = teclado.nextInt();
                    nuevoJugador = new pasador(nombre, pais, errores, aces, totalServicios, pasesEfectivos, jugadasDeEngaño);
                } else if ("auxiliares".equalsIgnoreCase(posicion)) {
                    System.out.println("Ataques efectivos: ");
                    int ataquesEfectivos = teclado.nextInt();
                    System.out.println("Bloqueos efectivos: ");
                    int bloqueosEfectivos = teclado.nextInt();
                    System.out.println("Bloqueos fallidos: ");
                    int bloqueosFallidos = teclado.nextInt();
                    nuevoJugador = new auxiliares(nombre, pais, errores, aces, totalServicios, ataquesEfectivos, bloqueosEfectivos, bloqueosFallidos);
                } else {
                    System.out.println("Posición no válida. Jugador no agregado.");
                    continue; // Ir al siguiente ciclo
                }
                
                ispjae.agregarJugador(nuevoJugador); // Agregar el jugador a la plantilla
                System.out.println("Jugador agregado con éxito.");
            }
        }

    teclado.close();
    }
}
