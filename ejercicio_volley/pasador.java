public class pasador extends jugador {
    private int pases;
    private int jugadasdeengaño;

    public pasador() {
        super();
        pases = 0;
        jugadasdeengaño = 0;
    }

    public pasador(String nombre, String pais, int errores, int aces, int totaldeservicios, int pases, int jugadasdeengaño) {
        super(nombre, pais, errores, aces, totaldeservicios);
        this.pases = pases;
        this.jugadasdeengaño = jugadasdeengaño;
    }

    public int getPases() {
        return this.pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getJugadasdeengaño() {
        return this.jugadasdeengaño;
    }

    public void setJugadasdeengaño(int jugadasdeengaño) {
        this.jugadasdeengaño = jugadasdeengaño;
    }

    // Método para calcular la efectividad del pasador
    public double calcularEfectividad() {
        double efectividadPases = ((double)(pases + jugadasdeengaño) - errores) * 100 / (pases + jugadasdeengaño + errores);
        double efectividadAces = aces * 100 / totaldeservicios;
        return (efectividadPases + efectividadAces) / 2;
    }

    @Override
    public String toString() {
    return "Nombre: " + getNombre() +
    ", País: " + getPais() +
    ", Errores: " + getErrores() +
    ", Aces: " + getAces() +
    ", Total de servicios: " + getTotaldeservicios() +
    ", Pases efectivos: " + getPases() +
    ", Jugadas de engaño: " + getJugadasdeengaño() +
    ", Efectividad: " + calcularEfectividad();
}
}