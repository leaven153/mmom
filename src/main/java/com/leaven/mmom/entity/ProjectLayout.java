package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;


/**********
 * class:
 * field:
 * mapping:
 * !mapping:
 **********/
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ProjectLayout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String columnName;
    private boolean columnShow;
    private String columnType;
    private Integer columnLocation;

    @Column(nullable = true)
    private Integer columnWidth;

    @Builder
    public ProjectLayout(String columnName, Boolean columnShow, String columnType, Integer columnLocation){
        this.columnName = columnName;
        this.columnShow = columnShow;
        this.columnType = columnType;
        this.columnLocation = columnLocation;
    } // end of constructor(without nullable)
} // end of class ProjectLayout
