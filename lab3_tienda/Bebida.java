package lab3_tienda;

public class Bebida extends Producto {
    private int ml;
    private String tipo;

    public Bebida(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, double precio, int ml, String tipo) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.ml = ml;
        this.tipo = tipo;
    }

    public int getMl() {
        return ml;
    }

    public String getTipo() {
        return tipo;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getCategoria() {
        return "Bebida";
    }

    public static Bebida fromCSV(String csv) {
        String[] datos = csv.split(";");
        if (datos.length >= 8) {
            int id = Integer.parseInt(datos[0].trim());
            String nombre = datos[1].trim();
            int cantidadDisponible = Integer.parseInt(datos[2].trim());
            int cantidadVendidos = Integer.parseInt(datos[3].trim());
            String estado = datos[4].trim();
            double precio = Double.parseDouble(datos[5].trim());
            int ml = Integer.parseInt(datos[7].trim());
            String tipo = datos[8].trim();
    
            return new Bebida(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, ml, tipo);
        }
        return null;
    }

    public String toCSV() {
        return super.toCSV() + String.format(";%d;%s", ml, tipo);
    }
}