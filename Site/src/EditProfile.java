import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EditProfile {
    final FileChooser fileChooser = new FileChooser();
    private File selectedFile;

    @FXML
    private ImageView iv;

    @FXML
    private Button addprofile;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnback;

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
    void ClickbtnBack(ActionEvent event) throws IOException {
        Stage pstage = (Stage) btnback.getScene().getWindow();
        pstage.close();
        FXMLLoader fxmlLoader;
        if (Login.getCurperson() instanceof Student) {
            fxmlLoader = new FXMLLoader(getClass().getResource("HomePageSt.fxml"));
        } else {
            fxmlLoader = new FXMLLoader(getClass().getResource("HomePageFa.fxml"));
        }
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickbtnUpdate(ActionEvent event) {
        if(!txtFirstname.getText().equals("")) {
            Login.getCurperson().setFirstName(txtFirstname.getText());
            DataBase.EditUser(Login.getCurperson());
        }
        if(!txtlastname.getText().equals("")) {
            Login.getCurperson().setLastName(txtlastname.getText());
            DataBase.EditUser(Login.getCurperson());
        }
        if(!txtUsername.getText().equals("")) {
            Login.getCurperson().setUsername(txtUsername.getText());
            DataBase.EditUser(Login.getCurperson());
        }
        if(!txtMajor.getText().equals("")) {
            Login.getCurperson().setDiscipline(txtMajor.getText());
            DataBase.EditUser(Login.getCurperson());
        }
        if(!txtEmail.getText().equals("")) {
            Login.getCurperson().setEmail(txtEmail.getText());
            DataBase.EditUser(Login.getCurperson());
        }
        if(!txtMobilePhone.getText().equals("")) {
            Login.getCurperson().setPhone(txtMobilePhone.getText());
            DataBase.EditUser(Login.getCurperson());
        }
        if(!txtPassword.getText().equals("")) {
            if(txtPassword.getText().equals(txtConfirmpass.getText())) {
                Login.getCurperson().setFirstName(txtFirstname.getText());
                DataBase.EditUser(Login.getCurperson());
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Enter password again!!");
                alert.showAndWait();
            }
        }

    }

    @FXML
    void clickprofbtn(ActionEvent event) {
        selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {

            final InputStream targetStream;
            try {
                targetStream = new DataInputStream(new FileInputStream(selectedFile));
                Image image = new Image(targetStream);
                iv.setImage(image);
                iv.setVisible(true);
                // addprofile.setVisible(false);

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

        }
    }

}