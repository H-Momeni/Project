import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
            if (isNumeric(user)) {

                //rikhtan to data base

            } else {
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Error!");
                errorAlert.setContentText("The username must have digits.");
                errorAlert.showAndWait();
            }

        }
    }

    @FXML
    void btnOkKClicked(ActionEvent event) {
        Stage main = (Stage) textpassword.getScene().getWindow();
        String t = textpassword.getText();
        main.setTitle(t);
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
