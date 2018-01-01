package gui.obavjestenja;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public abstract class ObavjestenjaGUI {
    
    protected final VBox layout;
    protected final ScrollPane scrollPane;
    protected final VBox container;
    protected final Label naslov;
    
    protected ObavjestenjaGUI() {
        layout     = new VBox();
        scrollPane = new ScrollPane();
        container  = new VBox();
        naslov     = new Label("Obavjestenja");
        
        layout.setId("obavjestenjaLayout");
        
        container.prefWidthProperty().bind(layout.widthProperty());
        container.setId("containerObavjestenja");
        
        naslov.setId("naslov");
        naslov.prefWidthProperty().bind(layout.widthProperty());
        
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.prefHeightProperty().bind(layout.heightProperty());
        
        layout.getChildren().addAll(naslov, scrollPane);
    }
    
    public final Parent getLayout() { return layout; }
    
}
