package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**********
 * class:
 * field:
 * mapping:
 **********/
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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


}
