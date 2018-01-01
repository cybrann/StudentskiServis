package gui.navigacija;

import java.nio.file.Paths;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

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
        
        navigacija.setPadding(new Insets(10, 25, 25, 25));
        navigacija.setSpacing(2);
        
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
        
        header.setAlignment(Pos.BOTTOM_LEFT);
        header.setPadding(new Insets(25));
        header.setSpacing(50);
        
        logo.setFitWidth(266);
        logo.setFitHeight(77);
        
        naslov.setFont(new Font(40));
        naslov.setStyle("-fx-text-fill: rgba(62, 64, 149, 1);");
        
        header.getChildren().addAll(logo, naslov);
    }

    public final StackPane getLayout() {
        return layout;
    }
    
    public final Button getObavjestenja() {
        return obavjestenja;
    }
    
}
