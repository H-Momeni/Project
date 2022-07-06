import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStudentController {

    @FXML
    private TextField IDlbl;

    @FXML
    private Button addbtn;

    @FXML
    private Button backbtn;

    @FXML
    private TextField firstnamelbl;

    @FXML
    private TextField lastnamelbl;

    @FXML
    private Button refreshbtn;

    @FXML
    void addbtnclk(ActionEvent event) {
        if(!IDlbl.getText().equals("") && !firstnamelbl.getText().equals("") && !lastnamelbl.getText().equals("")) {
            Student newstudent = new Student(IDlbl.getText(), IDlbl.getText(), firstnamelbl.getText(), lastnamelbl.getText());
            DataBase.AddUser(newstudent);
            DataBase.AddCourse(newstudent, HomePageFa.getCurcourse());
        }
    }

    @FXML
    void backbtnclk(ActionEvent event) throws IOException {
        Stage pstage = (Stage) addbtn.getScene().getWindow();
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
    void clickRefreshbtn(ActionEvent event) throws IOException {
        Stage pstage = (Stage) addbtn.getScene().getWindow();
        pstage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addmanualStudent.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
