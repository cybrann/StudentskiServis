package student;

public class PrijavljeniIspiti extends Predmet {
    
    private String indeks;

    public PrijavljeniIspiti() {
        super();
    }

    public PrijavljeniIspiti(Predmet predmet) {
        super();
        setPredmet(predmet.getPredmet());
        setFakultet(predmet.getFakultet());
        setSkolskaGodina(predmet.getSkolskaGodina());
        setTip(predmet.getTip());
        setSemestar(predmet.getSemestar());
        setEtcsBodovi(predmet.getEtcsBodovi());
    }
    
    public final String getIndeks() {return indeks;}
    
    public final void setIndeks(String indeks) { this.indeks = indeks; }
    
}
