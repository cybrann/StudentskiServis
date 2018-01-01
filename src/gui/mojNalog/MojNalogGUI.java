package gui.mojNalog;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public abstract class MojNalogGUI {
    
    protected final VBox layout;
    private final Label naslov;
    protected final HBox container;
    protected final VBox tabela[];
    private final Label label[];
    protected final Label informacije[];
    

    protected MojNalogGUI() {
        layout      = new VBox();
        naslov      = new Label("Moj nalog");
        container   = new HBox();
        tabela      = new VBox[2];
        label       = new Label[10];
        informacije = new Label[10];
        
        layout.setSpacing(8);
        
        naslov.setFont(new Font(20));
        naslov.setId("naslov");
        naslov.setTextAlignment(TextAlignment.CENTER);
        naslov.prefWidthProperty().bind(layout.widthProperty());
        
        container.setId("container");
        container.setMaxWidth(300);
        
        tabela[0] = new VBox();
        tabela[1] = new VBox();
        
        label[0] = new Label(" Ime:");
        label[1] = new Label(" Prezime:");
        label[2] = new Label(" Ime oca:");
        label[3] = new Label(" Indeks:");
        label[4] = new Label(" Datum rodjenja:");
        label[5] = new Label(" Maticni broj:");
        label[6] = new Label(" Broj telefona:");
        label[7] = new Label(" Godina studija:");
        label[8] = new Label(" Fakultet:");
        label[9] = new Label(" Nacin upisa:");
        
        for (Label temp : label) {
            temp.setId("lijevi");
            temp.setPrefSize(150, 35);
            tabela[0].getChildren().add(temp);
        }
        
        for (int i = 0; i < informacije.length; i++) {
            informacije[i] = new Label();
        }
        
        container.getChildren().addAll(tabela[0], tabela[1]);
        layout.getChildren().addAll(naslov, container);
    }
    
    public final Parent getLayout() { return layout; }
    
}
