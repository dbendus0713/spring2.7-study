package com.mywork.dividends.service;

import com.mywork.dividends.dto.mobile.MobileIfDto;
import org.springframework.stereotype.Service;

@Service
public class MobileOkServiceImpl implements MobileOkService {

  @Override
  public MobileIfDto getUserInfoFromMobileOk() {
    return MobileIfDto.builder().build();
  }
}
