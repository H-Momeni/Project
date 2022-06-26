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
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignUp {

    @FXML
    private Button btnDone;

    @FXML
    private Button btnVerify;

    @FXML
    private RadioButton radioFaculty;

    @FXML
    private RadioButton radioStudent;

    @FXML
    private TextField textID;

    @FXML
    private PasswordField txtConfirmpass;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtMajor;

    @FXML
    private TextField txtMobilePhone;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtlastname;

    @FXML
    void clickradiofaculty(ActionEvent event) {
        if (radioFaculty.isSelected()) {
            radioStudent.setDisable(true);
        } else {
            radioStudent.setDisable(false);
        }
    }

    @FXML
    void clickradiostudent(ActionEvent event) {
        if (radioStudent.isSelected()) {
            radioFaculty.setDisable(true);
        } else {
            radioFaculty.setDisable(false);
        }
    }

    @FXML
    void clickbtnDone(ActionEvent event) {
        if (txtFirstname.getText().compareTo("") == 0 || txtlastname.getText().compareTo("") == 0
                || txtUsername.getText().compareTo("") == 0 || textID.getText().compareTo("") == 0
                || txtMobilePhone.getText().compareTo("") == 0 || txtMajor.getText().compareTo("") == 0
                || txtPassword.getText().compareTo("") == 0 || txtEmail.getText().compareTo("") == 0
                || txtConfirmpass.getText().compareTo("") == 0 || radioFaculty.isSelected() == false
                        && radioStudent.isSelected() == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Compelete all the parts!!");
            alert.showAndWait();
        } else {
            if (radioFaculty.isSelected() == true) {
                Faculty teacher = new Faculty();
                teacher.setFirstName(txtFirstname.getText());
                teacher.setLastName(txtlastname.getText());
                teacher.setUsername(txtUsername.getText());
                teacher.setDiscipline(txtMajor.getText());
                teacher.setID(textID.getText());
                teacher.setEmail(txtEmail.getText());
                teacher.setPhone(txtMobilePhone.getText());
                teacher.setPassword(txtPassword.getText());
                teacher.setConfirmpass(txtConfirmpass.getText());

                // etesal be data base

                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Information Dialog");
                alert2.setHeaderText(null);
                alert2.setContentText("Successfully Registered!!");
                alert2.showAndWait();
            }
            if (radioStudent.isSelected() == true) {
                Student student = new Student();
                student.setFirstName(txtFirstname.getText());
                student.setLastName(txtlastname.getText());
                student.setUsername(txtUsername.getText());
                student.setDiscipline(txtMajor.getText());
                student.setID(textID.getText());
                student.setEmail(txtEmail.getText());
                student.setPhone(txtMobilePhone.getText());
                student.setPassword(txtPassword.getText());
                student.setConfirmpass(txtConfirmpass.getText());

                // etesal be data base

                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Information Dialog");
                alert2.setHeaderText(null);
                alert2.setContentText("Successfully Registered!!");
                alert2.showAndWait();
            }
        }

    }

    @FXML
    void ClickbtnVerify(ActionEvent event) throws IOException {
        Stage pstage =(Stage) btnVerify.getScene().getWindow();
        pstage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
