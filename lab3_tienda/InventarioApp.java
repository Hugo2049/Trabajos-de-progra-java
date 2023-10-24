package lab3_tienda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventarioApp {
    public static void main(String[] args) {
        List<Producto> inventario = new ArrayList<>();

        // Cargar productos desde un archivo CSV
        cargarProductosDesdeCSV(inventario, "productos.csv");

        // Listar productos por categoría (por ejemplo, Bebidas)
        listarProductosDeCategoria(inventario, Bebida.class);

        // Buscar un producto por ID
        Producto productoBuscado = buscarProductoPorId(inventario, 1);
        if (productoBuscado != null) {
            System.out.println("Producto encontrado: " + productoBuscado.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }

        // Calcular ventas totales
        double ventasTotales = calcularVentasTotales(inventario);
        System.out.println("Ventas totales: Q" + ventasTotales);

        // Calcular comisión para la categoría de Juguetes
        double comisionJuguetes = calcularComisionPorCategoria(inventario, Juguetes.class);
        System.out.println("Comisión por la categoría de Juguetes: Q" + comisionJuguetes);
    }

    private static void cargarProductosDesdeCSV(List<Producto> inventario, String archivoCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length >= 7) {
                    int id = Integer.parseInt(datos[0].trim());
                    String nombre = datos[1].trim();
                    int cantidadDisponible = Integer.parseInt(datos[2].trim());
                    int cantidadVendidos = Integer.parseInt(datos[3].trim());
                    String estado = datos[4].trim();
                    double precio = Double.parseDouble(datos[5].trim());
                    String categoria = datos[6].trim();

                    Producto producto;

                    switch (categoria) {
                        case "Bebidas":
                            int ml = Integer.parseInt(datos[7].trim());
                            String tipo = datos[8].trim();
                            producto = new Bebida(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, ml, tipo);
                            break;
                        case "Snacks":
                            int gramos = Integer.parseInt(datos[9].trim());
                            String sabor = datos[10].trim();
                            String tamaño = datos[11].trim();
                            producto = new Snack(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, gramos, sabor, tamaño);
                            break;
                        case "Juguetes":
                            String material = datos[7].trim();
                            String marca = datos[8].trim();
                            producto = new Juguetes(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, material, marca);
                            break;
                        default:
                            producto = new Producto(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
                            break;
                    }

                    inventario.add(producto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listarProductosDeCategoria(List<Producto> inventario, Class<? extends Producto> categoria) {
        System.out.println("Listado de productos de la categoría " + categoria.getSimpleName() + ":");
        for (Producto producto : inventario) {
            if (categoria.isInstance(producto)) {
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

    private static double calcularComisionPorCategoria(List<Producto> inventario, Class<? extends Producto> categoria) {
        double comision = 0;
        for (Producto producto : inventario) {
            if (categoria.isInstance(producto)) {
                comision += producto.getPrecio() * 0.2; // 20% de comisión
            }
        }
        return comision;
    }
}
