package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

/**********
 * class: task에 작성자, 담당자가 업로드한 file (삭제는 당사자와 관라자만이 가능하다)
 * field:
 * mapping: task
 * !mapping: project, user
 **********/
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"task"})
public class TaskFile{
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
    private String fileType;

    @Column(nullable = false)
    private String filePath;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @Builder
    public TaskFile(Long pId, MmomTask task, Long uId, String fOriginName, UUID fNewName, String fileType, String fPath){
        this.projectId = pId;
        this.task= task;
        this.userId = uId;
        this.fileOriginName = fOriginName;
        this.fileNewName = fNewName;
        this.fileType = fileType;
        this.filePath = fPath;
    } // end of constructor
} // end of class TaskFile
