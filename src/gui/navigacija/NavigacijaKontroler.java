package gui.navigacija;

import gui.Layout;
import gui.mojNalog.MojNalogKontroler;
import gui.polozeniIspiti.PolozeniIspitiKontroler;
import gui.predmeti.PredmetiKontroler;
import gui.prijavljeniIspiti.PrijavljeniIspitiKontroler;
import gui.skolarina.SkolarinaKontroler;
import studentskiservis.StudentskiServis;

public final class NavigacijaKontroler extends NavigacijaGUI {

    public NavigacijaKontroler() {
        super.init();
        
        obavjestenja.setOnAction(e ->   { container.setCenter(Layout.obavjestenja.getLayout());              });
        skolarina.setOnAction(e ->      { container.setCenter(new SkolarinaKontroler().getLayout());         });
        mojiPredmeti.setOnAction(e ->   { container.setCenter(new PredmetiKontroler().getLayout());          });
        polozeniIspiti.setOnAction(e -> { container.setCenter(new PolozeniIspitiKontroler().getLayout());    });
        prijaviIspit.setOnAction(e ->   { container.setCenter(new PrijavljeniIspitiKontroler().getLayout()); });
        mojNalog.setOnAction(e ->       { container.setCenter(new MojNalogKontroler().getLayout());          });
        
        HandleButtonOdjava();
    }
    
    private void HandleButtonOdjava() {
        odjava.setOnAction(e -> {
            Layout.promijeniLayout(Layout.login.getLayout());
            StudentskiServis.student = null;
        });
    }
    
}
