package lab3_tienda;

public abstract class Producto {
    private int id;
    private String nombre;
    private int cantidadDisponible;
    private int cantidadVendidos;
    private String estado;
    private double precio;

    public Producto(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadVendidos = cantidadVendidos;
        this.estado = estado;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public int getCantidadVendidos() {
        return cantidadVendidos;
    }

    public String getEstado() {
        return estado;
    }

    public double getPrecio() {
        return precio;
    }

    public abstract String getCategoria();

    public static Producto fromCSV(String csv) {
        String[] datos = csv.split(";");
        if (datos.length >= 7) {
            int id = Integer.parseInt(datos[0].trim());
            String nombre = datos[1].trim();
            int cantidadDisponible = Integer.parseInt(datos[2].trim());
            int cantidadVendidos = Integer.parseInt(datos[3].trim());
            String estado = datos[4].trim();
            double precio = Double.parseDouble(datos[5].trim());
            String categoria = datos[6].trim();
    
            if (categoria.equals("Bebida")) {
                return Bebida.fromCSV(csv);
            } else if (categoria.equals("Juguetes")) {
                return Juguetes.fromCSV(csv);
            } else if (categoria.equals("Snack")) {
                return Snack.fromCSV(csv);
            }
        }
        return null;
    }

    public String toCSV() {
        return String.format("%d;%s;%d;%d;%s;%.2f;%s", id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, getCategoria());
    }
}