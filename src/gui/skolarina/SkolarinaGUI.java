package gui.skolarina;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import studentskiservis.StudentskiServis;

public abstract class SkolarinaGUI {
    
    protected final VBox layout;
    protected final VBox container;
    protected final HBox stanje;
    protected final Label naslov;
    protected final Label stanjeNaRacunu;
    protected final Label ukupnoDugovanje;
    protected final Label uplacenoSkolarine;
    protected final TableView tabela;
    
    protected SkolarinaGUI() {
        layout            = new VBox();
        container         = new VBox();
        stanje            = new HBox();
        naslov            = new Label("Skolarina");
        stanjeNaRacunu    = new Label("Stanje na racunu: " + StudentskiServis.student.getStanjeRacuna());
        ukupnoDugovanje   = new Label("\tUkupno dugovanje: " + StudentskiServis.student.getPreostalaSkolarina());
        uplacenoSkolarine = new Label("\tUplaceno skolarine: " + StudentskiServis.student.getUkupnaUplataSkolarine());
        tabela            = new TableView();
        
        layout.setId("layout");
        
        container.setId("okvir");
        
        stanje.setId("hbox");
        stanje.setMaxWidth(670);
        
        naslov.setId("naslov");
        naslov.prefWidthProperty().bind(layout.widthProperty());
        
        kreirajTabelu();
        tabela.setMaxWidth(670);
        
        stanje.getChildren().addAll(stanjeNaRacunu, ukupnoDugovanje, uplacenoSkolarine);
        container.getChildren().addAll(stanje, tabela);
        layout.getChildren().addAll(naslov, container);
    }
    
    private void kreirajTabelu() {
        TableColumn idUplate    = new TableColumn("Broj uplate");
        TableColumn iznosUplate = new TableColumn("Iznos");
        TableColumn datumUplate = new TableColumn("Datum uplate");
        TableColumn fakultet    = new TableColumn("Fakultet");
        TableColumn nacinUpisa  = new TableColumn("Nacin upisa");
        TableColumn godina      = new TableColumn("Godina");
        
        idUplate.setPrefWidth(100);
        iznosUplate.setPrefWidth(100);
        datumUplate.setPrefWidth(100);
        fakultet.setPrefWidth(170);
        nacinUpisa.setPrefWidth(100);
        godina.setPrefWidth(100);
        
        idUplate.setCellValueFactory(new PropertyValueFactory<>("idUplate"));
        iznosUplate.setCellValueFactory(new PropertyValueFactory<>("iznos"));
        datumUplate.setCellValueFactory(new PropertyValueFactory<>("datumUplate"));
        fakultet.setCellValueFactory(new PropertyValueFactory<>("fakultet"));
        nacinUpisa.setCellValueFactory(new PropertyValueFactory<>("nacinUpisa"));
        godina.setCellValueFactory(new PropertyValueFactory<>("godina"));
        
        tabela.getColumns().addAll(idUplate, iznosUplate, datumUplate, fakultet, nacinUpisa, godina);
    }
    
    public final Parent getLayout() { return layout; }
    
}
