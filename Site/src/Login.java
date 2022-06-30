import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {
    private static Person curperson;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnforgetpass;

    @FXML
    private Button btnsignup;

    @FXML
    private PasswordField textpassword;

    @FXML
    private TextField txtusename;

    @FXML
    private RadioButton radioRobot;

    @FXML
    void clickSignupbtn(ActionEvent event) throws IOException {
        Stage pstage = (Stage) btnsignup.getScene().getWindow();
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
    void clicksubmitbtn(ActionEvent event) throws IOException {
        if (radioRobot.isSelected() == false || txtusename.getText().compareTo("") == 0
                || textpassword.getText().compareTo("") == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Compelete all the parts!!");
            alert.showAndWait();
        } else if (!DataBase.IDisVlaid(txtusename.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Education ID not found!!");
            alert.showAndWait();

        } else if (!DataBase.PasswordisValid(txtusename.getText(), textpassword.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect password!!");
            alert.showAndWait();
        } else {
            
            curperson = DataBase.FindUser(txtusename.getText());

            Stage pstage = (Stage) btnSubmit.getScene().getWindow();
            pstage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Welcome");
            stage.setAlwaysOnTop(true);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

        }
    }

    
    public static Person getCurperson() {
        return curperson;
    }

}
