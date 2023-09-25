public class Jugador {
    protected String nombre;
    protected String pais;
    protected int faltas;
    protected int golesdirectos;
    protected int totaldelanzamientos;




    public Jugador(){
        nombre = "";
        pais = ""; 
        faltas = 0;
        golesdirectos = 0;
        totaldelanzamientos = 0;
    }

    public Jugador(String nombre, String pais, int faltas, int golesdirectos, int totaldelanzamientos ){
        this.nombre = nombre;
        this.pais = pais;
        this.faltas = faltas;
        this.golesdirectos = golesdirectos;
        this.totaldelanzamientos = totaldelanzamientos;
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

    public int getFaltas() {
        return this.faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getGolesdirectos() {
        return this.golesdirectos;
    }

    public void setGolesdirectos(int golesdirectos) {
        this.golesdirectos = golesdirectos;
    }

    public int getTotaldelanzamientos() {
        return this.totaldelanzamientos;
    }

    public void setTotaldelanzamientos(int totaldelanzamientos) {
        this.totaldelanzamientos = totaldelanzamientos;
    }
    

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", pais='" + getPais() + "'" +
            ", faltas='" + getFaltas() + "'" +
            ", golesdirectos='" + getGolesdirectos() + "'" +
            ", totaldelanzamientos='" + getTotaldelanzamientos() + "'" +
            "}";
    }
    
    
    public double efectividadJugador(){
        double efectivida = (golesdirectos*100) / (100/totaldelanzamientos);
        return efectivida;
    }

}
