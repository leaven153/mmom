package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


/**********
 * class: 회원가입시 입력하는 정보(초대받은 비회원의 email도 담김)
 * field: id, 비밀번호, 이름, 회원이메일, (유료서비스구독회원일 경우)납부관련정보,
 *        createdAt,
 *        (BaseEntity 쓰지 않는다. ∵ updatedAt을 쓰지 않고 그냥) lastConnected,
 *        mypage_sortType: 프로젝트 모아보기에서 사용자가 기본으로 선택한 정렬(최종수정일순, 생성일순, 마감일순),
 *        user payment info(연간관계 매핑)
 * 유효성검사: 비밀번호 - 8글자 이상, 영어한글숫자 혼용
 *           이름 - 중복허용, 2글자 이상, n글자 이하, 숫자·특수기호 불가
 * 비회원의 경우(NN): 비밀번호-임시생성된비번(uuid), 이름-초대메일을 받은 메일주소의 앞자리, 이메일-초대한 사람이 입력한 email
 * mapping: userPaymentInfo(OneToOne. 1명의 회원은 0개 혹은 1개의 payment info를 가지고 있다.)
 * !mapping:
 **********/
@Entity
@Table(name="mmom_user")
@EntityListeners(value = {AuditingEntityListener.class})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = "userPaymentInfo")
public class MmomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime lastConnected; // 로그인할 때마다 now를 넣어줘야되겠네?!

    @Column
    @ColumnDefault("'updatedAt'")  // Mypage - 프로젝트 모아보기 정렬방식(최종수정일순, 생성일순, 마감일순)
    private String mypageSortType;

    // user가 탈퇴하면 비용정산이 없을 경우, user의 지불관련 정보도 함께 (바로) 삭제한다.
    // (유저가 탈퇴하면 유저 정보는 미련없이-data분석없이- 날리..자?)
    @OneToOne(fetch = FetchType.LAZY)
    private UserPaymentInfo userPaymentInfo;

    public void setLastConnected(LocalDateTime lastConnected) {
        this.lastConnected = lastConnected;
    }

    public void setMypageSortType(String mypageSortType) { this.mypageSortType = mypageSortType; }

    public void setUserPaymentInfo(UserPaymentInfo userPaymentInfo) {
        this.userPaymentInfo = userPaymentInfo;
    }

    @Builder
    public MmomUser(String password, String userName, String userEmail){
        this.password = password;
        this.userName = userName;
        this.userEmail = userEmail;
    } // end of Constructor

} // end of class User
