public class libero extends jugador{
    private int recibosefectivos;
    

    public libero() {
        super();
        recibosefectivos = 0;
    }


    public libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibosefectivos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.recibosefectivos = recibosefectivos;
    }


    public int getRecibosefectivos() {
        return this.recibosefectivos;
    }

    public void setRecibosefectivos(int recibosefectivos) {
        this.recibosefectivos = recibosefectivos;
    }

    public double calcularEfectividad() {
        double efectividadRecibos = ((double)recibosefectivos - errores) * 100 / (recibosefectivos + errores);
        double efectividadAces = aces * 100 / totaldeservicios;
        return (efectividadRecibos + efectividadAces) / 2;
    }


    @Override
    public String toString() {
        return "{" +
            " recibosefectivos='" + getRecibosefectivos() + "'" +
            "}";
    }



}


