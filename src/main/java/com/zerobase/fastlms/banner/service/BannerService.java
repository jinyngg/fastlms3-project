package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.banner.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BannerService {

    private final BannerRepository bannerRepository;

    @Transactional
    public List<BannerDto> list() {
        List<Banner> banners = bannerRepository.findAll();

        return banners.stream()
                .map(BannerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean add(BannerDto bannerDto) {
        Banner banner = Banner.builder()
                .bannerName(bannerDto.getBannerName())
                .imagePath(bannerDto.getImagePath())
                .alterText(bannerDto.getAlterText())
                .linkUrl(bannerDto.getLinkUrl())
                .target(bannerDto.getTarget())
                .bannerOrder(bannerDto.getBannerOrder())
                .isDisplayed(bannerDto.isDisplayed())
//                .regDt(LocalDateTime.now())
                .build();

        System.out.println("banner = " + banner);
        bannerRepository.save(banner);

        return true;
    }

}
