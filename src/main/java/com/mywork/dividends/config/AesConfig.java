package com.mywork.dividends.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "encryption")
public class AesConfig {
  @Value("${encryption.secret-key}")
  private String secretKey;

  @Value("${encryption.init-vector}")
  private String initVector;

  public String getSecretKey() {
    return secretKey;
  }

//  public void setSecretKey(String secretKey) {
//    this.secretKey = secretKey;
//  }

  public String getInitVector() {
    return initVector;
  }

//  public void setInitVector(String initVector) {
//    this.initVector = initVector;
//  }
}
