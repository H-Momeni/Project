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

public class CoursePageFa {

    @FXML
    private Button addcontentbtn;

    @FXML
    private Button addexambtn;

    @FXML
    private Button addhomewbtn;

    @FXML
    private Button addnotifbtn;

    @FXML
    private Button addstudentbtn;

    @FXML
    private Button addstudentexbtn;

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
    void addcontentbtnclk(ActionEvent event) {

    }

    @FXML
    void addexambtnclk(ActionEvent event) {

    }

    @FXML
    void addhomewbtnclk(ActionEvent event) {

    }

    @FXML
    void addnotifbtnclk(ActionEvent event) {

    }

    @FXML
    void addstudentbtnclk(ActionEvent event) {

    }

    @FXML
    void addstudentexbtnclk(ActionEvent event) {

    }

    @FXML
    void backbtnclk(ActionEvent event) throws IOException {
        Stage pstage = (Stage) backbtn.getScene().getWindow();
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
    void showbtnclk(ActionEvent event) {
        coursenamelbl.setText(HomePageFa.getCurcourse().getTitle());
    }

}
