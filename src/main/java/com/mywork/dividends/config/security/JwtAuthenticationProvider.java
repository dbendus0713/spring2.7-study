package com.mywork.dividends.config.security;


import com.mywork.dividends.entity.Admin;
import com.mywork.dividends.entity.Role;
import com.mywork.dividends.error.NotFoundException;
import com.mywork.dividends.repository.AdminRepository;
import com.mywork.dividends.service.MobileOkService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.apache.commons.lang3.ClassUtils.isAssignable;
import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

  private final JWT jwt;

  private final AdminRepository adminRepository;
  private final MobileOkService mobileOkService;


  public JwtAuthenticationProvider(JWT jwt, AdminRepository adminRepository, MobileOkService mobileOkService) {
    this.jwt = jwt;
    this.adminRepository = adminRepository;
    this.mobileOkService = mobileOkService;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    JwtAuthenticationToken authenticationToken = (JwtAuthenticationToken) authentication;
    return processUserAuthentication(authenticationToken.authenticationRequest());
  }

  private Authentication processUserAuthentication(AuthenticationRequest request) {
    try {
      JwtAuthenticationToken authenticated = null;
      boolean isAdmin = request.isAdmin();
      String userName = null;
      String[] authorityArr = null;
      if (isAdmin) {
        Admin adminUser = adminRepository.findAdminByUserIdAndPassword(request.getPrincipal(), request.getCredentials());
        userName = adminUser.getUserId();
        if (StringUtils.equals("dk_admin", adminUser.getUserId())) {
          authorityArr = new String[]{Role.ADMIN.value(), Role.SUPERADMIN.value()};
        } else {
          authorityArr = new String[]{Role.ADMIN.value()};
        }
        authenticated = new JwtAuthenticationToken(adminUser.getId(), null, true, createAuthorityList(authorityArr));
      } else {
        //전화번호 인증
        boolean isAuthenticated = true;
        if (isAuthenticated) {
          userName = "";
          authorityArr = new String[]{Role.USER.value()};
          authenticated =
              new JwtAuthenticationToken(userName, null, true, createAuthorityList(authorityArr));
        }
      }
      JWT.Claims claims = JWT.Claims.of(userName, authorityArr);
      authenticated.setDetails(new AuthenticationResult(jwt.newToken(claims), userName));
      return authenticated;
    } catch (NotFoundException e) {
      throw new UsernameNotFoundException(e.getMessage());
    } catch (IllegalArgumentException e) {
      throw new BadCredentialsException(e.getMessage());
    } catch (DataAccessException e) {
      throw new AuthenticationServiceException(e.getMessage(), e);
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return isAssignable(JwtAuthenticationToken.class, authentication);
  }

}