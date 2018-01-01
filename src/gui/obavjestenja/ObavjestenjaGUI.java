package gui.obavjestenja;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

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
        
        layout.setSpacing(8);
        layout.setPadding(new Insets(0, 10, 0, 0));
        
        container.setPadding(new Insets(15, 35, 35, 35));
        container.setSpacing(5);
        container.prefWidthProperty().bind(layout.widthProperty());
        container.setAlignment(Pos.TOP_CENTER);
        
        naslov.setFont(new Font(20));
        naslov.setId("naslov");
        naslov.setTextAlignment(TextAlignment.CENTER);
        naslov.prefWidthProperty().bind(layout.widthProperty());
        
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.prefHeightProperty().bind(layout.heightProperty());
        
        layout.getChildren().addAll(naslov, scrollPane);
    }
    
    public final Parent getLayout() { return layout; }
    
}
