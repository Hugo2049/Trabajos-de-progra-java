public class jugador {
    protected String nombre;
    protected String pais;
    protected int errores;
    protected int aces;
    protected int totaldeservicios;

    public jugador() {
        nombre = "";
        pais = "";
        errores = 0;
        aces = 0;
        totaldeservicios = 0;
    }

    public jugador(String nombre, String pais, int errores, int aces, int totaldeservicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totaldeservicios = totaldeservicios;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getErrores() {
        return this.errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public int getAces() {
        return this.aces;
    }

    public void setAces(int aces) {
        this.aces = aces;
    }

    public int getTotaldeservicios() {
        return this.totaldeservicios;
    }

    public void setTotaldeservicios(int totaldeservicios) {
        this.totaldeservicios = totaldeservicios;
    }

        public double calcularEfectividad() {
    // Fórmula común para calcular la efectividad
    return ((double)(aces - errores) * 100) / totaldeservicios;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", pais='" + getPais() + "'" +
            ", errores='" + getErrores() + "'" +
            ", aces='" + getAces() + "'" +
            ", totaldeservicios='" + getTotaldeservicios() + "'" +
            "}";
    }
}
