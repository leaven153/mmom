package com.leaven.mmom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


/**********
 * class: 추상클래스(생성일자, 업데이트일자)
 * field: 생성일자, 업데이트일자
 * mapping:
 **********/
@MappedSuperclass // 테이블로 생성되지 않는다.
@EntityListeners(value = {AuditingEntityListener.class}) // JPA내부에서 엔티티 객체가 생성/변경되는 것을 감지하는 역할(regDate, modDate에 적절한 값 지정) Application.java에도 어
@Getter
abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
