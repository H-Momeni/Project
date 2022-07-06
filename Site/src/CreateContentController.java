import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CreateContentController {

    @FXML
    private Button btnback;

    @FXML
    private TextField titlelbl;

    @FXML
    private Button uploadbtn;

    @FXML
    void clckbtnBack(ActionEvent event) throws IOException {
        Stage pstage = (Stage) uploadbtn.getScene().getWindow();
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
    void uploadbtnclk(ActionEvent event) {
        if(!titlelbl.getText().equals("")) {
            FileChooser fileChooser = new FileChooser();
            File newcontentfile = fileChooser.showOpenDialog(null);
            if(newcontentfile!=null) {
                Content newcontent = new Content(titlelbl.getText(), newcontentfile.getPath());
                HomePageFa.getCurcourse().courseobjects.add(newcontent);
                DataBase.AddObject(HomePageFa.getCurcourse(), newcontent);
            }
        }
    }

}
