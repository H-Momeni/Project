import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;

public class CoursePageSt {

    @FXML
    private Button backbtn;

    @FXML
    private ChoiceBox<?> contentmnu;

    @FXML
    private Label coursenamelbl;

    @FXML
    private SplitMenuButton exammnu;

    @FXML
    private SplitMenuButton homewmnu;

    @FXML
    private ChoiceBox<?> notifmnu;

    @FXML
    private Button showbtn;


    @FXML
    void backbtnclk(ActionEvent event) throws IOException {
        Stage pstage = (Stage) backbtn.getScene().getWindow();
        pstage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void showbtnclk(ActionEvent event) {
        coursenamelbl.setText(HomePage.getCurcourse().getTitle());
        for(int i=0;i<HomePage.getCurcourse().courseobjects.size();i++) {
            if(HomePage.getCurcourse().courseobjects.get(i) instanceof Notification) {
                // continue...
            }
        }
    }

}

