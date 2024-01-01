package com.mywork.dividends.config.security;


public class AuthenticationRequest {

  private String principal;

  private String credentials;

  private boolean isAdmin;

  protected AuthenticationRequest() {}

  public AuthenticationRequest(String principal, String credentials) {
    this.principal = principal;
    this.credentials = credentials;
    this.isAdmin = false;
  }

  public AuthenticationRequest(String principal, String credentials, boolean isAdmin) {
    this.principal = principal;
    this.credentials = credentials;
    this.isAdmin = isAdmin;
  }

  public String getPrincipal() {
    return principal;
  }

  public String getCredentials() {
    return credentials;
  }

  public boolean isAdmin() { return isAdmin; }

}
