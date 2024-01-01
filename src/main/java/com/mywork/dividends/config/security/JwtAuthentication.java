package com.mywork.dividends.config.security;

import static lombok.Lombok.checkNotNull;

public class JwtAuthentication {

  public final String name;


  JwtAuthentication(String name) {
    checkNotNull(name, "name must be provided.");
    this.name = name;
  }

}