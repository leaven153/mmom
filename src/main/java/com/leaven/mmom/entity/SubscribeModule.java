package com.leaven.mmom.entity;

import jakarta.persistence.*;
import lombok.*;


/**********
 * class: 유료 서비스(모듈) 목록
 * field: id, 서비스(모듈)명, 서비스(모듈)가격, 서비스(모듈)옵션1,2,3
 * mapping:
 **********/
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Builder
    public SubscribeModule(String moduleName, Long modulePrice){
        this.moduleName = moduleName;
        this.modulePrice = modulePrice;
    }
}
