package EnigmaMachine;

public class Reflector extends Assist {

    // Reflector B and C
    String[] reflectorSelect = {"YRUHQSLDPXNGOKMIEBFZCWVJAT","FVPJIAOYEDRZXWGCTKUQSBNMHL"};
    String permutation;
    int reflecNo;

    public void setReflector(char reflect){
        if(reflect == 'B'){
            reflecNo = 0;
        }
        else if(reflect == 'C'){
            reflecNo = 1;
        }
        else{
            reflecNo = 1;
        }
        permutation = reflectorSelect[reflecNo];
    }

    public char reflectorEncode(char n) {
        return indexToChar(permute(n - 'A', 1, permutation));
    }
}