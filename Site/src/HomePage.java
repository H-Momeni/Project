import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePage {

    @FXML
    private Hyperlink Hypercourse;


    @FXML
    private Text time;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnMassnger;

    @FXML
    private Button btnback;

    @FXML
    private Label lblName;

    @FXML
    void clickTimebtn(ActionEvent event) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

                lblName.setText(Login.getCurperson().getFirstName() + " " + Login.getCurperson().getLastName());

            }
        };
        lblName.setText(Login.getCurperson().getFirstName() + " " + Login.getCurperson().getLastName());
        timer.start();
    }

    @FXML
    void clickHyperCourse(ActionEvent event) {
        int i = 0;
        int count = 20;// in 20 tedad doros daneshjo bayad bashe
        Button[] course = new Button[count];
        Stage pstage = (Stage) btnback.getScene().getWindow();
        pstage.close();
        Stage stage = new Stage();
        GridPane root = new GridPane();
        root.setVgap(30);
        root.setHgap(30);
        for (int k = 0; k < 3; k++) { // be sorat ye jadval 3*3 print mishe ke mitoni, taghir bedim
            for (int j = 0; j < 3; j++) {
                if (i != 13) { // in 13 tedad dros daneshjoee
                    course[i] = new Button("Course" + String.valueOf(i)); // avas shodan esm dar inja
                    Font font = Font.font("Courier New", FontWeight.BOLD, 18); // adad akhar size button
                    course[i].setFont(font);
                    root.add(course[i], k, j);
                    i++;
                }
            }
        }
        Scene scene = new Scene(root, 400, 400); // mitonim 400*400 ro avaz konim
        BackgroundFill background_fill = new BackgroundFill(Color.DARKBLUE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        root.setBackground(background);
        stage.setTitle("Courses");
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
    void clickbtnMassanger(ActionEvent event) {

    }

}
