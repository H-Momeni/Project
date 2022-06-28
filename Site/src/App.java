
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static Scene scene;
    public static Stage stage;

    @Override
    public void start(Stage ignore) throws IOException {
<<<<<<< HEAD
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
=======
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
>>>>>>> 06fae8dd1043af7772bc394fd86e30712bd1867c
        stage = new Stage();
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
