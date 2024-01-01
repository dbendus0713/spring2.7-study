package com.mywork.dividends.entity;

public enum Role {
  USER("ROLE_USER"),
  ADMIN("ROLE_ADMIN"),
  SUPERADMIN("ROLE_SUPERADMIN");

  private String value;

  Role(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
