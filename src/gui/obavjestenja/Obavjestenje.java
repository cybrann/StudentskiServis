package gui.obavjestenja;

public final class Obavjestenje {
    
    private String naslov;
    private String obavjestenje;
    private String datumObjave;

    public String getNaslov()       { return naslov;       }
    public String getObavjestenje() { return obavjestenje; }
    public String getDatumObjave()  { return datumObjave;  }
    
    public int getMjesecObjave() { return Integer.parseInt(datumObjave.substring(3, 5));                    }
    public int getGodinaObjave() { return Integer.parseInt(datumObjave.substring(6, datumObjave.length())); }

    public void setNaslov(String naslov)             { this.naslov = naslov;             }
    public void setObavjestenje(String obavjestenje) { this.obavjestenje = obavjestenje; }
    public void setDatumObjave(String datumObjave)   { this.datumObjave = datumObjave;   }
    
}
