public class Portero extends Jugador{
    private int paradasefectivas;
    private int golesrecibidos;

    public Portero(){
        super();
        paradasefectivas = 0;
        golesrecibidos = 0;
    }

    public Portero(String nombre, String pais, int faltas, int golesdirectos, int totaldelanzamientos, int paradasefectivas, int golesrecibidos) {
        super(nombre, pais, faltas, golesdirectos, totaldelanzamientos);
        this.paradasefectivas = paradasefectivas;
        this.golesrecibidos = golesrecibidos;
    }


    public int getParadasefectivas() {
        return this.paradasefectivas;
    }

    public void setParadasefectivas(int paradasefectivas) {
        this.paradasefectivas = paradasefectivas;
    }

    public int getGolesrecibidos() {
        return this.golesrecibidos;
    }

    public void setGolesrecibidos(int golesrecibidos) {
        this.golesrecibidos = golesrecibidos;
    }
    

    @Override
    public String toString() {
        return "{" +
            " paradasefectivas='" + getParadasefectivas() + "'" +
            ", golesrecibidos='" + getGolesrecibidos() + "'" +
            "}";
    }

    public double porteroeficienciaprin(){
        double portfiex = ((paradasefectivas - golesrecibidos)*100)/ (paradasefectivas+golesrecibidos);
        return portfiex;
    }

    public double efectividadJugador(){
        return super.efectividadJugador() + porteroeficienciaprin();
    }

}
