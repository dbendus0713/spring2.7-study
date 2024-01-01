package com.mywork.dividends.dto.mobile;

import com.mywork.dividends.entity.Gender;
import com.mywork.dividends.entity.Nation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MobileIfDto {
  /* 사용자 이름 */
  private String userName;
  /* 이용기관 ID */
  private String siteID;
  /* 이용기관 거래 ID */
  private String clientTxId;
  /* 본인확인 거래 ID */
  private String txId;
  /* 서비스제공자(인증사업자) ID */
  private String providerId;
  /* 이용 서비스 유형 */
  private String serviceType;
  /* 시용자 CI */
  private String ci;
  /* 사용자 DI */
  private String di;
  /* 사용자 전화번호 */
  private String userPhone;
  /* 사용자 생년월일 */
  private String userBirthday;
  /* 사용자 성별 (1: 남자, 2: 여자) */
  private Gender userGender;
  /* 사용자 국적 (0: 내국인, 1: 외국인) */
  private Nation userNation;
  /* 본인확인 인증 종류 */
  private String reqAuthType;
  /* 본인확인 요청 시간 */
  private String reqDate;
  /* 본인확인 인증 서버 */
  private String issuer;
  /* 본인확인 인증 시간 */
  private String issueDate;


}