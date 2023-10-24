package lab3_tienda;

public class Bebida extends Producto {
    private int mililitros;
    private String tipo;

    public Bebida() {
        super();
        mililitros = 0;
        tipo = "";
    }

    public Bebida(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, double precio, int mililitros, String tipo) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.mililitros = mililitros;
        this.tipo = tipo;
    }

    public int getMililitros() {
        return mililitros;
    }

    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Bebida {" +
            super.toString() +
            ", mililitros='" + mililitros + "'" +
            ", tipo='" + tipo + "'" +
            "}";
    }
}
