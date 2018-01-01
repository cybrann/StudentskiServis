package gui;

import gui.login.LoginKontroler;
import gui.navigacija.NavigacijaKontroler;
import gui.obavjestenja.ObavjestenjaKontroler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public final class Layout {
    
    public static LoginKontroler login;
    public static ObavjestenjaKontroler obavjestenja;
    public static NavigacijaKontroler navigacija;
    public static Scene scene;
    
    public static void init() {
        login        = new LoginKontroler();
        obavjestenja = new ObavjestenjaKontroler();
        navigacija   = new NavigacijaKontroler();
        scene        = new Scene(login.getLayout(), 1024, 720);
    }
    
    public static void promijeniLayout(Parent layout) {
        scene.setRoot(layout);
    }
    
    public static void greska(String poruka) {
        Alert greska = new Alert(Alert.AlertType.ERROR);
        greska.initStyle(StageStyle.UTILITY);
        greska.setHeaderText(null);
        greska.setContentText(poruka);
        greska.showAndWait();
    }
    
}
