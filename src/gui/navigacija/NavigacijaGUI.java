package gui.navigacija;

import java.nio.file.Paths;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public abstract class NavigacijaGUI {
    
    private StackPane layout;
    protected BorderPane container;
    
    private VBox navigacija;
    protected Button obavjestenja;
    protected Button skolarina;
    protected Button mojiPredmeti;
    protected Button polozeniIspiti;
    protected Button prijaviIspit;
    protected Button mojNalog;
    protected Button odjava;
    
    private HBox header;
    private ImageView logo;
    private Label naslov;
    
    private final String relativnaAdresa = "file:\\" + Paths.get("").toAbsolutePath().toString();
    
    protected final void init() {
        layout    = new StackPane();
        container = new BorderPane();
        
        initNavigacija();
        initHeader();
        
        container.setTop(header);
        container.setLeft(navigacija);
        
        layout.getChildren().addAll(new ImageView(relativnaAdresa + "\\slike\\glavna_pozadina.jpg"), container);
    }
    
    private void initNavigacija() {
        navigacija     = new VBox();
        obavjestenja   = new Button("Obavjestenja");
        skolarina      = new Button("Skolarina");
        mojiPredmeti   = new Button("Predmeti");
        polozeniIspiti = new Button("Polozeni Ispiti");
        prijaviIspit   = new Button("Prijavi Ispit");
        mojNalog       = new Button("Moj Nalog");
        odjava         = new Button("Odjava");
        
        navigacija.setId("navigacija");
        
        obavjestenja.setPrefSize(190, 55);
        skolarina.setPrefSize(190, 55);
        mojiPredmeti.setPrefSize(190, 55);
        polozeniIspiti.setPrefSize(190, 55);
        prijaviIspit.setPrefSize(190, 55);
        mojNalog.setPrefSize(190, 55);
        odjava.setPrefSize(190, 55);
        
        obavjestenja.requestFocus();
        navigacija.getChildren().addAll(obavjestenja, skolarina, mojiPredmeti, polozeniIspiti,
                                        prijaviIspit, mojNalog, odjava);
    }
    
    private void initHeader() {
        header = new HBox();
        logo   = new ImageView(relativnaAdresa + "\\slike\\logo.png");
        naslov = new Label("Studentski Servis");
        
        header.setId("header");
        
        logo.setFitWidth(266);
        logo.setFitHeight(77);
        
        naslov.setId("studentskiServis");
        
        header.getChildren().addAll(logo, naslov);
    }

    public final StackPane getLayout() {
        return layout;
    }
    
    public final Button getObavjestenja() {
        return obavjestenja;
    }
    
}
