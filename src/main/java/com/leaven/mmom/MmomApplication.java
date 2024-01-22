package com.leaven.mmom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // AuditingEntityListener를 활성화 시키는 어노테이션
public class MmomApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmomApplication.class, args);
    }

}
