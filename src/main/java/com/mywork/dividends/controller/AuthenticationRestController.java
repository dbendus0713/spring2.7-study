package com.mywork.dividends.controller;

import com.mywork.dividends.config.security.AuthenticationRequest;
import com.mywork.dividends.config.security.AuthenticationResult;
import com.mywork.dividends.config.security.JwtAuthenticationToken;
import com.mywork.dividends.dto.common.ApiResult;
import com.mywork.dividends.error.UnauthorizedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mywork.dividends.dto.common.ApiResult.OK;

@RestController
public class AuthenticationRestController extends AbstractController {
  private final AuthenticationManager authenticationManager;

  public AuthenticationRestController(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @PostMapping("/v1/auth")
  public ApiResult<AuthenticationResult> authentication(@RequestBody AuthenticationRequest authRequest) throws UnauthorizedException {
    try {
      JwtAuthenticationToken authToken = new JwtAuthenticationToken(authRequest.getPrincipal(), authRequest.getCredentials(), authRequest.isAdmin());
      Authentication authentication = authenticationManager.authenticate(authToken);
      SecurityContextHolder.getContext().setAuthentication(authentication);
      return OK((AuthenticationResult) authentication.getDetails());
    } catch (AuthenticationException e) {
      throw new UnauthorizedException(e.getMessage());
    }
  }
}
