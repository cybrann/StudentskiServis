package gui.prijavljeniIspiti;

import baza.Upiti;
import gui.Layout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import student.PolozeniIspit;
import student.Predmet;
import student.PrijavljeniIspiti;
import student.Student;
import studentskiservis.StudentskiServis;

public class PrijavljeniIspitiKontroler extends PrijavljeniIspitiGUI {
    
    private final Student student = StudentskiServis.student;

    public PrijavljeniIspitiKontroler() {
        super();
        neprijavljeniIspiti();
        prijavljeniIspiti();
        HandleButtonPrijaviIspit();
    }
    
    private void neprijavljeniIspiti() {
        List<Predmet> predmeti = student.getPredmeti();
        List<PrijavljeniIspiti> prijavljeniIspiti = student.getPrijavljeniIspiti();
        List<PolozeniIspit> polozeni = student.getPolozeniIspiti();
        
        // Koristimo iterator da bi izbjegli ConcurrentModificationException
        Iterator<Predmet> itrPredmeti = predmeti.iterator();
        while (itrPredmeti.hasNext()) {
            Predmet predmet = itrPredmeti.next();
            
            // Ukloni sve prijavljene ispite
            Iterator<PrijavljeniIspiti> itrPrijavljeni = prijavljeniIspiti.iterator();
            while (itrPrijavljeni.hasNext()) {
                PrijavljeniIspiti ispit = itrPrijavljeni.next();
                
                if (predmet.getPredmet().equals(ispit.getPredmet()))
                    itrPredmeti.remove();
            }
            
            // Ukloni sve polozene ispite
            Iterator<PolozeniIspit> itrPolozeni = polozeni.iterator();
            while (itrPolozeni.hasNext()) {
                PolozeniIspit ispit = itrPolozeni.next();
                
                if (predmet.getPredmet().equals(ispit.getPredmet()))
                    itrPredmeti.remove();
            }
        }
        
        ObservableList<Predmet> zaPrikazivanje = FXCollections.observableArrayList(predmeti);
        tabelaNeprijavljeni.setItems(zaPrikazivanje);
    }
    
    private void prijavljeniIspiti() {
        List<Predmet> predmeti = new ArrayList<>();
        
        student.getPrijavljeniIspiti().forEach((ispit) -> {
            predmeti.add(ispit);
        });
        
        ObservableList<Predmet> zaPrikazivanje = FXCollections.observableArrayList(predmeti);
        tabelaPrijavljeni.setItems(zaPrikazivanje);
    }
    
    private void HandleButtonPrijaviIspit() {
        prijaviIspit.setOnAction(e -> {
            
            // 5km je cijena prijave ispita
            if (student.getStanjeRacuna() < 5) {
                Layout.greska("Nemate dovoljno novca na racunu da prijavite ispit!");
                return;
            }
            
            // Iz tabele ucitaj izabrani red
            Predmet predmet = (Predmet)tabelaNeprijavljeni.getSelectionModel().getSelectedItem();
            if (predmet == null) {
                Layout.greska("Morate izabrati neki predmet da bi prijavili ispit!");
                return;
            }
            
            // Potrdi prijavu ispita
            ButtonType rezultat = getRezultat("Da li zelite da prijavite ispit iz: " + predmet.getPredmet());
            
            if (rezultat == ButtonType.OK)
                prijaviIspit(predmet);
        });
    }
    
    private ButtonType getRezultat(String pitanje) {
        Alert potvrda = new Alert(Alert.AlertType.CONFIRMATION);
        potvrda.initStyle(StageStyle.UTILITY);
        potvrda.initModality(Modality.APPLICATION_MODAL);
        potvrda.setHeaderText(null);
        potvrda.setContentText(pitanje);
        return potvrda.showAndWait().get();
    }
    
    private void prijaviIspit(Predmet predmet) {
        Upiti.insertPrijavljeniIspiti(student.getIndeks(), predmet.getPredmet());
        Predmet ispit = new PrijavljeniIspiti(predmet);

        student.getPrijavljeniIspiti().add((PrijavljeniIspiti)ispit);
        student.setStanjeRacuna(student.getStanjeRacuna() - 5);
        
        Upiti.updateStanjeRacuna(student.getIndeks(), student.getStanjeRacuna());
        
        neprijavljeniIspiti();
        prijavljeniIspiti();
    }
    
}
