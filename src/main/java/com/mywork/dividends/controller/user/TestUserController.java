package com.mywork.dividends.controller.user;

import com.mywork.dividends.config.security.AuthenticationResult;
import com.mywork.dividends.config.security.JwtAuthentication;
import com.mywork.dividends.controller.AbstractController;
import com.mywork.dividends.dto.common.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mywork.dividends.dto.common.ApiResult.OK;

@Slf4j
@RestController
public class TestUserController extends AbstractController {

  @PreAuthorize("hasRole('USER')")
  @GetMapping("/v1/user/test")
  public ApiResult<Boolean> test(@AuthenticationPrincipal JwtAuthentication authentication) {
    log.info("authentication name:" + authentication.name);
    return OK(true);
  }
}
