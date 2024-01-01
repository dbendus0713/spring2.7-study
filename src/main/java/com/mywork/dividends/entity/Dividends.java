package com.mywork.dividends.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
public class Dividends {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private BigDecimal amount;

  @OneToOne
  @JoinColumn(name="id")
  private Stock stock;

  @Column
  private LocalDateTime startAt = LocalDateTime.now();

  @Column
  private LocalDateTime expiredAt = LocalDateTime.now();

  @OneToOne
  @JoinColumn(name="company_code")
  private Company company;
}
