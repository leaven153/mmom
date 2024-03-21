package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**********
 * class: 프로젝트에 속한 멤버가 생성한 task
 * field:
 * id, 속한프로젝트id(fk, NN)
 * author - task생성자(NN)
 * title - task명(NN)
 * priority - task유형(공지, 매우중요, 중요, normal)
 * dueDate - task마감일
 * parent_id - 상위taskid
 * budget - task에 할당된 예산
 * createdAt, updatedAt, updatedBy
 * mapping: project
 * !mapping:
 **********/
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
@Table(name = "mmom_task")
@ToString(exclude = "project")
public class MmomTask extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id", nullable = false)
    private MmomProject project;


    @Column(nullable = false)
    private String taskTitle;

    @Column(nullable = false)
    private String taskAuthor;

    @Column(nullable = false)
    @ColumnDefault("'normal'")
    private String taskPriority;

    @Column(nullable = false)
    @ColumnDefault("'not yet'")
    private String taskStatus;

    @Column
    private LocalDateTime taskDueDate;

    @Column(updatable = false)
    private Long taskParentId;

    @Column
    private BigDecimal taskBudget;

    @Column
    private Long updatedBy;

    // 수정 가능한 필드(5): title, priority, status, dueDate, budget
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;}

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskDueDate(LocalDateTime taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public void setTaskBudget(BigDecimal taskBudget) {
        this.taskBudget = taskBudget;
    }

    @Builder
    public MmomTask(MmomProject project, String taskTitle, String taskAuthor, String taskPriority, String taskStatus, LocalDateTime taskDueDate, Long taskParentId, BigDecimal taskBudget, Long updatedBy) {
        this.project = project;
        this.taskTitle = taskTitle;
        this.taskAuthor = taskAuthor;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatus;
        this.taskDueDate = taskDueDate;
        this.taskParentId = taskParentId;
        this.taskBudget = taskBudget;
        this.updatedBy = updatedBy;
    }
} // end of class MmomTask
