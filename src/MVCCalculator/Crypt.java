package MVCCalculator;

public class Crypt {
    String filnamn;
    String meddelande;
    String keyFilename;
    String key;
    public void readTextFile() {


    }

    public void crypt() {
        if (key == null)
            readKey();
        encrypt(meddelande, key);
    }

    public void readKey() {

    }

    public void encrypt(String message, String key) {

    }
}

