package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**********
 * class:
 * field:
 * mapping:
 * !mapping: project가 사라질 때 task가 사라지면서 task가 사라질 때 댓글도 사라지게 하자. 프로젝트 굳이 매핑하지말공!
 **********/

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class TaskComment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String fileOriginName;
    private String fileNewName;
    private String filePath;

    @Builder
    public TaskComment(Long pId, User user, String fOriginName, String fNewName, String fPath){
        this.projectId = pId;
        this.user = user;
        this.fileOriginName = fOriginName;
        this.fileNewName = fNewName;
        this.filePath = fPath;
    } // end of constructor

} // end of class TaskComment
