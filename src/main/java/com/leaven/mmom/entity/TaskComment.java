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
@ToString(exclude = {"task", "user"})
public class TaskComment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private MmomTask mmomTask;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private MmomUser mmomUser;

    private String comment;

    @Builder
    public TaskComment(Long pId, MmomTask mmomTask, MmomUser mmomUser, String comment){
        this.projectId = pId;
        this.mmomTask = mmomTask;
        this.mmomUser = mmomUser;
        this.comment = comment;
    } // end of constructor


} // end of class TaskComment
