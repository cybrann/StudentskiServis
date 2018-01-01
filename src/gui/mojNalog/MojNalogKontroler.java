package gui.mojNalog;

import javafx.scene.control.Label;
import student.Student;
import studentskiservis.StudentskiServis;

public class MojNalogKontroler extends MojNalogGUI {
    
    public MojNalogKontroler() {
        super();
        popuniInformacije();
    }
    
    private void popuniInformacije() {
        Student student = StudentskiServis.student;
        informacije[0].setText(" " + student.getIme());
        informacije[1].setText(" " + student.getPrezime());
        informacije[2].setText(" " + student.getImeOca());
        informacije[3].setText(" " + student.getIndeks());
        informacije[4].setText(" " + student.getDatumRodjenja());
        informacije[5].setText(" " + student.getJmbg());
        informacije[6].setText(" " + student.getBrojTelefona());
        informacije[7].setText(" " + student.getGodinaStudijaString());
        informacije[8].setText(" " + student.getFakultet());
        informacije[9].setText(" " + student.getNacinUpisa());
        
        for (Label temp : informacije) {
            temp.setId("informacije");
            temp.setPrefSize(150, 35);
            tabela[1].getChildren().add(temp);
        }
    }
    
}
