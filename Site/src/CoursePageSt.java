import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CoursePageSt {

    private ArrayList<Notification> Notifications = new ArrayList<>();
    private ArrayList<Content> Contents = new ArrayList<>();
    private ArrayList<Homework> Homeworks = new ArrayList<>();
    private ArrayList<Exam> Exams = new ArrayList<>();
    private static Notification curnotif;
    private static Content curcontent;
    private static Homework curhomework;
    private static Exam curexam;

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
    private Button showbtn;

    @FXML
    private Button showcontentbtn;

    @FXML
    private Button showexambtn;

    @FXML
    private Button showhomevbtn;

    @FXML
    private Button shownotifbtn;

    
    @FXML
    void backbtnclk(ActionEvent event) throws IOException {
        Stage pstage = (Stage) backbtn.getScene().getWindow();
        pstage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePageSt.fxml"));
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
        coursenamelbl.setText(HomePageSt.getCurcourse().getTitle());
        for(int i=0;i<HomePageSt.getCurcourse().courseobjects.size();i++) {
            if(HomePageSt.getCurcourse().courseobjects.get(i) instanceof Notification) {
                Notifications.add((Notification)HomePageSt.getCurcourse().courseobjects.get(i));
            } else if(HomePageSt.getCurcourse().courseobjects.get(i) instanceof Content) {
                Contents.add((Content)HomePageSt.getCurcourse().courseobjects.get(i));
            } else if(HomePageSt.getCurcourse().courseobjects.get(i) instanceof Homework) {
                Homeworks.add((Homework)HomePageSt.getCurcourse().courseobjects.get(i));
            } else {
                Exams.add((Exam)HomePageSt.getCurcourse().courseobjects.get(i));
            }
        }
        setNotifmnu();
        setContentmnu();
        setHomewmnu();
        setExammnu();
    }

    @FXML
    void showcontentbtnclk(ActionEvent event) throws IOException {
        String selected = contentmnu.getValue();
        if(selected!=null) {
            for(int i=0;i<Contents.size();i++) {
                if(Contents.get(i).getTitle().equals(selected)) {
                    curcontent = Contents.get(i);
                    break;
                }
            }
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Select a folder");
            File directory = directoryChooser.showDialog((Stage) backbtn.getScene().getWindow());
            File source = new File(curcontent.getFilepath());
            File des = new File(directory.getPath()+"\\"+source.getName());
            Files.copy(source.toPath(), des.toPath());
        }
    }

    @FXML
    void showexambtnclk(ActionEvent event) throws IOException {
        String selected = exammnu.getValue();
        if(selected!=null) {
            for(int i=0;i<Exams.size();i++) {
                if(Exams.get(i).getTitle().equals(selected)) {
                    curexam = Exams.get(i);
                    break;
                }
            }
            Stage pstage = (Stage) showexambtn.getScene().getWindow();
            pstage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExamPage.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Welcome");
            stage.setAlwaysOnTop(true);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void showhomevbtnclk(ActionEvent event) throws IOException {
        String selected = homewmnu.getValue();
        if(selected!=null) {
            for(int i=0;i<Homeworks.size();i++) {
                if(Homeworks.get(i).getTitle().equals(selected)) {
                    curhomework = Homeworks.get(i);
                    break;
                }
            }
            Stage pstage = (Stage) showhomevbtn.getScene().getWindow();
            pstage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomeworkPage.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Welcome");
            stage.setAlwaysOnTop(true);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
        
    }

    @FXML
    void shownotifbtnclk(ActionEvent event) throws IOException {
        String selected = notifmnu.getValue();
        if(selected!=null) {
            for(int i=0;i<Notifications.size();i++) {
                if(Notifications.get(i).getTitle().equals(selected)) {
                    curnotif = Notifications.get(i);
                    break;
                }
            }
            Stage pstage = (Stage) shownotifbtn.getScene().getWindow();
            pstage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NotificationPage.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Welcome");
            stage.setAlwaysOnTop(true);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
    }


    private void setNotifmnu() {
        for(int i=0;i<Notifications.size();i++) {
            notifmnu.getItems().add(Notifications.get(i).getTitle());
        }
    }

    private void setContentmnu() {
        for(int i=0;i<Contents.size();i++) {
            contentmnu.getItems().add(Contents.get(i).getTitle());
        }
    }

    private void setHomewmnu() {
        for(int i=0;i<Homeworks.size();i++) {
            homewmnu.getItems().add(Homeworks.get(i).getTitle());
        }
    }

    private void setExammnu() {
        for(int i=0;i<Exams.size();i++) {
            exammnu.getItems().add(Exams.get(i).getTitle());
        }
    }

    public static Notification getCurnotif() {
        return curnotif;
    }

    public static Homework getCurhomework() {
        return curhomework;
    }

    public static Exam getCurexam() {
        return curexam;
    }

}

