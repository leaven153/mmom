package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**********
 * class: 담당자가 배정된 task의 목록
 * field: id, 프로젝트id, task id,
 *        관계자 id,
 *        role(관계자 유형) - 작성자/담당자/(관계자였다가)프로젝트 탈퇴한 사람 (+옵저버/수퍼바이저(검토자))
 *        createdAt - 해당task에 유저가 연관된 날
 *        (프로젝트에서 탈퇴/제외된 사람의 경우, history_task를 통해 해당 일시를 확인한다.
 *         task_assignment에 배정되었다가 제외된 경우는 task_assignment에서 삭제한다. ∴ updatedAt 컬럼은 두지 않는다.)
 * mapping: task
 * !mapping: project, user (task가 삭제될 때 반드시 삭제되도록 한다. task에 project를 매핑하여 프로젝트가 삭제될 때 task가 반드시 삭제되도록 한다.)
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

    public void setTaskUserRole(String taskUserRole) {
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
