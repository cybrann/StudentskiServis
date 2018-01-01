package gui.skolarina;

import java.util.List;
import javafx.collections.FXCollections;
import student.SkolarinaUplata;
import javafx.collections.ObservableList;
import studentskiservis.StudentskiServis;

public final class SkolarinaKontroler extends SkolarinaGUI {

    public SkolarinaKontroler() {
        super();
        popuniTabelu();
    }
    
    private void popuniTabelu() {
        List<SkolarinaUplata> skolarine = StudentskiServis.student.getSkolarinaUplate();
        ObservableList<SkolarinaUplata> zaPrikazivanje = FXCollections.observableArrayList(skolarine);
        tabela.setItems(zaPrikazivanje);
    }
    
}
