package gui.predmeti;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public abstract class PredmetiGUI {
    
    protected final VBox layout;
    protected final VBox container;
    protected final Label naslov;
    protected final TableView tabela;
    
    protected PredmetiGUI() {
        layout    = new VBox();
        container = new VBox();
        naslov    = new Label("Predmeti");
        tabela    = new TableView();
        
        layout.setId("layout");
        
        container.setId("okvir");
        
        naslov.setId("naslov");
        naslov.prefWidthProperty().bind(layout.widthProperty());
        
        kreirajTabelu();
        tabela.setMaxWidth(670);
        
        container.getChildren().addAll(tabela);
        layout.getChildren().addAll(naslov, container);
    }
    
    private void kreirajTabelu() {
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
    
    public final Parent getLayout() { return layout; }
    
}
