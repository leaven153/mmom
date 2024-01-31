package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;


/**********
 * class: 생성된 프로젝트에 대한 정보
 * field: id, 생성자id, 프로젝트타입(solo-private, solo-shared, team), 프로젝트명, 생성일자,
 *        최종수정일, 프로젝트마감일, 프로젝트상태(created/working/finished/discard/archived(유료)),
 *        프로젝트url(uuid)
 * mapping:
 * !mapping:
 **********/
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name="mmom_project")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MmomProject extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long creator;

    private String projectType;
    private String projectName;

    @Column(nullable = true)
    private LocalDateTime projectDueDate;

    @Column(nullable = true)
    @ColumnDefault("created") // for ddl // @Column(columnDefinition = "varchar(255) default 'Created'") for
    private String projectStatus;

    @Column(unique = true)
    private UUID projectURL;

    // 수정이 가능한 필드:
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
    public MmomProject(Long creator, String type, String name, LocalDateTime dueDate, UUID url){
        this.creator = creator;
        this.projectType = type;
        this.projectName = name;
        this.projectDueDate = dueDate;
        this.projectURL = url;
    }


}
