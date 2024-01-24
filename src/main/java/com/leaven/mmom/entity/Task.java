package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**********
 * class: 프로젝트에 속한 멤버가 생성한 task
 * field: id, 속한프로젝트id(fk, NN), task생성자(NN), task명(NN),
 *        task우선순위(높음, 보통, 낮음), task시작일, task마감일,
 *        상위taskid, 선행taskid, 후행taskid, task에 할당된 예산
 * mapping:
 * !mapping: project에 대한 정보를 task에서 소환할 일이 없다..?
 **********/
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "mmom_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")
    private Project project;

    private Long taskCreatedBy;
    private String taskName;

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
    private Long taskBudget;
}
