package baza;

import gui.obavjestenja.Obavjestenje;
import student.Predmet;
import student.Skolarina;
import student.SkolarinaUplata;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kriptografija.Kriptografija;
import student.PolozeniIspit;
import student.PrijavljeniIspiti;
import student.Student;
import studentskiservis.StudentskiServis;

public final class Upiti {
    
    public static boolean loginProvjera(String korisnickoIme, String sifra) {
        try {
            String upit = "SELECT * FROM studenti WHERE indeks = ? AND lozinka = ?";
            PreparedStatement stmt = DBM.getKonekcija().prepareStatement(upit);
            
            stmt.setString(1, korisnickoIme);
            stmt.setString(2, Kriptografija.getSHA256(sifra));
            
            ResultSet rezultat = stmt.executeQuery();
            if (rezultat.next()) {
                StudentskiServis.student = new Student(
                    rezultat.getInt(1),     // Id
                    rezultat.getString(2),  // Indeks
                    rezultat.getString(3),  // Ime
                    rezultat.getString(4),  // Prezime
                    // 5 je lozinka, nju ne ucitavamo
                    rezultat.getString(6),  // Datum rodjenja
                    rezultat.getString(7),  // Maticni broj
                    rezultat.getString(8),  // Broj telefona
                    rezultat.getString(9),  // Ime oca
                    rezultat.getDouble(10), // Stanje racuna
                    rezultat.getInt(11),    // Godina studija
                    rezultat.getString(12), // Fakultet
                    rezultat.getString(13)  // Nacin upisa
                );
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static List<Obavjestenje> selectObavjestenja() {
        List<Obavjestenje> obavjestenja = new ArrayList<>();
        try {
            String upit = "SELECT * FROM obavjestenja";
            PreparedStatement stmt = DBM.getKonekcija().prepareStatement(upit);
            
            ResultSet rezultat = stmt.executeQuery();
            while (rezultat.next()) {
                Obavjestenje temp = new Obavjestenje();
                temp.setNaslov(rezultat.getString(2));
                temp.setObavjestenje(rezultat.getString(3));
                temp.setDatumObjave(rezultat.getString(4));
                obavjestenja.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obavjestenja;
    }
    
    public static List<Skolarina> selectSkolarina() {
        List<Skolarina> skolarina = new ArrayList<>();
        try {
            String upit = "SELECT * FROM skolarina";
            PreparedStatement stmt = DBM.getKonekcija().prepareStatement(upit);
            
            ResultSet rezultat = stmt.executeQuery();
            while (rezultat.next()) {
                Skolarina temp = new Skolarina();
                temp.setIndeks(rezultat.getString(2));
                temp.setPrvaGodina(rezultat.getInt(3));
                temp.setDrugaGodina(rezultat.getInt(4));
                temp.setTrecaGodina(rezultat.getInt(5));
                temp.setCetvrtaGodina(rezultat.getInt(6));
                temp.setMasterStudije(rezultat.getInt(7));
                skolarina.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return skolarina;
    }
    
    public static List<SkolarinaUplata> selectSkolarinaUplate() {
        List<SkolarinaUplata> skolarina = new ArrayList<>();
        try {
            String upit = "SELECT * FROM uplate_skolarine";
            PreparedStatement stmt = DBM.getKonekcija().prepareStatement(upit);
            
            ResultSet rezultat = stmt.executeQuery();
            while (rezultat.next()) {
                SkolarinaUplata temp = new SkolarinaUplata();
                temp.setIdUplate(Integer.toString(rezultat.getInt(1)));
                temp.setIndeks(rezultat.getString(2));
                temp.setIznos(rezultat.getInt(3));
                temp.setDatumUplate(rezultat.getString(4));
                temp.setGodina(rezultat.getInt(5));
                skolarina.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return skolarina;
    }
    
    public static List<Predmet> selectPredmete() {
        List<Predmet> predmeti = new ArrayList<>();
        try {
            String upit = "SELECT * FROM predmeti";
            PreparedStatement stmt = DBM.getKonekcija().prepareStatement(upit);
            ResultSet rezultat = stmt.executeQuery();
            
            while (rezultat.next()) {
                Predmet temp = new Predmet();
                temp.setPredmet(rezultat.getString(2));
                temp.setFakultet(rezultat.getString(3));
                temp.setSkolskaGodina(rezultat.getString(4));
                temp.setTip(rezultat.getString(5));
                temp.setSemestar(rezultat.getString(6));
                temp.setEtcsBodovi(rezultat.getString(7));
                temp.setGodinaStudija(rezultat.getInt(8));
                predmeti.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return predmeti;
    }
    
    public static List<PolozeniIspit> selectPolozeniIspiti() {
        List<PolozeniIspit> polozeniIspiti = new ArrayList<>();
        try {
            String upit = "SELECT * FROM polozeni_ispiti";
            PreparedStatement stmt = DBM.getKonekcija().prepareStatement(upit);
            ResultSet rezultat = stmt.executeQuery();
            
            while (rezultat.next()) {
                PolozeniIspit temp = new PolozeniIspit();
                temp.setIndeks(rezultat.getString(2));
                temp.setPredmet(rezultat.getString(3));
                temp.setPrviKolokvijum(rezultat.getInt(4));
                temp.setDrugiKolokvijum(rezultat.getInt(5));
                temp.setZavrsniIspit(rezultat.getInt(6));
                temp.setPrisustvo(rezultat.getInt(7));
                temp.setProjekat(rezultat.getInt(8));
                temp.setUkupno();
                polozeniIspiti.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return polozeniIspiti;
    }
    
    public static List<PrijavljeniIspiti> selectPrijavljeniIspiti() {
        List<PrijavljeniIspiti> prijavljeniIspiti = new ArrayList<>();
        try {
            String upit = "SELECT * FROM prijavljeni_ispiti";
            PreparedStatement stmt = DBM.getKonekcija().prepareStatement(upit);
            ResultSet rezultat = stmt.executeQuery();
            
            while (rezultat.next()) {
                PrijavljeniIspiti temp = new PrijavljeniIspiti();
                temp.setPredmet(rezultat.getString(2));
                temp.setFakultet(rezultat.getString(3));
                temp.setSkolskaGodina(rezultat.getString(4));
                temp.setTip(rezultat.getString(5));
                temp.setSemestar(rezultat.getString(6));
                temp.setEtcsBodovi(rezultat.getString(7));
                temp.setGodinaStudija(rezultat.getInt(8));
                temp.setIndeks(rezultat.getString(9));
                prijavljeniIspiti.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prijavljeniIspiti;
    }
    
    public static void insertPrijavljeniIspiti(String indeks, String predmet) {
        try {
            String upit = "SELECT * FROM predmeti WHERE predmet = ?";
            PreparedStatement stmt = DBM.getKonekcija().prepareStatement(upit);
            
            stmt.setString(1, predmet);
            
            ResultSet rezultat = stmt.executeQuery();
            if (rezultat.next()) {
                String insert = "INSERT INTO prijavljeni_ispiti(predmet, fakultet, skolska_godina, tip, semestar, etcs_bodovi, godina, indeks)" +
                                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                stmt = DBM.getKonekcija().prepareStatement(insert);
                
                stmt.setString(1, rezultat.getString(2));
                stmt.setString(2, rezultat.getString(3));
                stmt.setString(3, rezultat.getString(4));
                stmt.setString(4, rezultat.getString(5));
                stmt.setString(5, rezultat.getString(6));
                stmt.setString(6, rezultat.getString(7));
                stmt.setInt(7, rezultat.getInt(8));
                stmt.setString(8, StudentskiServis.student.getIndeks());
                
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateStanjeRacuna(String indeks, double stanje) {
        try {
            String upit = "UPDATE studenti SET stanje_racuna = ? WHERE indeks = ?";
            PreparedStatement stmt = DBM.getKonekcija().prepareStatement(upit);
            
            stmt.setDouble(1, stanje);
            stmt.setString(2, indeks);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Upiti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
