package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**********
 * class: task의 변경사항(staus, priority, dueDate, parentTask, dependencies, budget
 *        assignee, file attachment, comment)을 감지하여 저장하는 history 엔티티(테이블)
 *        EntityListener로 값이 저장된다.
 * field: id, projectId, taskId, 변경된컬럼명, 변경유형(Insert, Update, Delete), 변경내용, 변경일시, 변경한유저id
 * mapping: task
 * !mapping: project, user
 **********/
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = "mmomTask")
public class HistoryTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long projectId;
    @ManyToOne(fetch = FetchType.LAZY)
    private MmomTask mmomTask;

    private String modColumn;
    private String modType;
    private String modContent;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private Long updatedBy;

    @Builder
    public HistoryTask(MmomTask mmomTask, Long pId, String modColum, String modType, String modContent){
        this.mmomTask = mmomTask;
        this.projectId = pId;
        this.modColumn = modColum;
        this.modType = modType;
        this.modContent = modContent;
    } // end of constructor
} // end of class HistoryTask