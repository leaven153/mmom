package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**********
 * class:
 * field:
 * mapping: project(OneToOne)
 * !mapping:
 **********/
@Entity
@Table(name = "project_guest")
@EntityListeners(value = {AuditingEntityListener.class})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = "project")
public class MmomGuest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guestEmail;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private MmomProject mmomProject;

    @CreatedDate
    private LocalDateTime invitedAt;

    @Builder
    public MmomGuest(String gEmail, MmomProject mmomProject){
        this.guestEmail = gEmail;
        this.mmomProject = mmomProject;
    } // end of constructor
} // end of class Guest
