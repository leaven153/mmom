package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.*;

/**********
 * class:
 * field:
 * mapping: task, user
 * !mapping: project
 **********/

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"task"})
public class TaskComment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private MmomTask task;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String comment;

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Builder
    public TaskComment(Long pId, MmomTask task, Long uId, String comment){
        this.projectId = pId;
        this.task = task;
        this.userId = uId;
        this.comment = comment;
    } // end of constructor


} // end of class TaskComment
