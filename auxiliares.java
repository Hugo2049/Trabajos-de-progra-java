public class auxiliares extends jugador {
    private int ataques;
    private int bloqueosEfectivos;
    private int bloqueosFallidos;

    public auxiliares() {
        super();
        ataques = 0;
        bloqueosEfectivos = 0;
        bloqueosFallidos = 0;
    }

    public auxiliares(String nombre, String pais, int errores, int aces, int totaldeservicios, int ataques, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totaldeservicios);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    public int getAtaques() {
        return this.ataques;
    }

    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    public int getBloqueosEfectivos() {
        return this.bloqueosEfectivos;
    }

    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    public int getBloqueosFallidos() {
        return this.bloqueosFallidos;
    }

    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    // Método para calcular la efectividad de los auxiliares/opuestos
    public double calcularEfectividad() {
        double efectividadAtaques = ((double)(ataques + bloqueosEfectivos - bloqueosFallidos - errores) * 100) / (ataques + bloqueosEfectivos + bloqueosFallidos + errores);
        double efectividadAces = aces * 100 / totaldeservicios;
        return (efectividadAtaques + efectividadAces) / 2;
    }

    @Override
    public String toString() {
        return "{" +
            " ataques='" + getAtaques() + "'" +
            ", bloqueosEfectivos='" + getBloqueosEfectivos() + "'" +
            ", bloqueosFallidos='" + getBloqueosFallidos() + "'" +
            "}";
    }

    
}