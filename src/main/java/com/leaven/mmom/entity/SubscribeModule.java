package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SubscribeModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String moduleName;
    private Long modulePrice;

    @Column(nullable = true)
    private String moduleOpt1;

    @Column(nullable = true)
    private String moduleOpt2;

    @Column(nullable = true)
    private String moduleOpt3;
}
