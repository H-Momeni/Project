import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePage {

    @FXML
    private Button button1;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button13;

    @FXML
    private Button button14;

    @FXML
    private Button button15;

    @FXML
    private Button button16;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text time;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnMassnger;

    @FXML
    private Button btnback;

    @FXML
    private Button btnTime;

    @FXML
    private Label lblName;

    @FXML
    void clickTimebtn(ActionEvent event) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            }
        };
        lblName.setText(Login.getCurperson().getFirstName() + " " + Login.getCurperson().getLastName());
        Button[] coursebuttons = new Button[16];
        coursebuttons[0] = button1;
        coursebuttons[1] = button2;
        coursebuttons[2] = button3;
        coursebuttons[3] = button4;
        coursebuttons[4] = button5;
        coursebuttons[5] = button6;
        coursebuttons[6] = button7;
        coursebuttons[7] = button8;
        coursebuttons[8] = button9;
        coursebuttons[9] = button10;
        coursebuttons[10] = button11;
        coursebuttons[11] = button12;
        coursebuttons[12] = button13;
        coursebuttons[13] = button14;
        coursebuttons[14] = button15;
        coursebuttons[15] = button16;
        for(int i = 0; i< Login.getCurperson().courses.size(); i++) {
            coursebuttons[i].setVisible(true);
            coursebuttons[i].setText(Login.getCurperson().courses.get(i).getTitle());
        }
        timer.start();
    }

    @FXML
    void clckbtnBack(ActionEvent event) throws IOException {
        Stage pstage = (Stage) btnback.getScene().getWindow();
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

    @FXML
    void clckbtnEdit(ActionEvent event) throws IOException {
        Stage pstage = (Stage) btnEdit.getScene().getWindow();
        pstage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Editprof.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickbtnMassanger(ActionEvent event) {

    }

    @FXML
    void coursebtnclk(ActionEvent event) throws IOException {
        Stage pstage = (Stage) btnback.getScene().getWindow();
        pstage.close();
        FXMLLoader fxmlLoader;
        /* if(Login.getCurperson() instanceof Student) {
            fxmlLoader = new FXMLLoader(getClass().getResource("CoursePageSt.fxml"));
        } else {
            fxmlLoader = new FXMLLoader(getClass().getResource("CoursePageFa.fxml"));
        } */
        fxmlLoader = new FXMLLoader(getClass().getResource("CoursePageSt.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
