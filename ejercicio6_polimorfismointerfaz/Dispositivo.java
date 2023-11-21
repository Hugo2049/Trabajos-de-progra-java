package ejercicio6_polimorfismointerfaz;

public abstract class Dispositivo {
    private String descripcion;
    private double precio;
    private boolean encendido;

    public Dispositivo(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.encendido = false; 
    }

    public void encender() {
        encendido = true;
        System.out.println("El dispositivo se ha encendido.");
    }

    public void apagar() {
        encendido = false;
        System.out.println("El dispositivo se ha apagado.");
    }

    public boolean isEncendido() {
        return encendido;
    }


}
