package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**********
 * class: task의 변경사항(status, priority, dueDate, parentTask, budget
 *        assignee, file attachment, comment)을 저장하는 history 엔티티(테이블)
 *        EntityListener로 값이 저장된다.
 * field: id, projectId, taskId, 변경된항목, 변경유형(생성/등록Insert, Update, Delete), 변경내용, 변경일시, 변경한유저id
 * mapping: task
 * !mapping: project, user
 **********/
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = "task")
public class HistoryTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="task_id", nullable = false)
    private MmomTask task;

    @Column(nullable = false)
    private String modItem;

    @Column(nullable = false)
    private String modType;

    @Column(nullable = false)
    private String modContent;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(nullable = false)
    private Long updatedBy;

    @Builder
    public HistoryTask(MmomTask task, Long pId, String modItem, String modType, String modContent){
        this.task = task;
        this.projectId = pId;
        this.modItem = modItem;
        this.modType = modType;
        this.modContent = modContent;
    } // end of constructor
} // end of class HistoryTask
