import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnforgetpass;

    @FXML
    private Button btnsignup;

    @FXML
    private CheckBox checkboxRobot;

    @FXML
    private TextField textpassword;

    @FXML
    private TextField txtusename;

    @FXML
    void clickSignupbtn(ActionEvent event) throws IOException {
        Stage pstage =(Stage) btnsignup.getScene().getWindow();
        pstage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUpPage.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clicksubmitbtn(ActionEvent event) {

    }

}
