package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="mmom_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
    private String userName;
    private String userEmail;

    // user가 탈퇴하면 user의 지불관련 정보도 함께 삭제한다.
    // (유저가 탈퇴하면 유저 정보는 미련없이-data분석없이- 날리자.)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Column(nullable = true)
    private UserPaymentInfo userPaymentInfo;

    @Column(nullable = true)
    private Long projectInvitation;

//    public void setUserPaymentInfo(UserPaymentInfo userPaymentInfo) {
//        this.userPaymentInfo = userPaymentInfo;
//        userPaymentInfo.getUser();
//    }
}
