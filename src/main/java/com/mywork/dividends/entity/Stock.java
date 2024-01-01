package com.mywork.dividends.entity;

import javax.persistence.*;

@Entity
public class Stock {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String stockType;
  @Column
  private String stockName;

  @OneToOne
  @JoinColumn(name="companyCode")
  private Company company;
}
