package com.mywork.dividends.service;

import com.mywork.dividends.config.AesConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.util.Base64;

@Slf4j
@Service
public class EncryptionService {
  private final AesConfig aesConfig;

  public EncryptionService(AesConfig aesConfig) {
    this.aesConfig = aesConfig;
  }

  public byte[] getSecretKeyByte() {
    byte[] decodedBytes = Base64.getDecoder().decode(aesConfig.getSecretKey());
    return decodedBytes;
  }

  public String getSecretKey() {
    String decodedString = new String(getSecretKeyByte());
    return decodedString;
  }

  public String getInitVector() {
    return aesConfig.getInitVector();
  }

  public String encrypt(String valueToEncrypt) {
    try {
      IvParameterSpec iv = new IvParameterSpec(getInitVector().getBytes());
      SecretKeySpec skeySpec = new SecretKeySpec(getSecretKeyByte(), "AES");

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

      byte[] encrypted = cipher.doFinal(valueToEncrypt.getBytes("UTF-8"));
      return Base64.getEncoder().encodeToString(encrypted);
    } catch (Exception ex) {
      log.error("encrypt error", ex);
    }
    return null;
  }

  public String decrypt(String encryptedValue) {
    try {
      IvParameterSpec iv = new IvParameterSpec(getInitVector().getBytes());
      SecretKeySpec skeySpec = new SecretKeySpec(getSecretKeyByte(), "AES");

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

      byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedValue.getBytes()));
      return new String(original, "UTF-8");
    } catch (Exception ex) {
      log.error("encrypt error", ex);
    }
    return null;
  }

}
