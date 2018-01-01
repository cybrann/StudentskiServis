package gui.login;

import baza.Upiti;
import gui.Layout;

public final class LoginKontroler extends LoginGUI {

    public LoginKontroler() {
        super();
        HandleButtonLogin();
    }
    
    private void HandleButtonLogin() {
        login.setOnAction(e -> {
            String ime = this.korisnickoIme.getText();
            String loz = this.lozinka.getText();
            
            korisnickoIme.setText("");
            lozinka.setText("");
            
            if (Upiti.loginProvjera(ime, loz)) {
                login.setDefaultButton(false);
                Layout.promijeniLayout(Layout.navigacija.getLayout());
                Layout.navigacija.getObavjestenja().fire();
            } else
                Layout.greska("Pogresno korisnicko ime ili lozinka, molimo Vas pokusajte ponovo!");
        });
    }
    
}
