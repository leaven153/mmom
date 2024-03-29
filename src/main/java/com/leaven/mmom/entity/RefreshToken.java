package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**********
 * class: JWT사용할 경우, 필요한 refreshToken 테이블.......................
 * field: id, refresh토큰발급받을(은)사용자id, refresh토큰값
 * mapping:
 **********/
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RefreshToken extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String refreshToken;

    @Builder
    public RefreshToken(Long userId, String refreshToken){
        this.userId = userId;
        this.refreshToken = refreshToken;
    } // end of constructor

} // end of class RefreshToken
