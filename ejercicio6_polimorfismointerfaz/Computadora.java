package ejercicio6_polimorfismointerfaz;

public class Computadora extends Dispositivo implements ControladorElectronico {
    private int memoriaRAM;
    private String tamanoDiscoDuro;
    private String tipoDiscoDuro;

    public Computadora(String descripcion, double precio, int memoriaRAM, String tamanoDiscoDuro, String tipoDiscoDuro) {
        super(descripcion, precio);
        this.memoriaRAM = memoriaRAM;
        this.tamanoDiscoDuro = tamanoDiscoDuro;
        this.tipoDiscoDuro = tipoDiscoDuro;
    }

    / 
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