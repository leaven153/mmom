package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


/**********
 * class: 생성된 프로젝트에 대한 정보
 * field: id, 생성자id, 프로젝트타입(solo-private, solo-shared, team), 프로젝트명,
 *        프로젝트url(uuid)
 *        프로젝트마감일,
 *        프로젝트상태(activated/finished/deactivated/discard/archived(유료)),
 *        프로젝트에 할당된 예산
 *        생성일자, 최종수정일
 * mapping:
 * !mapping:
 **********/
@Entity
@Table(name="mmom_project")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MmomProject extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long creator;

    @Column(nullable = false)
    private String projectType;

    @Column(nullable = false)
    private String projectName;

    @Column(unique = true, nullable = false)
    private UUID projectURL;

    @ColumnDefault("activated") // for ddl // @Column(columnDefinition = "varchar(255) default 'Created'") for
    private String projectStatus;

    private LocalDateTime projectDueDate;

    private BigDecimal projectBudget;

    // 수정이 가능한 필드(4): type, name, dueDate, status
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectDueDate(LocalDateTime projectDueDate) {
        this.projectDueDate = projectDueDate;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    @Builder
    public MmomProject(Long creator, String type, String name, UUID url, LocalDateTime dueDate, BigDecimal pBudget){
        this.creator = creator;
        this.projectType = type;
        this.projectName = name;
        this.projectURL = url;
        this.projectDueDate = dueDate;
        this.projectBudget = pBudget;
    }


}
