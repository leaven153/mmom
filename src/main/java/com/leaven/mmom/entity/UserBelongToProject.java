package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**********
 * class: 각각의 유저가 속한 프로젝트(프로젝트별 개인설정 - )
 * field:
 * id
 * 프로젝트id: 사용자가 속한 프로젝트 id
 * 사용자id: 프로젝트에 속한 사용자 id(=멤버)
 * displayName: 멤버가 해당 프로젝트에서 사용하는 이름
 * position: 프로젝트 내 해당 멤버의 지위(creator(PD), partner(PD), admin(D), member(W), guest(solo-shared)(R/RC))
 * capacity: 프로젝트 내 해당 멤버의 권한("R/RC(read and write comment)/W(task, comment)/D/PD")
 * regDate: 멤버가 프로젝트에 초대에 응한 날짜
 * connectedAt: 멤버가 프로젝트에 접속한 일시(해당 프로젝트를 클릭한 순간)
 * taskListView: 멤버가 기본값으로 설정한 task목록 view(list(table), status, assignee)
 * mapping: project, user, project_layout
 * !mapping:
 **********/

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(value = {AuditingEntityListener.class})
@ToString(exclude = {"project", "user"})
public class UserBelongToProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private MmomProject project;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private MmomUser user;

    @Column(nullable = false)
    private String displayName;

    @Column(nullable = false)
    private String userPosition;

    // invited의 경우 null
    private String userCapacity;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime userRegDate;

    @Column
    private LocalDateTime connectedAt;

    @Column(nullable = false)
    @ColumnDefault("'list'")
    private String projectView;


    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public void setUserCapacity(String userCapacity) {
        this.userCapacity = userCapacity;
    }

    public void setProjectView(String projectView) {
        this.projectView = projectView;
    }

    @Builder
    public UserBelongToProject(MmomProject project, MmomUser user, String userPosition, String userCapacity, LocalDateTime userRegDate, LocalDateTime connectedAt, String projectView){
        this.project = project;
        this.user = user;
        this.userPosition = userPosition;
        this.userCapacity = userCapacity;
        this.userRegDate = userRegDate;
        this.connectedAt = connectedAt;
        this.projectView = projectView;
    }
}
