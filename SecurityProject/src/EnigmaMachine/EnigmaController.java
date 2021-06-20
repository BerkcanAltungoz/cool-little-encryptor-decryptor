package EnigmaMachine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class EnigmaController {
    @FXML
    private ComboBox<Integer> rotor1;
    @FXML
    private ComboBox<String> set1;
    @FXML
    private ComboBox<String> offset1;
    @FXML
    private ComboBox<Integer> rotor2;
    @FXML
    private ComboBox<String> set2;
    @FXML
    private ComboBox<String> offset2;
    @FXML
    private ComboBox<Integer> rotor3;
    @FXML
    private ComboBox<String> set3;
    @FXML
    private ComboBox<String> offset3;
    @FXML
    private ComboBox<String> reflec;
    @FXML
    private TextArea plugboardText;
    @FXML
    private TextArea messageText;
    @FXML
    private Button enigmaOK;
    @FXML
    private Button backButton;
    @FXML
    private TextArea outputText;

    // Init Combo Boxes
    public void initialize() {
        rotor1.getItems().addAll(1,2,3);
        set1.getItems().addAll("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        offset1.getItems().addAll("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");

        rotor2.getItems().addAll(1,2,3);
        set2.getItems().addAll("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        offset2.getItems().addAll("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");

        rotor3.getItems().addAll(1,2,3);
        set3.getItems().addAll("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        offset3.getItems().addAll("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");

        reflec.getItems().addAll("B","C");
        reflec.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        // Get Values
        int rotor1Combo = rotor1.getValue();
        char setting1Combo = set1.getValue().charAt(0);
        char offset1Combo = offset1.getValue().charAt(0);
        int rotor2Combo = rotor2.getValue();
        char setting2Combo = set2.getValue().charAt(0);
        char offset2Combo = offset2.getValue().charAt(0);
        int rotor3Combo = rotor3.getValue();
        char setting3Combo = set3.getValue().charAt(0);
        char offset3Combo = offset3.getValue().charAt(0);
        char reflectorCombo = reflec.getValue().charAt(0);
        // Assign Values
        int[] rotorArr = new int[]{rotor1Combo,rotor2Combo,rotor3Combo};
        char[] settingArr = new char[]{setting1Combo,setting2Combo,setting3Combo};
        char[] offsetArr = new char[]{offset1Combo,offset2Combo,offset3Combo};

        String plugboardSetting = "";
        plugboardSetting = plugboardText.getText().toUpperCase();
        String messageInput = "";
        messageInput = messageText.getText().toUpperCase();

        // Create Enigma Machine
        Enigma enigmaMachine = new Enigma();
        enigmaMachine.config(rotorArr, settingArr, offsetArr,reflectorCombo, plugboardSetting);

        // Print Output
        String output = enigmaMachine.enigmaCipher(messageInput);
        outputText.setText(output);
    }
    @FXML
    private void backButtonAction(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Main/ui_main.fxml")));
            stage.setTitle("Security Project");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}