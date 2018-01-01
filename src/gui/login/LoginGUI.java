package gui.login;

import java.nio.file.Paths;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public abstract class LoginGUI {
    
    protected final StackPane layout;
    protected final VBox container;
    protected final ImageView logo;
    protected final Label korisnickoImeTxt;
    protected final TextField korisnickoIme;
    protected final Label lozinkaTxt;
    protected final PasswordField lozinka;
    protected final Button login;
    
    private final String relativnaPutanja = "file:\\" + Paths.get("").toAbsolutePath().toString();
    
    protected LoginGUI() {
        layout           = new StackPane();
        container        = new VBox();
        logo             = new ImageView(relativnaPutanja + "\\slike\\logo.png");
        korisnickoImeTxt = new Label("Korisnicko Ime:");
        korisnickoIme    = new TextField();
        lozinkaTxt       = new Label("Lozinka:");
        lozinka          = new PasswordField();
        login            = new Button("Login!");
        
        container.setId("border");
        container.setMaxSize(800, 500);
        
        korisnickoIme.setMaxWidth(250);
        korisnickoIme.setPromptText("2016/210243");
        
        lozinka.setMaxWidth(250);
        
        login.setPrefWidth(120);
        login.setDefaultButton(true);
        
        container.getChildren().addAll(logo, korisnickoImeTxt, korisnickoIme, lozinkaTxt, lozinka, login);
        layout.getChildren().addAll(new ImageView(relativnaPutanja + "\\slike\\login_pozadina.jpg"), container);
    }
    
    public Parent getLayout() { return layout; }
    
}
