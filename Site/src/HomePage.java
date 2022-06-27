import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HomePage {
    private volatile boolean stop = false;
    private int minute;
    private int hour;
    private int second;

    @FXML
    Label time;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnMassnger;

    @FXML
    private Button btnback;

    @FXML
    private Label lblName;

    @FXML
    void SetName(MouseEvent event) {

    }

    @FXML
    void Time(MouseEvent event) {

    }

    @FXML
    void clckbtnBack(ActionEvent event) {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
        };
        timer.start();
    }

    @FXML
    void clckbtnEdit(ActionEvent event) {


    }

    @FXML
    void clickbtnMassanger(ActionEvent event) {

    }

    /*
     * private void Timenow(){
     * Thread thread = new Thread(() -> {
     * SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
     * while(!stop){
     * try{
     * Thread.sleep(1000);
     * }catch(Exception e){
     * System.out.println(e);
     * }
     * final String timenow = sdf.format(new Date(0));
     * Platform.runLater(() -> {
     * time.setText(timenow); // This is the label
     * });
     * }
     * });
     * thread.start();
     * }
     */

}
