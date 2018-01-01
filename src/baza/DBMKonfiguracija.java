package baza;

import gui.Layout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DBMKonfiguracija {
    
    private static final String KONFIGURACIJA[] = new String[5];
    
    public static String[] ucitajKonfiguraciju() {
        File fajl = new File("BPKonfiguracija.txt");
        if (!fajl.exists()) {
            Layout.greska("Fajl BPKonfiguracija.txt nije pronadjen!");
            return null;
        }
        
        try(BufferedReader citac = new BufferedReader(new FileReader(fajl));) {
            popuniPolja(citac);
        } catch (IOException ex) {
            Logger.getLogger(DBM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Mora ici obicna for petlja tako da mozemo testirati da li je
        // neki od clanova niza == null, a to se ne moze provjeriti u foreach petlji
        for (int i = 0; i < KONFIGURACIJA.length; i++) {
            if (KONFIGURACIJA[i].equals("") || KONFIGURACIJA[i].equals(" ") || KONFIGURACIJA[i] == null)
                Layout.greska("Fajl BPKonfiguracija.txt je nevazeci! Molimo unesite validne informacije za bazu!");
        }
        
        return KONFIGURACIJA;
    }
    
    private static void popuniPolja(BufferedReader citac) throws IOException {
        for (int i = 0; i < KONFIGURACIJA.length; i++) {
            KONFIGURACIJA[i] = ocistiString(citac.readLine());
        }
    }

    private static String ocistiString(String s) {
        String temp = null;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ':')
                temp = s.substring(i + 1, s.length());
        }
        return temp;
    }
    
}
