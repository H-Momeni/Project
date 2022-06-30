import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NotifController {

    @FXML
    private Label notiflbl;
    public String text;

    public void show(String text) {
        notiflbl.setText(text);
    }

}
