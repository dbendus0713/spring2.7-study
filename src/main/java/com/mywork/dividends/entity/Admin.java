package com.mywork.dividends.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "admin_user")
public class Admin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String password;
  @Column
  private String userId;
  @Column
  private String orgName;

  @OneToOne
  @JoinColumn(name="company_code")
  private Company company;

  // 양방향 매핑
  @OneToMany(mappedBy = "admin", orphanRemoval = true, cascade = CascadeType.ALL)
//  @OneToMany(mappedBy = "admin")
  private List<AdminCompany> adminCompanyList = new ArrayList<>();

  @Column
  private LocalDateTime createAt = LocalDateTime.now();

  @Column
  private LocalDateTime expiredAt = LocalDateTime.now().plusYears(1);
}
