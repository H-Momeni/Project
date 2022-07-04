import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    private ChoiceBox<String> contentmnu;

    @FXML
    private Label coursenamelbl;

    @FXML
    private ChoiceBox<String> exammnu;

    @FXML
    private ChoiceBox<String> homewmnu;

    @FXML
    private ChoiceBox<String> notifmnu;

    @FXML
    private Button opencontentbtn;

    @FXML
    private Button openexambtn;

    @FXML
    private Button openhomewbtn;

    @FXML
    private Button opennotifbtn;

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
    void opencontentbtnclk(ActionEvent event) {

    }

    @FXML
    void openexambtnclk(ActionEvent event) {

    }

    @FXML
    void openhomewbtnclk(ActionEvent event) {

    }

    @FXML
    void opennotifbtnclk(ActionEvent event) {

    }

    @FXML
    void showbtnclk(ActionEvent event) {
        coursenamelbl.setText(HomePageFa.getCurcourse().getTitle());
    }

}

