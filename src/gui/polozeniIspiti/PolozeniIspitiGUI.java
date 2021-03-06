package gui.polozeniIspiti;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class PolozeniIspitiGUI {
    
    protected final VBox layout;
    protected final VBox container;
    protected final Label naslov;
    protected final TableView tabela;
    
    protected PolozeniIspitiGUI() {
        layout    = new VBox();
        container = new VBox();
        naslov    = new Label("Polozeni ispiti");
        tabela    = new TableView();
        
        layout.setId("layout");
        
        container.setId("okvir");
        
        naslov.setId("naslov");
        naslov.prefWidthProperty().bind(layout.widthProperty());
        
        kreirajTabelu();
        tabela.setMaxWidth(660);
        
        container.getChildren().addAll(tabela);
        layout.getChildren().addAll(naslov, container);
    }
    
    private void kreirajTabelu() {
        TableColumn predmet         = new TableColumn("Predmet");
        TableColumn prviKolokvijum  = new TableColumn("Prvi kolokvijum");
        TableColumn drugiKolokvijum = new TableColumn("Drugi kolokvijum");
        TableColumn zavrsniIspit    = new TableColumn("Zavrsni ispit");
        TableColumn aktivnost       = new TableColumn("Aktivnost");
        TableColumn prisustvo       = new TableColumn("Prisustvo");
        TableColumn projekat        = new TableColumn("Projekat");
        TableColumn ukupno          = new TableColumn("Ukupno");
        
        predmet.setPrefWidth(100);
        prviKolokvijum.setPrefWidth(100);
        drugiKolokvijum.setPrefWidth(110);
        zavrsniIspit.setPrefWidth(100);
        aktivnost.setPrefWidth(150);
        prisustvo.setPrefWidth(75);
        projekat.setPrefWidth(75);
        ukupno.setPrefWidth(100);
        
        predmet.setCellValueFactory(new PropertyValueFactory<>("predmet"));
        prviKolokvijum.setCellValueFactory(new PropertyValueFactory<>("prviKolokvijum"));
        drugiKolokvijum.setCellValueFactory(new PropertyValueFactory<>("drugiKolokvijum"));
        zavrsniIspit.setCellValueFactory(new PropertyValueFactory<>("zavrsniIspit"));
        prisustvo.setCellValueFactory(new PropertyValueFactory<>("prisustvo"));
        projekat.setCellValueFactory(new PropertyValueFactory<>("projekat"));
        ukupno.setCellValueFactory(new PropertyValueFactory<>("ukupno"));
        
        aktivnost.getColumns().addAll(prisustvo, projekat);
        tabela.getColumns().addAll(predmet, prviKolokvijum, drugiKolokvijum, zavrsniIspit, aktivnost, ukupno);
    }
    
    public final Parent getLayout() { return layout; }
    
}
