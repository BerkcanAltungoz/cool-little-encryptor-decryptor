package EnigmaMachine;

public class Rotor extends Assist {

    public int rotorSetting, rotorOffset, rotorNotch;
    String permutation;

    public Rotor(String permutation, char setting, char offset, char notch) {
        this.permutation = permutation;
        rotorSetting = charToIndex(setting);
        rotorOffset = charToIndex(offset);
        rotorNotch = charToIndex(notch);
    }

    public char rotorEncrypt(char ch, int skip) {
        int index = (charToIndex(ch) + rotorOffset - rotorSetting + 26) % 26;
        int permutation = permute(index, skip, this.permutation);
        int output = (permutation - rotorOffset + rotorSetting + 26) % 26;
        return indexToChar(output);
    }

    public void next() {
        rotorOffset = (++rotorOffset) % 26;
    }

    public boolean ifNotch() {
        return (rotorNotch == rotorOffset);
    }


}