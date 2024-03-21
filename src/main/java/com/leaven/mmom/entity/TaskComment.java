package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

/**********
 * class: 할 일에 프로젝트 멤버가 남기는 기록(댓글형태)
 * field: id, project_id, task_id, user_id
 *        type - 모두확인요청Required Reading, 일반normal(기본값)
 *        content - 기록내용
 * mapping: task
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
    @JoinColumn(name = "task_id", nullable = false)
    private MmomTask task;

    @Column(nullable = false)
    private Long userId;

    @Column
    @ColumnDefault("'normal'")
    private String type;

    @Column(nullable = false)
    private String comment;

    // 변경 가능한 컬럼: 유형type, 기록내용comment
    public void setType(String type){
        this.type = type;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Builder
    public TaskComment(Long pId, MmomTask task, Long uId, String type, String comment){
        this.projectId = pId;
        this.task = task;
        this.userId = uId;
        this.type = type;
        this.comment = comment;
    } // end of constructor


} // end of class TaskComment
