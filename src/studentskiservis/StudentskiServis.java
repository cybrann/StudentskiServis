package studentskiservis;

import baza.DBM;
import gui.Layout;
import podaci.Podaci;
import javafx.application.Application;
import javafx.stage.Stage;
import student.Student;

public final class StudentskiServis extends Application {
    
    public static Student student;
    
    @Override
    public void start(Stage primaryStage) {
        DBM.konektuj();
        Podaci.ucitajPodatke();
        Layout.init();
        
        Layout.scene.getStylesheets().add(Layout.class.getResource("Izgled.css").toExternalForm());
        
        primaryStage.setOnCloseRequest(e -> { DBM.diskonektuj(); System.exit(0); });
        primaryStage.setTitle("Studentski Servis");
        primaryStage.setResizable(false);
        primaryStage.setScene(Layout.scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
