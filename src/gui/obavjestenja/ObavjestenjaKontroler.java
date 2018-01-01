package gui.obavjestenja;

import podaci.Podaci;
import java.util.Iterator;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public final class ObavjestenjaKontroler extends ObavjestenjaGUI {

    public ObavjestenjaKontroler() {
        super();
        PrikaziObavjestenja();
    }
    
    private void PrikaziObavjestenja() {
        Iterator<Obavjestenje> itr = Podaci.obavjestenja.iterator();
        while (itr.hasNext()) {
            Obavjestenje temp = itr.next();
            
            VBox vBox = new VBox();
            vBox.setId("pozadina");
            
            Label naslovObavjestenja = new Label(temp.getNaslov());
            naslovObavjestenja.prefWidthProperty().bind(vBox.widthProperty());
            naslovObavjestenja.setId("obavjestenjeNaslov");
            
            Label datum = new Label("Datum objave: " + temp.getDatumObjave());
            datum.setId("datum");
            
            Label obavjestenje = new Label(temp.getObavjestenje());
            obavjestenje.setId("obavjestenje");
            
            vBox.getChildren().addAll(naslovObavjestenja, datum, obavjestenje);
            container.getChildren().add(vBox);
        }
        scrollPane.setContent(container);
    }

}
