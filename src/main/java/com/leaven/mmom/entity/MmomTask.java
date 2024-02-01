package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**********
 * class: 프로젝트에 속한 멤버가 생성한 task
 * field: id, 속한프로젝트id(fk, NN), task생성자(NN), task명(NN),
 *        task우선순위(높음, 보통, 낮음), task시작일, task마감일,
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
    @JoinColumn(name="project_id")
    private MmomProject mmomProject;

    @CreatedBy
    private Long taskCreatedBy;
    @LastModifiedBy
    private Long taskUpdatedBy;

    @Column(nullable = false)
    private String taskName;

    private String taskPriority;
    private String taskStatus;
    private LocalDate taskStartDate;
    private LocalDateTime taskDueDate;
    private Long taskParentId;
    private Long taskPrevId;
    private Long taskNextId;
    private BigDecimal taskBudget;


    // 수정 가능한 필드(8): name, priority, status, startDate, dueDate, parent, prev, next, budget
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
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

    // 생성 시 필수 입력 요소
    @Builder
    public MmomTask(Long taskCreatedBy, String taskName){
        this.taskCreatedBy = taskCreatedBy;
        this.taskName = taskName;
    } // end of Constructor (required field)

} // end of class MmomTask
