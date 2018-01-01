package baza;

import gui.Layout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DBM {
    
    private static String korisnickoIme;
    private static String sifra;
    private static String imeBaze;
    private static String ipAdresa;
    private static String port;
    
    private static Connection konekcija;
    
    public static void konektuj() {
        init();
        try {
            String s = "jdbc:mysql://" + ipAdresa + ':' + port + '/' + imeBaze;
            Class.forName("com.mysql.jdbc.Driver");
            konekcija = DriverManager.getConnection(s, korisnickoIme, sifra);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBM.class.getName()).log(Level.SEVERE, null, ex);
            Layout.greska("Doslo je do greske tokom konektovanja sa bazom. " +
                          "Molimo provjerite da li ste unijeli sve informacije tacno!");
            konekcija = null;
        }
    }
    
    public static void diskonektuj() {
        korisnickoIme = sifra = imeBaze = ipAdresa = port = null;
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void init() {
        String konfiguracija[] = DBMKonfiguracija.ucitajKonfiguraciju();
        
        korisnickoIme = konfiguracija[0];
        sifra         = konfiguracija[1];
        imeBaze       = konfiguracija[2];
        ipAdresa      = konfiguracija[3];
        port          = konfiguracija[4];
    }

    public static Connection getKonekcija() {
        return konekcija;
    }
    
}
