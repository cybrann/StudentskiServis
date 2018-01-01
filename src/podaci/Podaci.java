package podaci;

import baza.Upiti;
import gui.obavjestenja.Obavjestenje;
import student.Predmet;
import student.Skolarina;
import student.SkolarinaUplata;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import student.PolozeniIspit;
import student.PrijavljeniIspiti;
import studentskiservis.StudentskiServis;

public class Podaci implements Runnable {
    
    public static List<Obavjestenje> obavjestenja;
    public static List<Skolarina> skolarina;
    public static List<SkolarinaUplata> skolarinaUplate;
    public static List<Predmet> predmeti;
    public static List<PolozeniIspit> polozeniIspiti;
    public static List<PrijavljeniIspiti> prijavljeniIspiti;
    
    public static void ucitajPodatke() {
        obavjestenja      = Upiti.selectObavjestenja();
        skolarina         = Upiti.selectSkolarina();
        skolarinaUplate   = Upiti.selectSkolarinaUplate();
        predmeti          = Upiti.selectPredmete();
        polozeniIspiti    = Upiti.selectPolozeniIspiti();
        prijavljeniIspiti = Upiti.selectPrijavljeniIspiti();
        
        new Thread(new Podaci()).start();
    }

    @Override
    public void run() {
        obavjestenja      = Upiti.selectObavjestenja();
        skolarina         = Upiti.selectSkolarina();
        skolarinaUplate   = Upiti.selectSkolarinaUplate();
        predmeti          = Upiti.selectPredmete();
        polozeniIspiti    = Upiti.selectPolozeniIspiti();
        prijavljeniIspiti = Upiti.selectPrijavljeniIspiti();
        
        try {
            StudentskiServis.student.ucitajPodatke();
        } catch (NullPointerException ex) { /*Ovdje je normalno ako bude NullPointerException*/ }
        
        try {
            Thread.sleep(60000); // Svake minute uzmi nove podatke iz baze
        } catch (InterruptedException ex) {
            Logger.getLogger(Podaci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
