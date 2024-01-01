package com.mywork.dividends.repository;

import com.mywork.dividends.entity.Admin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
class AdminRepositoryTest {
  @Autowired
  private AdminRepository adminRepository;

  @Test
  void select() {
    Admin admin = adminRepository.findAdminByUserId("dk_admin");
    assertEquals("dk_admin", admin.getUserId(), "Test failed");

  }
}
