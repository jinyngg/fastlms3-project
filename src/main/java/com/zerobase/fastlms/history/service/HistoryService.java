package com.zerobase.fastlms.history.service;

import com.zerobase.fastlms.history.dto.UserLoginHistoryDto;
import com.zerobase.fastlms.history.entity.LoginHistory;
import com.zerobase.fastlms.history.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository historyRepository;

    public void saveLogOnLogin(LoginHistory loginHistory) {
        historyRepository.save(loginHistory);
    }

    public List<UserLoginHistoryDto> getUserLoginHistoryDtos(String userId) {

        List<LoginHistory> loginHistories = historyRepository.findLoginHistoriesByUserIdOrderByLoginDtDesc(userId);

        return loginHistories.stream()
                .map(UserLoginHistoryDto::fromEntity)
                .collect(Collectors.toList());

    }

}
