package KeyEncryption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Base64;

public class AESController {
    @FXML
    private TextArea keyText;
    @FXML
    private TextArea decryptText;
    @FXML
    private TextArea encryptText;
    @FXML
    private TextArea outputText;
    @FXML
    private Button generateButton;
    @FXML
    private Button encryptButton;
    @FXML
    private Button decryptButton;
    @FXML
    private Button backButton;

    SecretKey secretKey;
    String keyString;
    String textToEncrypt;
    String textToDecrypt;
    String output;
    byte[] encryptByte;
    byte[] decryptByte;
    byte[] outputByte;

    public void initialize() {
    }

    @FXML
    private void generateButtonAction(ActionEvent event) {
        // Generate Key
        secretKey = AES.generateKey();
        // Encode to String and Print
        keyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        keyText.setText(keyString);

    }

    @FXML
    private void encryptButtonAction(ActionEvent event) {
        // Get Text and Key to Encrypt
        keyString = keyText.getText();
        secretKey = AES.decodeKey(keyString);
        textToEncrypt = encryptText.getText();
        encryptByte = textToEncrypt.getBytes();
        // Encrypt and Print
        outputByte = AES.encryptTextByte(secretKey, encryptByte);
        output = Base64.getEncoder().encodeToString(outputByte);
        outputText.setText(output);
    }

    @FXML
    private void decryptButtonAction(ActionEvent event) {
        // Get Text and Key to Decrypt
        keyString = keyText.getText();
        secretKey = AES.decodeKey(keyString);
        textToDecrypt = decryptText.getText();
        decryptByte = Base64.getDecoder().decode(textToDecrypt);
        // Decrypt and Print
        outputByte = AES.decryptTextByte(secretKey, decryptByte);
        output = new String(outputByte);
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

