import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SignUp {
    final FileChooser fileChooser = new FileChooser();
    private File selectedFile;

    @FXML
    private ImageView iv;

    @FXML
    private Button addprofile;

    @FXML
    private Button btnDone;

    @FXML
    private Button btnVerify;

    @FXML
    private Button refreshbtn;

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
    void clickRefreshbtn(ActionEvent event) throws IOException {
        Stage pstage = (Stage) refreshbtn.getScene().getWindow();
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
    void clickradiostudent(ActionEvent event) {
        if (radioStudent.isSelected()) {
            radioFaculty.setDisable(true);
        } else {
            radioFaculty.setDisable(false);
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

    @FXML
    void clickbtnDone(ActionEvent event) {
        if (txtFirstname.getText().compareTo("") == 0 || txtlastname.getText().compareTo("") == 0
                || txtUsername.getText().compareTo("") == 0 || textID.getText().compareTo("") == 0
                || txtMobilePhone.getText().compareTo("") == 0 || txtMajor.getText().compareTo("") == 0
                || txtPassword.getText().compareTo("") == 0 || txtEmail.getText().compareTo("") == 0
                || txtConfirmpass.getText().compareTo("") == 0 || (radioFaculty.isSelected() == false
                        && radioStudent.isSelected() == false)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Compelete all the parts!!");
            alert.showAndWait();
        } else if (!txtPassword.getText().equals(txtConfirmpass.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Enter password again!!");
            alert.showAndWait();
        } else {
            if (radioFaculty.isSelected() == true) {
                if (valid() == true) {
                    Faculty teacher = new Faculty(textID.getText(), txtPassword.getText(), txtFirstname.getText(),
                            txtlastname.getText(), txtUsername.getText(), txtMajor.getText(), txtEmail.getText(),
                            txtMobilePhone.getText());

                    if (selectedFile != null) {
                        teacher.setPhoto(selectedFile.getPath());
                    }
                    DataBase.AddUser(teacher);

                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Information Dialog");
                    alert2.setHeaderText(null);
                    alert2.setContentText("Successfully Registered!!");
                    alert2.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Fill text carefully!");
                    alert.showAndWait();
                }
            }
            if (radioStudent.isSelected() == true) {
                if (valid() == true) {
                    Student student = new Student(textID.getText(), txtPassword.getText(), txtFirstname.getText(),
                            txtlastname.getText(), txtUsername.getText(), txtMajor.getText(), txtEmail.getText(),
                            txtMobilePhone.getText());

                    if (selectedFile != null) {
                        student.setPhoto(selectedFile.getPath());
                    }
                    DataBase.AddUser(student);

                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Information Dialog");
                    alert2.setHeaderText(null);
                    alert2.setContentText("Successfully Registered!!");
                    alert2.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Fill text carefully!");
                    alert.showAndWait();
                }
            }
        }

    }

    @FXML
    void ClickbtnVerify(ActionEvent event) throws IOException {
        Stage pstage = (Stage) btnVerify.getScene().getWindow();
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

    public boolean valid() { // return true false
        boolean all;
        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
        boolean b5 = false;

        // Firstname-Lastname-Major
        Pattern pattern = Pattern.compile("[^a-zA-Z]", Pattern.CASE_INSENSITIVE);
        Matcher matcherfirstname = pattern.matcher(txtFirstname.getText());
        boolean matchFoundFirstname = matcherfirstname.find(); // false in doroste true in ghalate
        Matcher matcherlastname = pattern.matcher(txtlastname.getText());
        boolean matchFoundLastname = matcherlastname.find();
        Matcher matchermajor = pattern.matcher(txtMajor.getText());
        boolean matchFoundMajor = matchermajor.find();
        if ((txtFirstname.getText()).length() <= 15 && txtMajor.getText().length() <= 15
                && txtlastname.getText().length() <= 15) {
            b1 = true;
            System.out.println("b1:Match foundd");
        }
        if (matchFoundFirstname) {
            System.out.println("FirMatch found");
        } else {
            System.out.println("FirMatch not found");
        }
        if (matchFoundLastname) {
            System.out.println("LastMatch found");
        } else {
            System.out.println("LastMatch not found");
        }
        if (matchFoundMajor) {
            System.out.println("MajorMatch found");
        } else {
            System.out.println("MajorMatch not found");
        }

        // username-password
        Pattern pattern1 = Pattern.compile("[^a-zA-Z\\d]", Pattern.CASE_INSENSITIVE);
        Matcher matcherusername = pattern1.matcher(txtUsername.getText());
        boolean matchFoundUsername = matcherusername.find(); // false in doroste true in ghalate
        Matcher matcherPassword = pattern1.matcher(txtPassword.getText());
        boolean matchFoundPassword = matcherPassword.find();
        if (txtUsername.getText().length() <= 12 && 5 <= txtUsername.getText().length()) {
            b2 = true;
            System.out.println("b2Match foundd");
        }
        if (txtPassword.getText().length() <= 12 && 8 <= txtPassword.getText().length()) {
            b3 = true;
            System.out.println("b3Match foundd");
        }
        if (matchFoundUsername) {
            System.out.println("UserMatch found");
        } else {
            System.out.println("UserMatch not found");
        }
        if (matchFoundPassword) {
            System.out.println("PassMatch found");
        } else {
            System.out.println("PassMatch not found");
        }

        // Email
        Pattern pattern2 = Pattern.compile("[^a-zA-Z\\d@.-]", Pattern.CASE_INSENSITIVE);
        Matcher matcherEmail = pattern2.matcher(txtEmail.getText());
        boolean matchFoundEmail = matcherEmail.find(); // false in doroste true in ghalate
        if ((txtFirstname.getText()).length() <= 15) {
            b4 = true;
            System.out.println("4Match foundd");
        }
        if (matchFoundEmail) {
            System.out.println("EmailMatch found");
        } else {
            System.out.println("EmailMatch not found");
        }

        // Phonenumber
        if (txtMobilePhone.getText().length() == 11 && txtMobilePhone.getText().startsWith("09")) {
            b5 = true;
            System.out.println("5Match foundd");
        } else {
            System.out.println("5Match not foundd");
        }

        if (matchFoundFirstname == false && matchFoundLastname == false && matchFoundMajor == false
                && matchFoundUsername == false && matchFoundPassword == false && matchFoundEmail == false && b1 == true
                && b2 == true && b3 == true && b4 == true && b5 == true) {
            all = true;
        } else {
            all = false;
        }

        return all;
    }

}
