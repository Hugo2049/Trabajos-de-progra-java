public class Extremo extends Jugador{
    private int pases;
    private int assistenciasefectivas;

    public Extremo(){
        super();
        pases = 0;
        assistenciasefectivas = 0;
    }

    public Extremo(String nombre, String pais, int faltas, int golesdirectos, int totaldelanzamientos, int pases,
            int assistenciasefectivas) {
        super(nombre, pais, faltas, golesdirectos, totaldelanzamientos);
        this.pases = pases;
        this.assistenciasefectivas = assistenciasefectivas;
    }


    public int getPases() {
        return this.pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getAssistenciasefectivas() {
        return this.assistenciasefectivas;
    }

    public void setAssistenciasefectivas(int assistenciasefectivas) {
        this.assistenciasefectivas = assistenciasefectivas;
    }
    

    @Override
    public String toString() {
        return "{" +
            " pases='" + getPases() + "'" +
            ", assistenciasefectivas='" + getAssistenciasefectivas() + "'" +
            "}";
    }

    public double extremoeficienciaprin(){
        double efiex = ((pases + assistenciasefectivas)*100)/ (pases+assistenciasefectivas);
        return efiex;
    }

    public double efectividadJugador(){
        return super.efectividadJugador() + extremoeficienciaprin();
    }
}
