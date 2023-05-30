package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.admin.model.CommonParam;
import com.zerobase.fastlms.banner.entity.Banner;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BannerDto extends CommonParam {

    private Long id;
    private String bannerName; // 배너명
    private String imagePath; // 배너 이미지 파일의 URL
    private String alterText; // 배너 이미지의 Alter 텍스트(대체 텍스트),
    private String linkUrl; // 배너 클릭 시 이동하는 URL 정보
    private String target; // 클릭 시 이동하는 창의 타겟 정보 (새 창인지, 현재 창 이동인지)
    private String bannerOrder; // 배너의 정렬 순서
    private boolean isDisplayed; // 프론트에 표시 여부 정보
    private LocalDateTime regDt;

//    long totalCount;
//    long seq;

    public static Banner toEntity(BannerDto bannerDto) {
        return Banner.builder()
                .id(bannerDto.getId())
                .bannerName(bannerDto.getBannerName())
                .imagePath(bannerDto.getImagePath())
                .alterText(bannerDto.getAlterText())
                .linkUrl(bannerDto.getLinkUrl())
                .target(bannerDto.getTarget())
                .bannerOrder(bannerDto.getBannerOrder())
                .isDisplayed(bannerDto.isDisplayed())
//                .regDt(bannerDto.getRegDt())
                .build();
    }

    public static BannerDto fromEntity(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .imagePath(banner.getImagePath())
                .alterText(banner.getAlterText())
                .linkUrl(banner.getLinkUrl())
                .target(banner.getTarget())
                .bannerOrder(banner.getBannerOrder())
                .isDisplayed(banner.isDisplayed())
//                .regDt(banner.getRegDt())
                .build();
    }
}
