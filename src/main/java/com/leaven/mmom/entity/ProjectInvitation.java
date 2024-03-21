package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**********
 * class: 회원/비회원 프로젝트 초대 시 사용. checkedAt
 * field: id,
 *        초대받을 분의 이메일주소,
 *        초대한프로젝트id,
 *        초대한시각 (id를 제외한 3개의 컬럼은 url에 parameter로 포함된다.)
 *        부여된 position - partner/admin/member
 *        acceptance (회원의 경우) 수락여부 - Y/N
 *        checkedAt (회원의 경우) 수락여부 결정한 시각
 * mapping: project(OneToOne)
 * !mapping:
 **********/
@Entity
@Table(name = "project_guest")
@EntityListeners(value = {AuditingEntityListener.class})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = "project")
public class ProjectInvitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String guestEmail;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="project_id", nullable = false)
    private MmomProject project;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime invitedAt;

    @Builder
    public ProjectInvitation(String gEmail, MmomProject project){
        this.guestEmail = gEmail;
        this.project = project;
    } // end of constructor
} // end of class Guest
