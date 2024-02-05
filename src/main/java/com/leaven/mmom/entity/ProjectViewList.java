package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectViewList{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ubp_id", nullable = false)
    private UserBelongToProject ubp;

    @Column(nullable = false)
    private boolean columnShow;

    @Column(nullable = false)
    private Integer columnLocation;

    @Column(nullable = false)
    private String columnName;

    @Column(nullable = false)
    private String columnType;

    private Integer columnWidth;


    public void setColumnShow(boolean columnShow) {
        this.columnShow = columnShow;
    }

    public void setColumnLocation(Integer columnLocation) {
        this.columnLocation = columnLocation;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public void setColumnWidth(Integer columnWidth) {
        this.columnWidth = columnWidth;
    }

    @Builder
    public ProjectViewList(UserBelongToProject ubp, String columnName, boolean columnShow, String columnType, Integer columnLocation, Integer columnWidth) {
        this.ubp = ubp;
        this.columnName = columnName;
        this.columnShow = columnShow;
        this.columnType = columnType;
        this.columnLocation = columnLocation;
        this.columnWidth = columnWidth;
    } // end of constructor

} // end of class ProjectListViewColumn
