import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import javafx.animation.AnimationTimer;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePageFa {

    private static Course curcourse;
    private static Button[] coursebuttons = new Button[16];

 @FXML
    private Button refreshbtn;

    @FXML
    private Button addcoursebtn;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnMassnger;

    @FXML
    private Button btnTime;

    @FXML
    private Button btnback;

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
    private Label lblName;

    @FXML
    private ImageView profimg;

    @FXML
    private Text time;

    

    @FXML
    void addcoursebtnclk(ActionEvent event) {
        // after designing add page for course
    }
    @FXML
    void clickRefreshbtn(ActionEvent event) throws IOException {
        Stage pstage = (Stage) refreshbtn.getScene().getWindow();
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
    void clickTimebtn(ActionEvent event) throws IOException {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            }
        };
        lblName.setText(Login.getCurperson().getFirstName() + " " + Login.getCurperson().getLastName());
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
        if(Login.getCurperson().getPhoto() != null) {
            BufferedImage buff = ImageIO.read(Login.getCurperson().getPhoto());
            Image profile = SwingFXUtils.toFXImage(buff, null);
            profimg.setImage(profile);
        }
        timer.start();
    }

    @FXML
    void clickbtnMassanger(ActionEvent event) {

    }

    @FXML
    void coursebtnclk(ActionEvent event) throws IOException {
        Button b =  (Button) event.getSource();
        setCurcourse(b);
        Stage pstage = (Stage) btnback.getScene().getWindow();
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


    private static void setCurcourse(Button button) {
        for(int i=0; i<Login.getCurperson().courses.size(); i++) {
            if(button.getText().equals(coursebuttons[i].getText())) {
                curcourse = Login.getCurperson().courses.get(i);
                break;
            }
        }
    } 

    public static Course getCurcourse() {
        return curcourse;
    }

}