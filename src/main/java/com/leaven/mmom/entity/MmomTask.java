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
    private String taskName;

    @LastModifiedBy
    private Long taskUpdatedBy;

    @Column(nullable=true)
    private String taskPriority;

    @Column(nullable=true)
    private String taskStatus;

    @Column(nullable=true)
    private LocalDate taskStartDate;

    @Column(nullable=true)
    private LocalDateTime taskDueDate;

    @Column(nullable=true)
    private Long taskParentId;

    @Column(nullable=true)
    private Long taskPrevId;

    @Column(nullable=true)
    private Long taskNextId;

    @Column(nullable=true)
    private BigDecimal taskBudget;

    @Builder
    public MmomTask(Long taskCreatedBy, String taskName){
        this.taskCreatedBy = taskCreatedBy;
        this.taskName = taskName;
    }
}
