import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CreateExamController {

    @FXML
    private Button btnback;

    @FXML
    private TextField daylbl;

    @FXML
    private TextField hourlbl;

    @FXML
    private TextField minutelbl;

    @FXML
    private TextField monthlbl;

    @FXML
    private CheckBox reviewbtn;

    @FXML
    private TextField secondlbl;

    @FXML
    private TextField titlelbl;

    @FXML
    private Button uploadbtn;

    @FXML
    private TextField yearlbl;

    @FXML
    void clckbtnBack(ActionEvent event) throws IOException {
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

    @FXML
    void uploadbtnclk(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File qusfile = fileChooser.showOpenDialog(null);
        if(!titlelbl.getText().equals("") && !yearlbl.getText().equals("") 
            && !monthlbl.getText().equals("") && !daylbl.getText().equals("")
            && !hourlbl.getText().equals("") && !minutelbl.getText().equals("")
            && !secondlbl.getText().equals("") && qusfile !=null) {
                
                int year = Integer.valueOf(yearlbl.getText());
                int month = Integer.valueOf(monthlbl.getText());
                int day = Integer.valueOf(daylbl.getText());
                int hour = Integer.valueOf(hourlbl.getText());
                int minute = Integer.valueOf(minutelbl.getText());
                int second = Integer.valueOf(secondlbl.getText());
                Time end = new Time(year, month, day, hour, minute, second);
                LocalDateTime localnow = LocalDateTime.now();
                Time now = new Time(localnow.getYear(), localnow.getMonthValue(), localnow.getDayOfMonth(), localnow.getHour(), localnow.getMinute(), localnow.getSecond());
                Exam newexam = new Exam(titlelbl.getText(), qusfile.getPath(), now, end, reviewbtn.isSelected());
                HomePageFa.getCurcourse().courseobjects.add(newexam);
                DataBase.AddObject(HomePageFa.getCurcourse() , newexam);
        }
    }

}
