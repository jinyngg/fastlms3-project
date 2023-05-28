package com.zerobase.fastlms.history.service;

import com.zerobase.fastlms.history.entity.LoginHistory;
import com.zerobase.fastlms.history.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository historyRepository;

    public void saveLogOnLogin(LoginHistory loginHistory) {
        historyRepository.save(loginHistory);
    }

}
