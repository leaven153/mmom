package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

/**********
 * class: 각각의 유저가 속한 프로젝트(프로젝트별 개인설정)
 * field: id, 프로젝트id, 사용자id, 사용자가 해당프로젝트에서 사용하는 이름,
 *        프로젝트내사용자지위(creator, partner, admin, member, guest(solo-shared), invited),
 *        프로젝트내사용자권한("R/RC(read and write comment)/W(task, comment)/D/PD/null(invited)"),
 *        사용자가 해당프로젝트에 사용하는 프로필이미지(origin name, new name(UUID), path),
 *        사용자가 프로젝트에 등록된(게스트로 초대된) 날짜
 * mapping: project, user, project_layout
 * !mapping:
 **********/

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name="user_belongTo_project")
@ToString(exclude = {"project", "user"})
public class UserBelongToProject {
    @Id
    private Long id;

    @ManyToOne
    @Column(name = "project_id")
    private MmomProject project;

    @ManyToOne
    @Column(name = "user_id")
    private MmomUser user;

    @Column(nullable = false)
    private String displayName;

    @Column(nullable = false)
    private String userPosition;

    // invited의 경우 null
    private String userCapable;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime userRegDate;

    private String userProfileImgOrgName;
    private UUID userProfileImgNewName;
    private String userProfileImgPath;

    @Column(nullable = false)
    @ColumnDefault("list")
    private String projectView;


    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public void setUserCapable(String userCapable) {
        this.userCapable = userCapable;
    }

    public void setUserProfileImeOrgName(String userProfileImgOrgName) {
        this.userProfileImgOrgName = userProfileImgOrgName;
    }

    public void setUserProfileImeNewName(UUID userProfileImgNewName) {
        this.userProfileImgNewName = userProfileImgNewName;
    }

    public void setUserProfileImePath(String userProfileImgPath) {
        this.userProfileImgPath = userProfileImgPath;
    }

    public void setLayoutIsDefault(String projectView) {
        this.projectView = projectView;
    }

    @Builder
    public UserBelongToProject(MmomProject project, MmomUser user, String userPosition, String userCapable, String projectView){
        this.project = project;
        this.user = user;
        this.userPosition = userPosition;
        this.userCapable = userCapable;
        this.projectView = projectView;
    }
}
