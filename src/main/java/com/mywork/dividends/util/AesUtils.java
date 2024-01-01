package com.mywork.dividends.util;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AesUtils {
  private static final String SECRET_KEY = "yourSecretKey1234"; // 32 글자 이상의 키를 사용해야 합니다.
  private static final String INIT_VECTOR = "encryptionIntVec"; // 16 글자의 초기화 벡터(IV)를 사용해야 합니다.

  public static String encrypt(String valueToEncrypt) {
    try {
      IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(StandardCharsets.UTF_8));
      SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

      byte[] encrypted = cipher.doFinal(valueToEncrypt.getBytes());
      return Base64.getEncoder().encodeToString(encrypted);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public static String decrypt(String encryptedValue) {
    try {
      IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(StandardCharsets.UTF_8));
      SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

      byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
      return new String(original);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    String originalString = "Hello, World! This is a message to encrypt/decrypt using AES.";
    System.out.println("Original String: " + originalString);

    String encryptedString = encrypt(originalString);
    System.out.println("Encrypted String: " + encryptedString);

    String decryptedString = decrypt(encryptedString);
    System.out.println("Decrypted String: " + decryptedString);
  }
}