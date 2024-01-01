package com.mywork.dividends.repository;

import com.mywork.dividends.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
  Admin findAdminByUserId(String userId);
  Admin findAdminByUserIdAndPassword(String userId, String password);
}
