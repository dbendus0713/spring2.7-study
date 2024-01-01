package com.mywork.dividends.entity;

import javax.persistence.*;

@Entity(name = "admin_company")
public class AdminCompany {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="admin_user_id")
  private Admin admin;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="company_code")
  private Company company;
}
