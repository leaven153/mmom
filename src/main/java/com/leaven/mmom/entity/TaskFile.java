package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**********
 * class:
 * field:
 * mapping:
 * !mapping: project,
 **********/
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"task"})
public class TaskFile extends BaseEntity{
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
    private String fileOriginName;

    @Column(nullable = false)
    private UUID fileNewName;

    @Column(nullable = false)
    private String filePath;


    @Builder
    public TaskFile(Long pId, MmomTask task, Long uId, String fOriginName, UUID fNewName, String fPath){
        this.projectId = pId;
        this.task= task;
        this.userId = uId;
        this.fileOriginName = fOriginName;
        this.fileNewName = fNewName;
        this.filePath = fPath;
    } // end of constructor
} // end of class TaskFile
