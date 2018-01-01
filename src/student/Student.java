package student;

import podaci.Podaci;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Student {
    
    private int id;
    private String indeks;
    private String ime;
    private String prezime;
    private String datumRodjenja;
    private String jmbg;
    private String brojTelefona;
    private String imeOca;
    private double stanjeRacuna;
    private int godinaStudija;
    private String fakultet;
    private String nacinUpisa;
    
    private Skolarina skolarina;
    private List<SkolarinaUplata> skolarinaUplate;
    private List<Predmet> predmeti;
    private List<PolozeniIspit> polozeniIspiti;
    private List<PrijavljeniIspiti> prijavljeniIspiti;

    public Student(int id, String indeks, String ime, String prezime, String datumRodjenja,
                   String jmbg, String brojTelefona, String imeOca, double stanjeRacuna,
                   int godinaStudija, String fakultet, String nacinUpisa) {
        this.id            = id;
        this.indeks        = indeks;
        this.ime           = ime;
        this.prezime       = prezime;
        this.datumRodjenja = datumRodjenja;
        this.jmbg          = jmbg;
        this.brojTelefona  = brojTelefona;
        this.imeOca        = imeOca;
        this.stanjeRacuna  = stanjeRacuna;
        this.godinaStudija = godinaStudija;
        this.fakultet      = fakultet;
        this.nacinUpisa    = nacinUpisa;
        
        ucitajPodatke();
    }
    
    public final void ucitajPodatke() {
        initSkolarina();
        initPredmeti();
        initPolozeniIspiti();
        initPrijavljeniIspiti();
    }
    
    private void initSkolarina() {
        for (Skolarina temp : Podaci.skolarina) {
            if (temp.getIndeks().equals(indeks)) {
                skolarina = temp;
                break;
            }
        }
        
        skolarinaUplate = new ArrayList<>(Podaci.skolarinaUplate);
        
        Iterator<SkolarinaUplata> itrUplata = skolarinaUplate.iterator();
        while (itrUplata.hasNext()) {
            SkolarinaUplata uplata = itrUplata.next();
            
            // Ukloni sve uplate skolarine koje nije uplatio student koji se ulogovao
            if (!uplata.getIndeks().equals(indeks))
                itrUplata.remove();
            else {
                uplata.setFakultet(fakultet);
                uplata.setNacinUpisa(nacinUpisa);
            }
        }
    }
    
    private void initPredmeti() {
        predmeti = new ArrayList<>(Podaci.predmeti);
        
        Iterator<Predmet> itrPredmet = predmeti.iterator();
        while (itrPredmet.hasNext()) {
            Predmet predmet = itrPredmet.next();
            
            // Ukloni sve predmete cija je godina studija veca od godine studija trenutno ulogovanog studenta
            // i ukloni sve predmete ciji se fakultet razlikuje od fakulteta trenutno ulogovanog studenta
            if (godinaStudija < predmet.getGodinaStudija() ||
                !fakultet.equalsIgnoreCase(predmet.getFakultet()))
                itrPredmet.remove();
        }
    }
    
    private void initPolozeniIspiti() {
        polozeniIspiti = new ArrayList<>(Podaci.polozeniIspiti);
        
        Iterator<PolozeniIspit> itrPolozeni = polozeniIspiti.iterator();
        while (itrPolozeni.hasNext()) {
            PolozeniIspit ispit = itrPolozeni.next();
            
            // Ukloni sve polozene ispite ciji se indeks razlikuje od indeksa trenutno ulogovanog studenta
            if (!ispit.getIndeks().equals(indeks))
                itrPolozeni.remove();
        }
    }
    
    private void initPrijavljeniIspiti() {
        prijavljeniIspiti = new ArrayList<>(Podaci.prijavljeniIspiti);
        
        Iterator<PrijavljeniIspiti> itrPolozeni = prijavljeniIspiti.iterator();
        while (itrPolozeni.hasNext()) {
            PrijavljeniIspiti ispit = itrPolozeni.next();
            
            // Ukloni sve prijavljene ispite ciji se indeks razlikuje od indeksa trenutno ulogovanog studenta
            if (!ispit.getIndeks().equals(indeks))
                itrPolozeni.remove();
        }
    }

    public final int getId()               { return id;            }
    public final String getIndeks()        { return indeks;        }
    public final String getIme()           { return ime;           }
    public final String getPrezime()       { return prezime;       }
    public final String getDatumRodjenja() { return datumRodjenja; }
    public final String getJmbg()          { return jmbg;          }
    public final String getBrojTelefona()  { return brojTelefona;  }
    public final String getImeOca()        { return imeOca;        }
    public final double getStanjeRacuna()  { return stanjeRacuna;  }
    public final int getGodinaStudija()    { return godinaStudija; }
    public final String getFakultet()      { return fakultet;      }
    public final String getNacinUpisa()    { return nacinUpisa;    }
    
    public final String getGodinaStudijaString() {
        switch(godinaStudija) {
            case 1: return "Prva";
            case 2: return "Druga";
            case 3: return "Treca";
            case 4: return "Cetvrta";
            case 5: return "Master";
            default: return "Prva";
        }
    }
    
    public final List<SkolarinaUplata> getSkolarinaUplate() {
        return skolarinaUplate;
    }

    public final List<Predmet> getPredmeti() {
        // Kreiramo novu listu na osnovu trenutno postojece liste, zato sto se polje predmeti
        // ne smije mijenjati osim kada ucitavamo podatke iz baze
        return new ArrayList<>(predmeti);
    }

    public final List<PolozeniIspit> getPolozeniIspiti() {
        return polozeniIspiti;
    }

    public final List<PrijavljeniIspiti> getPrijavljeniIspiti() {
        return prijavljeniIspiti;
    }
    
    public final int getPreostalaSkolarina() {
        int visinaSkolarine = skolarina.getSkolarina(godinaStudija);
        for (SkolarinaUplata uplate : skolarinaUplate) {
            if (uplate.getGodina() == godinaStudija)
                visinaSkolarine -= uplate.getIznos();
        }
        return visinaSkolarine;
    }
    
    public final int getUkupnaUplataSkolarine() {
        int ukupnaUplata = 0;
        for (SkolarinaUplata uplate : skolarinaUplate) {
            ukupnaUplata += uplate.getIznos();
        }
        return ukupnaUplata;
    }

    public final void setId(int id)                          { this.id = id;                       }
    public final void setIndeks(String indeks)               { this.indeks = indeks;               }
    public final void setIme(String ime)                     { this.ime = ime;                     }
    public final void setPrezime(String prezime)             { this.prezime = prezime;             }
    public final void setDatumRodjenja(String datumRodjenja) { this.datumRodjenja = datumRodjenja; }
    public final void setJmbg(String jmbg)                   { this.jmbg = jmbg;                   }
    public final void setBrojTelefona(String brojTelefona)   { this.brojTelefona = brojTelefona;   }
    public final void setImeOca(String imeOca)               { this.imeOca = imeOca;               }
    public final void setStanjeRacuna(double stanjeRacuna)   { this.stanjeRacuna = stanjeRacuna;   }
    public final void setGodinaStudija(int godinaStudija)    { this.godinaStudija = godinaStudija; }
    public final void setFakultet(String fakultet)           { this.fakultet = fakultet;           }
    public final void setNacinUpisa(String nacinUpisa)       { this.nacinUpisa = nacinUpisa;       }
    public void setSkolarina(Skolarina skolarina)            { this.skolarina = skolarina;         }

    public final void setSkolarinaUplate(List<SkolarinaUplata> skolarinaUplate) {
        this.skolarinaUplate = skolarinaUplate;
    }

    public final void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }

    public final void setPolozeniIspiti(List<PolozeniIspit> polozeniIspiti) {
        this.polozeniIspiti = polozeniIspiti;
    }

    public final void setPrijavljeniIspiti(List<PrijavljeniIspiti> prijavljeniIspiti) {
        this.prijavljeniIspiti = prijavljeniIspiti;
    }
    
}
