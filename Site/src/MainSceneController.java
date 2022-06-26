
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private TextField tfTitle;

    @FXML
    void btnOKClicked(ActionEvent event) {
        Stage main=(Stage) tfTitle.getScene().getWindow();
        String t=tfTitle.getText();
        main.setTitle(t);
    }

}
