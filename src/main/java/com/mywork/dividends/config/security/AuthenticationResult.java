package com.mywork.dividends.config.security;

import static lombok.Lombok.checkNotNull;

public class AuthenticationResult {
  private final String apiToken;

  private final String userName;

  public AuthenticationResult(String apiToken, String userName) {
    checkNotNull(apiToken, "apiToken must be provided.");
    checkNotNull(userName, "userName must be provided.");

    this.apiToken = apiToken;
    this.userName = userName;
  }

  public String getApiToken() {
    return apiToken;
  }

  public String getUserName() {
    return userName;
  }
}
