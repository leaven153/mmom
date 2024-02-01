package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

/**********
 * class: 각각의 유저가 속한 프로젝트(프로젝트별 개인설정)
 * field: id, 프로젝트id, 사용자id, 사용자가설정한프로젝트컬럼layout, 프로젝트내사용자레벨(creator, admin, member, guest)
 *        프로젝트내사용자권한("R/RC(read and write comment)/W(task, comment)/D"),
 *        사용자가 해당프로젝트에 사용하는 프로필이미지(origin name, new name(UUID), path),
 *        사용자가 해당프로젝트에서 사용하는 이름, 사용자가 프로젝트에 등록된(게스트로 초대된) 날짜
 * mapping: project, user, project_layout
 * !mapping:
 **********/

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name="user_belongTo_project")
public class UserBelongToProject {
    @Id
    private Long id;

    @ManyToOne
    private MmomProject mmomProject;

    @ManyToOne
    private MmomUser mmomUser;

    @Column(nullable = false)
    private String displayName;

    @Column(nullable = false)
    private String userPosition;

    // invited의 경우 null? (url로 접근 시 capable 확인?)
    private String userCapable;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime userRegDate;

    private String userProfileImeOrgName;
    private UUID userProfileImeNewName;
    private String userProfileImePath;

    @Column(nullable = false)
    private boolean layoutIsDefault;

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setUserProfileImeOrgName(String userProfileImeOrgName) {
        this.userProfileImeOrgName = userProfileImeOrgName;
    }

    public void setUserProfileImeNewName(UUID userProfileImeNewName) {
        this.userProfileImeNewName = userProfileImeNewName;
    }

    public void setUserProfileImePath(String userProfileImePath) {
        this.userProfileImePath = userProfileImePath;
    }

    public void setLayoutIsDefault(boolean layoutIsDefault) {
        this.layoutIsDefault = layoutIsDefault;
    }

    @Builder
    public UserBelongToProject(MmomProject mmomProject, MmomUser mmomUser, String userPosition, String userCapable, Boolean layoutIsDefault){
        this.mmomProject = mmomProject;
        this.mmomUser = mmomUser;
        this.userPosition = userPosition;
        this.userCapable = userCapable;
        this.layoutIsDefault = layoutIsDefault;
    }
}
