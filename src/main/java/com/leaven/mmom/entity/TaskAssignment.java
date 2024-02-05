package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**********
 * class: 담당자가 배정된 task의 목록
 * field: id, 프로젝트id, task id, 관계자(담당자/옵저버/수퍼바이저/관리자)id,
 *        관계자 유형(담당자/옵저버/수퍼바이저/관리자), 해당task에 유저가 연관된 날
 * mapping: project, task, user
 * !mapping:
 **********/
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"task"})
public class TaskAssignment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private MmomTask task;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String taskUserRole;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime CreatedAt;

    public void setTaskUserType(String taskUserRole) {
        this.taskUserRole = taskUserRole;
    }

    @Builder
    public TaskAssignment(Long pId, MmomTask task, Long uId, String taskUserRole){
        this.projectId = pId;
        this.task = task;
        this.userId = uId;
        this.taskUserRole = taskUserRole;
    }// end of constructor()
} // end of class TaskAssignment
