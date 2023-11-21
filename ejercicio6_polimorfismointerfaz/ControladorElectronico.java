package ejercicio6_polimorfismointerfaz;


import java.util.List;
import java.util.Scanner;

public class ControladorElectronico {
    private List<Dispositivo> dispositivos;
    private Dispositivo dispositivoSeleccionado;
    private Scanner scanner;

    public ControladorElectronico(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("----- Menú -----");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Elegir número de producto");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // 

            switch (opcion) {
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    elegirNumeroDeProducto();
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (opcion != 3);
    }

    private void mostrarProductos() {
        System.out.println("----- Productos Disponibles -----");
        for (int i = 0; i < dispositivos.size(); i++) {
            Dispositivo dispositivo = dispositivos.get(i);
            System.out.println((i + 1) + ". " + dispositivo.getDescripcion());
        }
    }

    private void elegirNumeroDeProducto() {
        mostrarProductos();
        System.out.print("Elija el número de producto: ");
        int numeroProducto = scanner.nextInt();
        if (numeroProducto >= 1 && numeroProducto <= dispositivos.size()) {
            dispositivoSeleccionado = dispositivos.get(numeroProducto - 1);
            mostrarMenuDispositivo();
        } else {
            System.out.println("Número de producto no válido.");
        }
    }

    private void mostrarMenuDispositivo() {
        int opcion;
        do {
            System.out.println("----- Menú del Dispositivo -----");
            System.out.println("1. Encender");
            System.out.println("2. Apagar");
            System.out.println("3. Subir Volumen");
            System.out.println("4. Bajar Volumen");
            System.out.println("5. Aumentar Brillo");
            System.out.println("6. Disminuir Brillo");
            System.out.println("7. Visualizar Acciones Permitidas");
            System.out.println("8. Mostrar Información");
            System.out.println("9. Mostrar Estado");
            System.out.println("10. Controlar Videos");
            System.out.println("11. Volver al menú anterior");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    dispositivoSeleccionado.encender();
                    break;
                case 2:
                    dispositivoSeleccionado.apagar();
                    break;
                case 3:
                    dispositivoSeleccionado.subirVolumen();
                    break;
                case 4:
                    dispositivoSeleccionado.bajarVolumen();
                    break;
                case 5:
                    dispositivoSeleccionado.aumentarBrillo();
                    break;
                case 6:
                    dispositivoSeleccionado.disminuirBrillo();
                    break;
                case 7:
                    dispositivoSeleccionado.visualizarAccionesPermitidas();
                    break;
                case 8:
                    dispositivoSeleccionado.mostrarInformacion();
                    break;
                case 9:
                    dispositivoSeleccionado.mostrarEstado();
                    break;
                case 10:
                    dispositivoSeleccionado.controlarVideos();
                    break;
                case 11:
                    dispositivoSeleccionado = null;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (opcion != 11);
    }

    public static void main(String[] args) {
        // Carga tus dispositivos desde el archivo CSV
        List<Dispositivo> dispositivos = cargarDispositivosDesdeCSV();

        ControladorElectronicoMenu menu = new ControladorElectronicoMenu(dispositivos);
        menu.mostrarMenu();
    }

    // Método ficticio para cargar dispositivos desde un archivo CSV
    private static List<Dispositivo> cargarDispositivosDesdeCSV() {
        // Implementa la carga de dispositivos desde el archivo CSV aquí
        // Retorna una lista de dispositivos cargados
        return null;
    }
}