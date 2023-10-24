package lab3_tienda;

public class Juguetes extends Producto {
    private String material;
    private String marca;

    public Juguetes() {
        super();
        material = "";
        marca = "";
    }

    public Juguetes(int id, String nombre, int cantidadDisponible, int cantidadVendidos, String estado, double precio, String material, String marca) {
        super(id, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.material = material;
        this.marca = marca;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Juguetes {" +
            super.toString() +
            ", material='" + material + "'" +
            ", marca='" + marca + "'" +
            "}";
    }
}
