package com.zerobase.fastlms.history.dto;

import com.zerobase.fastlms.history.entity.LoginHistory;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginHistoryDto {

    private Integer id;
    private String userId;
    private LocalDateTime loginDt;
    private String clientIp;
    private String userAgent;

    public static UserLoginHistoryDto fromEntity(LoginHistory loginHistory) {
        return UserLoginHistoryDto.builder()
                .id(loginHistory.getId())
                .userId(loginHistory.getUserId())
                .loginDt(loginHistory.getLoginDt())
                .clientIp(loginHistory.getClientIp())
                .userAgent(loginHistory.getUserAgent())
                .build();
    }

}