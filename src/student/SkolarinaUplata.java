package student;

import java.io.Serializable;

public final class SkolarinaUplata implements Serializable {
    
    private String idUplate;
    private String indeks;
    private int iznos;
    private String datumUplate;
    private String fakultet;
    private String nacinUpisa;
    private int godina;

    public final String getIdUplate()    { return idUplate;    }
    public final String getIndeks()      { return indeks;      }
    public final int getIznos()          { return iznos;       }
    public final String getDatumUplate() { return datumUplate; }
    public final String getFakultet()    { return fakultet;    }
    public final String getNacinUpisa()  { return nacinUpisa;  }
    public final int getGodina()         { return godina;      }

    public final void setIdUplate(String idUplate)       { this.idUplate = idUplate;       }
    public final void setIndeks(String indeks)           { this.indeks = indeks;           }
    public final void setIznos(int iznos)                { this.iznos = iznos;             }
    public final void setDatumUplate(String datumUplate) { this.datumUplate = datumUplate; }
    public final void setFakultet(String fakultet)       { this.fakultet = fakultet;       }
    public final void setNacinUpisa(String nacinUpisa)   { this.nacinUpisa = nacinUpisa;   }
    public final void setGodina(int godina)              { this.godina = godina;           }
    
}
