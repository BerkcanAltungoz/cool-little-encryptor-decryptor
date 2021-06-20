package EnigmaMachine;

public class Assist {

    public int permute(int ch, int skip, String permutation) {

        if (skip == 1)
            return charToIndex(permutation.charAt(ch));

        else
            return permutation.indexOf(indexToChar(ch));
    }

    public char indexToChar(int i) {
        return (char) (i + 'A');
    }

    public int charToIndex(char ch) {
        return (ch - 'A') % 26;
    }


}