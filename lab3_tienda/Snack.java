package lab3_tienda;

public class Snack extends Producto {
    private int gramos;
    private String sabor;
    private String tamaño;

    public Snack(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, double precio, int gramos, String sabor, String tamaño) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.gramos = gramos;
        this.sabor = sabor;
        this.tamaño = tamaño;
    }

    public int getGramos() {
        return gramos;
    }

    public String getSabor() {
        return sabor;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String getCategoria() {
        return "Snack";
    }

    public static Snack fromCSV(String csv) {
        Snack snack = (Snack) Producto.fromCSV(csv);
        if (snack != null) {
            String[] datos = csv.split(";");
            if (datos.length >= 9) {
                int gramos = Integer.parseInt(datos[6].trim());
                String sabor = datos[7].trim();
                String tamaño = datos[8].trim();
                snack.setGramos(gramos);
                snack.setSabor(sabor);
                snack.setTamaño(tamaño);
            }
        }
        return snack;
    }

    public String toCSV() {
        return super.toCSV() + String.format(";%d;%s;%s", gramos, sabor, tamaño);
    }
}