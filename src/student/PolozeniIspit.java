package student;

import java.io.Serializable;

public class PolozeniIspit implements Serializable {
    
    private String indeks;
    private String predmet;
    private int prviKolokvijum;
    private int drugiKolokvijum;
    private int zavrsniIspit;
    private int prisustvo;
    private int projekat;
    private int ukupno;

    public final String getIndeks()       { return indeks;          }
    public final String getPredmet()      { return predmet;         }
    public final int getPrviKolokvijum()  { return prviKolokvijum;  }
    public final int getDrugiKolokvijum() { return drugiKolokvijum; }
    public final int getZavrsniIspit()    { return zavrsniIspit;    }
    public final int getPrisustvo()       { return prisustvo;       }
    public final int getProjekat()        { return projekat;        }
    public final int getUkupno()          { return ukupno;          }

    public final void setIndeks(String indeks)                { this.indeks = indeks;                   }
    public final void setPredmet(String predmet)              { this.predmet = predmet;                 }
    public final void setPrviKolokvijum(int prviKolokvijum)   { this.prviKolokvijum = prviKolokvijum;   }
    public final void setDrugiKolokvijum(int drugiKolokvijum) { this.drugiKolokvijum = drugiKolokvijum; }
    public final void setZavrsniIspit(int zavrsniIspit)       { this.zavrsniIspit = zavrsniIspit;       }
    public final void setPrisustvo(int prisustvo)             { this.prisustvo = prisustvo;             }
    public final void setProjekat(int projekat)               { this.projekat = projekat;               }
    
    public final void setUkupno() {
        ukupno = prviKolokvijum + drugiKolokvijum + zavrsniIspit + prisustvo + projekat;
    }
    
}
