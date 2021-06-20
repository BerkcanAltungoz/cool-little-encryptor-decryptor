package EnigmaMachine;

public class Enigma extends Assist {


    // Init Rotor and Notch Selection
    String[] rotorSelect = {"EKMFLGDQVZNTOWYHXUSPAIBRCJ", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "BDFHJLCPRTXVZNYEIWGAKMUSQO",
                            "ESOVPZJAYQUIRHXLNFTGKDCMWB", "VZBRGITYUPSDNHLXAWMJQOFECK"};
    char[] notchSelect = {'Q', 'E', 'V', 'J', 'Z'};

    // Create Parts
    Rotor[] rotors = new Rotor[3];

    Reflector reflector = new Reflector();

    Plugboard plugboard = new Plugboard();

    // Construct
    public void config(int[] ind, char[] setting, char[] offset, char reflect, String plugb) {

        for (int i = 0; i < 3; i++) {
            rotors[i] = new Rotor(rotorSelect[ind[i] - 1], setting[i], offset[i], notchSelect[ind[i] - 1]);
        }

        // Reflector Config
       reflector.setReflector(reflect);

        // Plugboard Config
        if (!plugb.isEmpty())
            plugboard.updatePairs(plugb);
    }


    // Main Encrypt Function
    public String enigmaCipher(String inputText) {

        char encryptChar;
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            // Space Handling
            if (inputText.charAt(i) == ' ') {
                encryptedText.append(" ");
                continue;
            }

            // Check Notch
            if (rotors[2].ifNotch() || rotors[1].ifNotch()) {
                if (rotors[1].ifNotch())
                    rotors[0].next();
                rotors[1].next();
            }
            rotors[2].next();

            // Pass Through Plugboard
            encryptChar = plugboard.encode(inputText.charAt(i));

            // Encoding
            encryptChar = rotors[2].rotorEncrypt(encryptChar, 1);
            encryptChar = rotors[1].rotorEncrypt(encryptChar, 1);
            encryptChar = rotors[0].rotorEncrypt(encryptChar, 1);

            encryptChar = reflector.reflectorEncode(encryptChar);

            encryptChar = rotors[0].rotorEncrypt(encryptChar, 2);
            encryptChar = rotors[1].rotorEncrypt(encryptChar, 2);
            encryptChar = rotors[2].rotorEncrypt(encryptChar, 2);

            encryptChar = plugboard.encode(encryptChar);

            encryptedText.append(encryptChar);
        }
        return encryptedText.toString();
    }
}

