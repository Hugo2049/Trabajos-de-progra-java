package lab3_tienda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventarioApp {
    public static void main(String[] args) {
        List<Producto> inventario = new ArrayList<>();
        cargarProductosDesdeCSV(inventario, "productos.csv");

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Menú de Inventario ===");
            System.out.println("1. Buscar producto por ID");
            System.out.println("2. Listar productos de una categoría");
            System.out.println("3. Mostrar ventas totales");
            System.out.println("4. Calcular comisión por categoría");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del producto a buscar: ");
                    int idABuscar = scanner.nextInt();
                    Producto productoBuscado = buscarProductoPorId(inventario, idABuscar);
                    if (productoBuscado != null) {
                        System.out.println("Producto encontrado: " + productoBuscado.getNombre());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la categoría a listar (Bebida, Juguetes, Snack): ");
                    String categoria = scanner.next();
                    listarProductosDeCategoria(inventario, categoria);
                    break;
                case 3:
                    double ventasTotales = calcularVentasTotales(inventario);
                    System.out.println("Ventas totales: Q" + ventasTotales);
                    break;
                case 4:
                    System.out.print("Ingrese la categoría para calcular la comisión (Bebida, Juguetes, Snack): ");
                    String categoriaComision = scanner.next();
                    double comision = calcularComisionPorCategoria(inventario, categoriaComision);
                    System.out.println("Comisión por la categoría " + categoriaComision + ": Q" + comision);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void cargarProductosDesdeCSV(List<Producto> inventario, String archivoCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            // Leer la primera línea para omitirla (encabezados)
            br.readLine();
            while ((linea = br.readLine()) != null) {
                Producto producto = Producto.fromCSV(linea.replace(";", "|"));
                if (producto != null) {
                    inventario.add(producto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void listarProductosDeCategoria(List<Producto> inventario, String categoria) {
        System.out.println("Listado de productos de la categoría " + categoria + ":");
        for (Producto producto : inventario) {
            if (categoria.equals(producto.getCategoria())) {
                System.out.println(producto.getNombre());
            }
        }
    }

    private static Producto buscarProductoPorId(List<Producto> inventario, int id) {
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    private static double calcularVentasTotales(List<Producto> inventario) {
        double ventasTotales = 0;
        for (Producto producto : inventario) {
            ventasTotales += producto.getCantidadVendidos() * producto.getPrecio();
        }
        return ventasTotales;
    }

    private static double calcularComisionPorCategoria(List<Producto> inventario, String categoria) {
        double comision = 0;
        for (Producto producto : inventario) {
            if (categoria.equals(producto.getCategoria())) {
                comision += producto.getPrecio() * 0.2;
            }
        }
        return comision;
    }
}