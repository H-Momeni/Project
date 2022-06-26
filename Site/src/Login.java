import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
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
    void Filltxtusername() {
        String user = txtusename.getText();
        // error baraye khali bodan ya nabodan da baze ya morede nazar
        if (user.isEmpty() || (user.length() != 10 && user.length() != 6)) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Error!");
            errorAlert.setContentText("Please enter correct usename!");
            errorAlert.showAndWait();
        } else {
            if (!isNumeric(user)) {
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Error!");
                errorAlert.setContentText("The username must have digits.");
                errorAlert.showAndWait();

            }

        }
    }

    @FXML
    void Filltxtpass() {
        String pass = textpassword.getText();
        // error baraye khali bodan ya nabodan dar baze ya morede nazar
        if (pass.isEmpty()) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Error!");
            errorAlert.setContentText("Please enter correct password!");
            errorAlert.showAndWait();
        }
    }

    @FXML
    void Clicksignupbtn() throws IOException {
        Stage stage = (Stage) btnsignup.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        Scene scene = new Scene(root, 600, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void Clicksubmitbtn(ActionEvent event) {
        btnSubmit.setDisable(
                !checkboxRobot.isSelected() || txtusename.getText().isEmpty() || textpassword.getText().isEmpty());

        //etesal be database

       /*  Stage main = (Stage) textpassword.getScene().getWindow();
        String t = textpassword.getText();
        main.setTitle(t);*/
    }

    public static boolean isNumeric(String string) {
        int intValue;

        if (string == null || string.equals("")) {
            // System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            // System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

}
