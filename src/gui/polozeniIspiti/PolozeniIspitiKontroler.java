package gui.polozeniIspiti;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import student.PolozeniIspit;
import studentskiservis.StudentskiServis;

public class PolozeniIspitiKontroler extends PolozeniIspitiGUI {

    public PolozeniIspitiKontroler() {
        super();
        popuniTabelu();
    }
    
    private void popuniTabelu() {
        List<PolozeniIspit> polozeniIspiti = StudentskiServis.student.getPolozeniIspiti();
        ObservableList<PolozeniIspit> zaPrikazivanje = FXCollections.observableArrayList(polozeniIspiti);
        tabela.setItems(zaPrikazivanje);
    }
    
}
