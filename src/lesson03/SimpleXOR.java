package lesson03;

import java.util.Scanner;

public class SimpleXOR {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, input the text to encrypt");
        String message = scanner.next();

        System.out.println("Please, input the key");
        String key = scanner.next();

        byte [] encrypted = Encryption (message, key);
        System.out.println(encrypted);

        System.out.println("Please, input the key to decrypt");
        String key2 = scanner.next();

        String decrypted = Decryption(encrypted, key2);
        System.out.println(decrypted);

        System.exit(0);
        }


    public static byte [] Encryption (String message, String key)
    {
        byte [] messageB = message.getBytes();
        byte [] keyB = key.getBytes();
        for (int i = 0; i < message.length(); i++) {
            messageB [i] ^= keyB [i % keyB.length];
        }
        return messageB;
    }


    public static String Decryption (byte [] bt, String key)
    {
        byte [] keyB = key.getBytes();
        for (int i = 0; i < bt.length; i++) {
            bt [i] ^= keyB [i % keyB.length];
        }
        return new String(bt);
    }


}
