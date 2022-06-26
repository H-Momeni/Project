import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    void btnOkKClicked(ActionEvent event) {
        Stage main=(Stage) textpassword.getScene().getWindow();
        String t=textpassword.getText();
        main.setTitle(t);
    }

}
