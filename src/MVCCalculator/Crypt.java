package MVCCalculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Crypt {
    String messageFilname;
    String message;
    String keyFilename;
    String key;
    String cipherFilename;
    int [] cipher;

    public void readTextFile() {
        try {
            message = "";
            BufferedReader messageFile = new BufferedReader(new FileReader(messageFilname));
            String line = messageFile.readLine();
            while (line != null) {
                message += line +'\n';
                line = messageFile.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMessageFilname(String filename) {
        messageFilname = filename;
    }

    public void setMessage(String text) {
        message = text;
    }

    public void setKeyFilname(String filename) {
        keyFilename = filename;
    }

    public void setKey(String k) {
        key = k;
    }

    public int[] getCipher() {
        return cipher;
    }

    public void crypt() {
        if (message.length() == 0 || message == null)
            readTextFile();
        if (key.length() == 0 || key == null)
            readKey();
        encrypt(message, key);
    }

    public void readKey() {
        try {
            key = "";
            BufferedReader keyFile = new BufferedReader(new FileReader(keyFilename));
            String line = keyFile.readLine();
            while (line != null) {
                key += line +'\n';
                line = keyFile.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void encrypt(String message, String key) {
        cipher = new int[message.length()];
        while (key.length()<message.length()) {
            key += key;
        }
        for (int i = 0 ; i < message.length() ; i++) {
            cipher[i] = encrypt(message.charAt(i), key.charAt(i));
        }
    }

    public int encrypt(int m, int k) {
        return m^k;
    }

    public static void main(String[] args) {
        Crypt test = new Crypt();
        test.setKey("(((");
        test.setMessage("HEJ");
        test.crypt();
        int[] c = test.getCipher();
        System.out.println(""+(char)c[0]+(char)c[1]+(char)c[2]);
    }
}

