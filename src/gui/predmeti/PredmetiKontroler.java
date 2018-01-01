package gui.predmeti;

import student.Predmet;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import studentskiservis.StudentskiServis;

public final class PredmetiKontroler extends PredmetiGUI {

    public PredmetiKontroler() {
        super();
        popuniTabelu();
    }
    
    private void popuniTabelu() {
        List<Predmet> predmeti = StudentskiServis.student.getPredmeti();
        ObservableList<Predmet> zaPrikazivanje = FXCollections.observableArrayList(predmeti);
        tabela.setItems(zaPrikazivanje);
    }
    
}
