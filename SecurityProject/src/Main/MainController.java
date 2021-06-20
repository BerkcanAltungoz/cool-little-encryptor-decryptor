package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {
    @FXML
    private Button enigmaButton;
    @FXML
    private Button aesButton;

    @FXML
    private void enigmaButtonAction(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/EnigmaMachine/ui_enigma.fxml")));
            stage.setTitle("Enigma Machine WW2");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
    @FXML
    private void aesButtonAction(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/KeyEncryption/ui_aes.fxml")));
            stage.setTitle("AES Encrypt/Decrypt");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
