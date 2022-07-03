import java.io.IOException;
import java.time.LocalDateTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ExamController {

    @FXML
    private Button btnback;

    @FXML
    private Label endlbl;

    @FXML
    private Label gradelbl;

    @FXML
    private Button reviewbtn;

    @FXML
    private Button showbtn;

    @FXML
    private Button startbtn;

    @FXML
    private Label startlbl;

    @FXML
    private Label statuslbl;

    @FXML
    private Label titlelbl;

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
    void reviewbtnclk(ActionEvent event) {

    }

    @FXML
    void showbtnclk(ActionEvent event) {
        if (Login.getCurperson() instanceof Student) {
            titlelbl.setText(CoursePageSt.getCurexam().getTitle());
            startlbl.setText(CoursePageSt.getCurexam().getStartTime().year + "/" + CoursePageSt.getCurexam().getStartTime().month + 
                    "/" + CoursePageSt.getCurexam().getStartTime().day + " " + CoursePageSt.getCurexam().getStartTime().hour + ":" + 
                     CoursePageSt.getCurexam().getStartTime().minute + ":" + CoursePageSt.getCurexam().getStartTime().second);
            endlbl.setText(CoursePageSt.getCurexam().getEndTime().year + "/" + CoursePageSt.getCurexam().getEndTime().month + 
                    "/" + CoursePageSt.getCurexam().getEndTime().day + " " + CoursePageSt.getCurexam().getEndTime().hour + ":" + 
                    CoursePageSt.getCurexam().getEndTime().minute + ":" + CoursePageSt.getCurexam().getEndTime().second);
            LocalDateTime localnow = LocalDateTime.now();
            Time now = new Time(localnow.getYear(), localnow.getMonthValue(), localnow.getDayOfMonth(), localnow.getHour(), localnow.getMinute(), localnow.getSecond());
            if(Time.Compare(now, CoursePageSt.getCurexam().getStartTime())) {
                startbtn.setDisable(true);
                reviewbtn.setDisable(true);
            } else if(Time.Compare(now, CoursePageSt.getCurexam().getEndTime())) {
                if(!CoursePageSt.getCurexam().getReview()) {
                    reviewbtn.setDisable(true);
                }
            } else {
                startbtn.setDisable(true);
                if(!CoursePageSt.getCurexam().getReview()) {
                    reviewbtn.setDisable(true);
                }
                if(CoursePageSt.getCurexam().getState()) {
                    statuslbl.setText("Checked");
                    gradelbl.setText(Double.toString(CoursePageSt.getCurexam().getGrade()));
                } else {
                    statuslbl.setText("Unchecked");
                }
            }
        } else {
            
        }
    }

    @FXML
    void startbtnclk(ActionEvent event) {

    }

}
