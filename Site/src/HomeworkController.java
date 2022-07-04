import java.io.IOException;
import java.time.LocalDateTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeworkController {

    @FXML
    private Button btnback;

    @FXML
    private Button downloadbtn;

    @FXML
    private Label endlbl;

    @FXML
    private Label gradelbl;

    @FXML
    private Label resttimelbl;

    @FXML
    private Button showbtn;

    @FXML
    private Label startlbl;

    @FXML
    private Label statuslbl;

    @FXML
    private Label titlelbl;

    @FXML
    private Button uploadbtn;

    @FXML
    void clckbtnBack(ActionEvent event) throws IOException {
        Stage pstage = (Stage) btnback.getScene().getWindow();
        pstage.close();
        FXMLLoader fxmlLoader;
        if(Login.getCurperson() instanceof Student) {
            fxmlLoader = new FXMLLoader(getClass().getResource("CoursePageSt.fxml"));
            
        } else {
            fxmlLoader = new FXMLLoader(getClass().getResource("CoursePageFa.fxml"));
        }
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void downloadbtnclk(ActionEvent event) {

    }

    @FXML
    void showbtnclk(ActionEvent event) {
        if (Login.getCurperson() instanceof Student) {
            titlelbl.setText(CoursePageSt.getCurhomework().getTitle());
            startlbl.setText(CoursePageSt.getCurhomework().getStartTime().year + "/" + CoursePageSt.getCurhomework().getStartTime().month + 
                    "/" + CoursePageSt.getCurhomework().getStartTime().day + " " + CoursePageSt.getCurhomework().getStartTime().hour + ":" + 
                     CoursePageSt.getCurhomework().getStartTime().minute + ":" + CoursePageSt.getCurhomework().getStartTime().second);
            endlbl.setText(CoursePageSt.getCurhomework().getEndTime().year + "/" + CoursePageSt.getCurhomework().getEndTime().month + 
                    "/" + CoursePageSt.getCurhomework().getEndTime().day + " " + CoursePageSt.getCurhomework().getEndTime().hour + ":" + 
                    CoursePageSt.getCurhomework().getEndTime().minute + ":" + CoursePageSt.getCurhomework().getEndTime().second);
            LocalDateTime localnow = LocalDateTime.now();
            Time now = new Time(localnow.getYear(), localnow.getMonthValue(), localnow.getDayOfMonth(), localnow.getHour(), localnow.getMinute(), localnow.getSecond());
            if(Time.Compare(now, CoursePageSt.getCurhomework().getEndTime())) {
                Time end = CoursePageSt.getCurhomework().getEndTime();
                if(CoursePageSt.getCurhomework().getState()) {
                    statuslbl.setText("Delivered");
                } else {
                    statuslbl.setText("Not Delivered");
                }
                resttimelbl.setText(Time.timetoString(Time.dif(now, end)) + " left");
            } else {
                Time end = CoursePageSt.getCurhomework().getEndTime();
                if(CoursePageSt.getCurhomework().getState()) {
                    statuslbl.setText("Delivered");
                } else {
                    statuslbl.setText("Not Delivered");
                }
                resttimelbl.setText(Time.timetoString(Time.dif(end, now)) + " passed");
                gradelbl.setText(Double.toString(CoursePageSt.getCurhomework().getGrade()));
                uploadbtn.setDisable(true);
            }
        } else {
            
        }
    }

    @FXML
    void uploadbtnclk(ActionEvent event) {

    }

}