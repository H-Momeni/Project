import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateNotifController {

    @FXML
    private Button btnback;

    @FXML
    private Button sendbtn;

    @FXML
    private TextArea textlbl;

    @FXML
    private TextField titlelbl;

    @FXML
    void clckbtnBack(ActionEvent event) throws IOException {
        Stage pstage = (Stage) sendbtn.getScene().getWindow();
        pstage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CoursePageFa.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void sendbtnclk(ActionEvent event) {
        if(!titlelbl.getText().equals("") && !textlbl.getText().equals("")) {
            Notification newnotif = new Notification(titlelbl.getText(), textlbl.getText());
            HomePageFa.getCurcourse().courseobjects.add(newnotif);
            DataBase.AddObject(HomePageFa.getCurcourse(), newnotif);
        }
    }

}
