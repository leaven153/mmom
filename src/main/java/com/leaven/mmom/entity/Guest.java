package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "project_guest")
@EntityListeners(value = {AuditingEntityListener.class})
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guestEmail;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Project project;

    @CreatedDate
    private LocalDateTime invitedAt;

    @Builder
    public Guest(String gEmail, Project project, LocalDateTime invitedAt){
        this.guestEmail = gEmail;
        this.project = project;
        this.invitedAt = invitedAt;
    } // end of constructor
} // end of class Guest
