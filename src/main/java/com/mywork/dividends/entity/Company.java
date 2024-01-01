package com.mywork.dividends.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {
  @Id
  @Column
  private String companyCode;
  @Column
  private String companyName;
}
