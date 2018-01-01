package gui.prijavljeniIspiti;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public abstract class PrijavljeniIspitiGUI {
    
    protected final VBox layout;
    protected final VBox container;
    protected final Label naslov;
    protected final Label neprijavljeni;
    protected final Label prijavljeni;
    protected final TableView tabelaNeprijavljeni;
    protected final TableView tabelaPrijavljeni;
    protected final Button prijaviIspit;
    
    protected PrijavljeniIspitiGUI() {
        layout              = new VBox();
        container           = new VBox();
        naslov              = new Label("Prijavljivanje ispita");
        neprijavljeni       = new Label("Neprijavljeni ispiti");
        prijavljeni         = new Label("Prijavljeni ispiti");
        tabelaNeprijavljeni = new TableView();
        tabelaPrijavljeni   = new TableView();
        prijaviIspit        = new Button("Prijavi ispit");
        
        layout.setSpacing(8);
        layout.setPadding(new Insets(0, 10, 0, 0));
        
        container.setId("okvir");
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(8, 0, 8, 0));
        container.setSpacing(5);
        
        naslov.setId("naslov");
        naslov.setFont(new Font(20));
        naslov.setTextAlignment(TextAlignment.CENTER);
        naslov.prefWidthProperty().bind(layout.widthProperty());
        
        kreirajTabelu(tabelaNeprijavljeni);
        tabelaNeprijavljeni.setMaxWidth(670);
        
        kreirajTabelu(tabelaPrijavljeni);
        tabelaPrijavljeni.setMaxWidth(670);
        
        prijaviIspit.setPrefHeight(40);
        prijaviIspit.setPrefWidth(140);
        
        container.getChildren().addAll(neprijavljeni, tabelaNeprijavljeni, prijaviIspit,
                                       prijavljeni, tabelaPrijavljeni);
        layout.getChildren().addAll(naslov, container);
    }
    
    private void kreirajTabelu(TableView tabela) {
        TableColumn predmet       = new TableColumn("Predmet");
        TableColumn fakultet      = new TableColumn("Fakultet");
        TableColumn skolskaGodina = new TableColumn("Skolska godina");
        TableColumn tip           = new TableColumn("tip");
        TableColumn semestar      = new TableColumn("Semestar");
        TableColumn etcsBodovi    = new TableColumn("Etcs");
        
        predmet.setPrefWidth(100);
        fakultet.setPrefWidth(170);
        skolskaGodina.setPrefWidth(100);
        tip.setPrefWidth(100);
        semestar.setPrefWidth(100);
        etcsBodovi.setPrefWidth(100);
        
        predmet.setCellValueFactory(new PropertyValueFactory<>("predmet"));
        fakultet.setCellValueFactory(new PropertyValueFactory<>("fakultet"));
        skolskaGodina.setCellValueFactory(new PropertyValueFactory<>("skolskaGodina"));
        tip.setCellValueFactory(new PropertyValueFactory<>("tip"));
        semestar.setCellValueFactory(new PropertyValueFactory<>("semestar"));
        etcsBodovi.setCellValueFactory(new PropertyValueFactory<>("etcsBodovi"));
        
        tabela.getColumns().addAll(predmet, fakultet, skolskaGodina, tip, semestar, etcsBodovi);
    }
    
    public final Parent getLayout() { return layout;  }
    
}
