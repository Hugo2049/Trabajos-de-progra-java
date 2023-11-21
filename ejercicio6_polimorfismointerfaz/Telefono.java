package ejercicio6_polimorfismointerfaz;

public class Telefono extends Dispositivo implements ControladorElectronico {
    private int memoriaRAM;
    private String procesador;
    private int almacenamientoInterno;
    private boolean extenderMemoria;
    private boolean incluyeCuboCargador;
    private boolean esCompatible5G;

    public Telefono(String descripcion, double precio, int memoriaRAM, String procesador,
        int almacenamientoInterno, boolean extenderMemoria, boolean incluyeCuboCargador,
        boolean esCompatible5G) {
        super(descripcion, precio);
        this.memoriaRAM = memoriaRAM;
        this.procesador = procesador;
        this.almacenamientoInterno = almacenamientoInterno;
        this.extenderMemoria = extenderMemoria;
        this.incluyeCuboCargador = incluyeCuboCargador;
        this.esCompatible5G = esCompatible5G;
    }

    // Implementa todos los métodos heredados de ControladorElectronico
    @Override
    public void encender() {
       
    }

    @Override
    public void apagar() {
       
    }

    @Override
    public void subirVolumen() {
        
    }

    @Override
    public void bajarVolumen() {
        
    }

    @Override
    public void aumentarBrillo() {
        
    }

    @Override
    public void disminuirBrillo() {
        
    }

    @Override
    public void seleccionarDispositivo(Dispositivo dispositivo) {
        
    }

    @Override
    public void visualizarAccionesPermitidas() {
        
    }

    @Override
    public void mostrarInformacion() {
        
    }

    @Override
    public void mostrarEstado() {
        
    }

    @Override
    public void controlarVideos() {
        
    }
}