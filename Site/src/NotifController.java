import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NotifController {

    @FXML
    private Label notiflbl;
    
    @FXML
    private Button showbtn;

    @FXML
    private Button backbtn;

    @FXML
    void showbtnclk(ActionEvent event) {
        if (Login.getCurperson() instanceof Student) {
            notiflbl.setText(CoursePageSt.getCurnotif().getText());
        } else {
            //notiflbl.setText(C);
        }
    }

    @FXML
    void backbtnclk(ActionEvent event) throws IOException {
        Stage pstage = (Stage) backbtn.getScene().getWindow();
        pstage.close();
        FXMLLoader fxmlLoader;
        if(Login.getCurperson() instanceof Student) {
            fxmlLoader = new FXMLLoader(getClass().getResource("CoursePageSt.fxml"));
        } else {
            fxmlLoader = new FXMLLoader(getClass().getResource("CoursePageFa.fxml"));
        }
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    

}
