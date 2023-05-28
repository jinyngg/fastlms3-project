package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.history.entity.LoginHistory;
import com.zerobase.fastlms.history.service.HistoryService;
import com.zerobase.fastlms.member.service.impl.MemberServiceImpl;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final HistoryService historyService;
    private final MemberServiceImpl memberService;

    public UserAuthenticationSuccessHandler(HistoryService historyService, MemberServiceImpl memberService) {
        this.historyService = historyService;
        this.memberService = memberService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;

        String userId = userDetails.getUsername();
        String userAgent = RequestUtils.getUserAgent(request);
        String clientIp = RequestUtils.getClientIp(request);

        LoginHistory loginHistory = LoginHistory.builder()
                .userId(userId)
                .userAgent(userAgent)
                .clientIp(clientIp)
                .build();

        historyService.saveLogOnLogin(loginHistory);
        memberService.updateLastLoginDt(userId, LocalDateTime.now());

        if (null != loginHistory) {
            log.info("=== Login Log Save ===");
            log.info("User Id = " + loginHistory.getUserId() + ", User Agent = " + loginHistory.getUserAgent() + ", User Ip = " + loginHistory.getClientIp() + ", Last Access Date = " + loginHistory.getLoginDt().toLocalDate());

        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
