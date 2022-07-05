import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateCourseController {

    @FXML
    private Button btnback;

    @FXML
    private Button donebtn;

    @FXML
    private TextField titlelbl;

    @FXML
    void clckbtnBack(ActionEvent event) throws IOException {
        Stage pstage = (Stage) btnback.getScene().getWindow();
        pstage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePageFa.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void donebtnclk(ActionEvent event) {
        if(!titlelbl.getText().equals("")) {
            Course newcourse = new Course(titlelbl.getText());
            Login.getCurperson().courses.add(newcourse);
            DataBase.AddCourse(Login.getCurperson(), newcourse);
        }
    }

}
