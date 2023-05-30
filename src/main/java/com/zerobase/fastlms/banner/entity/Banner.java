package com.zerobase.fastlms.banner.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Banner {

    @Id
    @GeneratedValue
    private Long id;
    private String bannerName; // 배너명
    private String imagePath; // 배너 이미지 파일의 URL
    private String alterText; // 배너 이미지의 Alter 텍스트(대체 텍스트),
    private String linkUrl; // 배너 클릭 시 이동하는 URL 정보
    private String target; // 클릭 시 이동하는 창의 타겟 정보 (새 창인지, 현재 창 이동인지)
    private String bannerOrder; // 배너의 정렬 순서
    private boolean isDisplayed; // 프론트에 표시 여부 정보

    @CreatedDate
    private LocalDateTime regDt;

}
