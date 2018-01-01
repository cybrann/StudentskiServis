package student;

import java.io.Serializable;

public class Predmet implements Serializable {
    
    private String predmet;
    private String fakultet;
    private String skolskaGodina;
    private String tip;
    private String semestar;
    private String etcsBodovi;
    
    // Koristiti samo za provjeru
    private int godinaStudija;

    public final String getPredmet()       { return predmet;       }
    public final String getFakultet()      { return fakultet;      }
    public final String getSkolskaGodina() { return skolskaGodina; }
    public final String getTip()           { return tip;           }
    public final String getSemestar()      { return semestar;      }
    public final String getEtcsBodovi()    { return etcsBodovi;    }
    public final int getGodinaStudija()    { return godinaStudija; }

    public final void setPredmet(String predmet)             { this.predmet = predmet;             }
    public final void setFakultet(String fakultet)           { this.fakultet = fakultet;           }
    public final void setSkolskaGodina(String skolskaGodina) { this.skolskaGodina = skolskaGodina; }
    public final void setTip(String tip)                     { this.tip = tip;                     }
    public final void setSemestar(String semestar)           { this.semestar = semestar;           }
    public final void setEtcsBodovi(String etcsBodovi)       { this.etcsBodovi = etcsBodovi;       }
    public final void setGodinaStudija(int godinaStudija)    { this.godinaStudija = godinaStudija; }

    @Override
    public String toString() {
        return predmet;
    }
    
}
