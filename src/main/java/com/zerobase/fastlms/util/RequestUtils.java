package com.zerobase.fastlms.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RequestUtils {

    public static String getClientIp(HttpServletRequest request) {
        String clientIp = null;
        boolean isIpInHeader = false;

        List<String> headerList = new ArrayList<>();
        headerList.add("X-Forwarded-For");
        headerList.add("HTTP_CLIENT_IP");
        headerList.add("HTTP_X_FORWARDED_FOR");
        headerList.add("HTTP_X_FORWARDED");
        headerList.add("HTTP_FORWARDED_FOR");
        headerList.add("HTTP_FORWARDED");
        headerList.add("Proxy-Client-IP");
        headerList.add("WL-Proxy-Client-IP");
        headerList.add("HTTP_VIA");
        headerList.add("IPV6_ADR");

        for (String header : headerList) {
            clientIp = request.getHeader(header);
            if (StringUtils.hasText(clientIp) && !clientIp.equals("unknown")) {
                isIpInHeader = true;
                break;
            }
        }

        if (!isIpInHeader) {
            clientIp = request.getRemoteAddr();
        }

        return clientIp;
    }

    public static String getUserAgent(HttpServletRequest request) {
        String agent = request.getHeader("User-Agent");
        String brower = null;

        if (agent != null) {
//            if (agent.indexOf("Trident") > -1) {
//                brower = "MSIE";
//            } else if (agent.indexOf("Chrome") > -1) {
//                brower = "Chrome";
//            } else if (agent.indexOf("Opera") > -1) {
//                brower = "Opera";
//            } else if (agent.indexOf("iPhone") > -1 && agent.indexOf("Mobile") > -1) {
//                brower = "iPhone";
//            } else if (agent.indexOf("Android") > -1 && agent.indexOf("Mobile") > -1) {
//                brower = "Android";
//            }
            if (agent.contains("Trident")) {
                brower = "MSIE";
            } else if (agent.contains("Chrome")) {
                brower = "Chrome";
            } else if (agent.contains("Opera")) {
                brower = "Opera";
            } else if (agent.contains("iPhone") && agent.contains("Mobile")) {
                brower = "iPhone";
            } else if (agent.contains("Android") && agent.contains("Mobile")) {
                brower = "Android";
            }
        }

        return brower;
    }
}
