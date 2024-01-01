package com.mywork.dividends.entity;

public enum Gender {
  DUMMY(0),
  MAN(1),
  WOMAN(2);

  private int value;

  Gender(int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
