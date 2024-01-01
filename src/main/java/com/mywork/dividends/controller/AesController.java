package com.mywork.dividends.controller;

import com.mywork.dividends.service.EncryptionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AesController extends AbstractController {
  private final EncryptionService encryptionService;

  public AesController(EncryptionService encryptionService) {
    this.encryptionService = encryptionService;
  }

  @PostMapping("/v1/encrypt")
  public String encrypt(@RequestBody String data) {
    return encryptionService.encrypt(data);
  }

  @PostMapping("/v1/decrypt")
  public String decrypt(@RequestBody Map<String, String> encryptedData) {
    return encryptionService.decrypt(encryptedData.get("encryptedData"));
  }
}
