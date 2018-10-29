


import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class MessageEncryption {
    private String messageString;

    public MessageEncryption(String message, Key key,String type) throws Exception{
        byte[] plainText = message.getBytes(StandardCharsets.UTF_8);
        Cipher cipher = Cipher.getInstance(type+"/ECB/PKCS5Padding");
        // encrypt using the key and the plaintext
        

        final long startTime = System.nanoTime();
        //  Initializes the Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Calculates the ciphertext with a plaintext string.
        byte[] cipherText = cipher.doFinal(plainText);
        String str2="";

        for (byte b:cipherText) {
            str2 +=(char)b;
        }
        this.messageString = str2;
        final long duration = System.nanoTime() - startTime;
        Launcher.consoleBoxTextArea.append("It took " + duration + " nanosecond to Encrypt the message \"" + message +"\" using "+type+ "\n");
        Launcher.consoleBoxTextArea.append("Encrypted message is "+ messageString+"\n");
        Launcher.consoleBoxTextArea.append("Message length is " + message.length()+"\n");
        Graph.length.add((double)message.length());
        Graph.time.add((double)duration/100000);
    }

    public String getMessageString() {
        return messageString;
    }
}