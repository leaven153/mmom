package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**********
 * class:
 * field:
 * mapping:
 * !mapping:
 **********/
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(value = {AuditingEntityListener.class})
public class TaskAssignment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long projectId;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @LastModifiedDate
//    private LocalDateTime updatedAt;

    @Builder
    public TaskAssignment(Long projectId, Task task, User user){
        this.projectId = projectId;
        this.task = task;
        this.user = user;
    }// end of constructor()
} // end of class TaskAssignment
