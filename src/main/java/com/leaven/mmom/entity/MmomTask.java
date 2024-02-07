package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**********
 * class: 프로젝트에 속한 멤버가 생성한 task
 * field: id, 속한프로젝트id(fk, NN), task생성자(NN), task명(NN),
 *        task유형(공지, 매우중요, 중요, normal), task시작일, task마감일,
 *        상위taskid, 선행taskid, 후행taskid, task에 할당된 예산
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
    private String taskName;

    private String taskType;
    private String taskStatus;
    private LocalDate taskStartDate;
    private LocalDateTime taskDueDate;
    private Long taskParentId;
    private Long taskPrevId;
    private Long taskNextId;
    private BigDecimal taskBudget;
    private Long updatedBy;

    // 수정 가능한 필드(8): name, priority, status, startDate, dueDate, parent, prev, next, budget
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskStartDate(LocalDate taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public void setTaskDueDate(LocalDateTime taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public void setTaskParentId(Long taskParentId) {
        this.taskParentId = taskParentId;
    }

    public void setTaskPrevId(Long taskPrevId) {
        this.taskPrevId = taskPrevId;
    }

    public void setTaskNextId(Long taskNextId) {
        this.taskNextId = taskNextId;
    }

    public void setTaskBudget(BigDecimal taskBudget) {
        this.taskBudget = taskBudget;
    }


    @Builder
    public MmomTask(MmomProject project, Long updatedBy, String taskName, String taskType, String taskStatus, LocalDate taskStartDate, LocalDateTime taskDueDate, Long taskParentId, Long taskPrevId, Long taskNextId, BigDecimal taskBudget) {
        this.project = project;
        this.updatedBy = updatedBy;
        this.taskName = taskName;
        this.taskType = taskType;
        this.taskStatus = taskStatus;
        this.taskStartDate = taskStartDate;
        this.taskDueDate = taskDueDate;
        this.taskParentId = taskParentId;
        this.taskPrevId = taskPrevId;
        this.taskNextId = taskNextId;
        this.taskBudget = taskBudget;
    }
} // end of class MmomTask
