package lab3_tienda;

public class Juguetes extends Producto {
    private String material;
    private String marca;

    public Juguetes(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, double precio, String material, String marca) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.material = material;
        this.marca = marca;
    }

    public String getMaterial() {
        return material;
    }

    public String getMarca() {
        return marca;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String getCategoria() {
        return "Juguetes";
    }

    public static Juguetes fromCSV(String csv) {
        Juguetes juguete = (Juguetes) Producto.fromCSV(csv);
        if (juguete != null) {
            String[] datos = csv.split(";");
            if (datos.length >= 8) {
                String material = datos[6].trim();
                String marca = datos[7].trim();
                juguete.setMaterial(material);
                juguete.setMarca(marca);
            }
        }
        return juguete;
    }
    

    public String toCSV() {
        return super.toCSV() + String.format(";%s;%s", material, marca);
    }
}