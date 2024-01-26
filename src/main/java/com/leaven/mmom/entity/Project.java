package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


/**********
 * class: 생성된 프로젝트에 대한 정보
 * field: id, 생성자id, 프로젝트타입(solo-private, solo-shared, team), 생성일자,
 *        최종수정일, 프로젝트마감일, 프로젝트상태(ing/finished/discard/archived(유료)),
 *        프로젝트url(uuid)
 * mapping:
 * !mapping:
 **********/
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name="mmom_project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long creator;
    private String projectType;
    private String projectName;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(nullable = true)
    private LocalDateTime projectDueDate;

    @Column(nullable = true)
    @ColumnDefault("ing")
    private String projectStatus;

    private String projectURL;

    @Builder
    public Project(Long creator, String projectType, String projectName){
        this.creator = creator;
        this.projectType = projectType;
        this.projectName = projectName;
    }
}
