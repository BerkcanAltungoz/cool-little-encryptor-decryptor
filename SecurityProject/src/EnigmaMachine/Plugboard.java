package EnigmaMachine;

public class Plugboard extends Assist {

    String permutation = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Create Pairs
    public void updatePairs(String plugPairs) {
        StringBuilder newString = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String[] pairArray = plugPairs.split(" ");

        // Switch Pairs
        for (int i = 0; i < pairArray.length; i++) {
            int x = charToIndex(pairArray[i].charAt(0));
            int y = charToIndex(pairArray[i].charAt(1));
            newString.setCharAt(x, pairArray[i].charAt(1));
            newString.setCharAt(y, pairArray[i].charAt(0));
        }
        permutation = newString.toString();
    }

    // Plugboard Permutation
    public char encode(char n) {
        return indexToChar(permute(n - 'A', 1, permutation));
    }

}