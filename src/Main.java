
package parcial_03_withfx;


// Importaciones generales.
import java.io.IOException;

// Importaciones específicas JavaFX.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
    
    
    @Override
    public void start(Stage stage) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Interfaz.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Parcial_03_WithFX");
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        
        launch();
        
    }
    
    
}
