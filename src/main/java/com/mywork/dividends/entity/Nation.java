package com.mywork.dividends.entity;

public enum Nation {
  LOCAL(0),
  FOREIGNER(1);

  private int value;

  Nation(int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
