package lab3_tienda;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public List<Producto> listarProductosDeCategoria(String categoria) {
        List<Producto> productosCategoria = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                productosCategoria.add(producto);
            }
        }
        return productosCategoria;
    }

    public double calcularVentasTotales() {
        double ventasTotales = 0;
        for (Producto producto : productos) {
            ventasTotales += producto.getCantidadVendidos() * producto.getPrecio();
        }
        return ventasTotales;
    }

    public double calcularComisionPorCategoria(String categoria) {
        double comision = 0;
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                comision += producto.getPrecio() * 0.2;
            }
        }
        return comision;
    }
}
