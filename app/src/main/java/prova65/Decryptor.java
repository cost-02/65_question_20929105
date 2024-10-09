package main.java.prova65;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Decryptor {
    public static String decryptData(String encryptedData, String key) throws Exception {
        String[] parts = encryptedData.split("::");
        byte[] decodedBytes = Base64.decode(parts[0], Base64.DEFAULT);
        byte[] iv = Base64.decode(parts[1], Base64.DEFAULT);
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(iv));
        byte[] original = cipher.doFinal(decodedBytes);
        return new String(original);
    }
}
