package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**********
 * class: 유료 서비스를 구독하는 회원의 정보
 * field: id, 서비스id, 회원id, 회원생년월일, 회원연락처, 서비스시작일, 비용납부일, 납부형태
 * mapping: subscribeModule - 서비스id(1명의 회원이 구독하는 서비스는 1개이다.)
 * !mapping: user (∵객체 payment info를 통해서는 user를 참조하지 않는다..?)
 * **********/
@Entity
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = "subscribeModule")
public class UserPaymentInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 유료 회원일 경우, 구독하는 유료 서비스 정보 가져온다.
    // 유료 서비스 구독은 선택적이기 때문에 default인 nullable = true 임!
    // OneToOne도 EAGER가 기본값이다.
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subscribe_module_id")
    private SubscribeModule subscribeModule;

    // User와 일대일 양방향 매핑
    // 양방향의 이유: 관리자의 입장에서 유료서비스 구독자 목록에서 유저의 정보를 보고 싶어할 수 있지 않을까?
    // 그런데, setUserPaymentInfo를 만들다 보니, User가 있고, UserPaymentInfo가 작성되기 때문에
    // setUserPaymentInfo를 만들 이유는 없겠다고 판단됨.
    // 굳이 유료 서비스 구독자 목록을 따로 만들 필요도, 거기서 user의 email, last Connected 등의 정보가 담긴 객체를 불러오는 것보다는
    // 분석용 목록을 화면 상에서 별도로 만드는 것이 낫겠다고 판단함.
//    @OneToOne(mappedBy = "userPaymentInfo", optional = false, fetch = FetchType.LAZY)
//    private User user;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private LocalDate userBirth;

    @Column(nullable = false)
    private String userTel;

    @Column(nullable = false)
    private LocalDateTime payAt;

    @Column(nullable = false)
    private String paymentType;

    @Column(nullable = false)
    private String accountNumber;

    public void setSubscribeModule(SubscribeModule subscribeModule) {
        this.subscribeModule = subscribeModule;
    }

    public void setUserBirth(LocalDate userBirth) {
        this.userBirth = userBirth;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public void setPayAt(LocalDateTime payAt) {
        this.payAt = payAt;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setPayAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Builder
    public UserPaymentInfo(Long userId, LocalDate userBirth, String userTel, LocalDateTime payAt, String paymentType){
        this.userId = userId;
        this.userBirth = userBirth;
        this.userTel = userTel;
        this.payAt = payAt;
        this.paymentType = paymentType;
    } // end of Constructor(not all. without SubscribeModule)

} // end of class UserPaymentInfo
