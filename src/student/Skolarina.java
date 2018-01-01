package student;

public class Skolarina {
    
    private String indeks;
    private int prvaGodina;
    private int drugaGodina;
    private int trecaGodina;
    private int cetvrtaGodina;
    private int masterStudije;

    public final String getIndeks()     { return indeks;        }
    public final int getPrvaGodina()    { return prvaGodina;    }
    public final int getDrugaGodina()   { return drugaGodina;   }
    public final int getTrecaGodina()   { return trecaGodina;   }
    public final int getCetvrtaGodina() { return cetvrtaGodina; }
    public final int getMasterStudije() { return masterStudije; }
    
    public final int getSkolarina(int godina) {
        switch (godina) {
            case 1: return getPrvaGodina();
            case 2: return getDrugaGodina();
            case 3: return getTrecaGodina();
            case 4: return getCetvrtaGodina();
            case 5: return getMasterStudije();
            default: return 0;
        }
    }

    public final void setIndeks(String indeks)            { this.indeks = indeks;               }
    public final void setPrvaGodina(int prvaGodina)       { this.prvaGodina = prvaGodina;       }
    public final void setDrugaGodina(int drugaGodina)     { this.drugaGodina = drugaGodina;     }
    public final void setTrecaGodina(int trecaGodina)     { this.trecaGodina = trecaGodina;     }
    public final void setCetvrtaGodina(int cetvrtaGodina) { this.cetvrtaGodina = cetvrtaGodina; }
    public final void setMasterStudije(int masterStudije) { this.masterStudije = masterStudije; }
    
}
