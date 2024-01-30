package com.leaven.mmom.entity;


import jakarta.persistence.*;
import lombok.*;

/**********
 * class:
 * field:
 * mapping:
 * !mapping: project,
 **********/
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"task", "user"})
public class TaskFile extends BaseEntity{
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

    private String fileOriginName;
    private String fileNewName;
    private String filePath;

    @Builder
    public TaskFile(Long pId, MmomTask mmomTask, MmomUser mmomUser, String fOriginName, String fileNewName, String fPath){
        this.projectId = pId;
        this.mmomTask = mmomTask;
        this.mmomUser = mmomUser;
        this.fileOriginName = fOriginName;
        this.fileNewName = fileNewName;
        this.filePath = fPath;

        // 인자로 받은 게 없어도
        // 생성자 내에서 그냥 uuid로 newName을 만드는 게 맞나?
        // 아니면 생성자에 입력값을 uuid로 만들게 하는 게 낫나?

    } // end of constructor
} // end of class TaskFile
