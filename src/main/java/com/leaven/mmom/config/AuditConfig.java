package com.leaven.mmom.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

// https://compunication.tistory.com/28
@Configuration
public class AuditConfig implements AuditorAware<Integer> {


    @Override
    public Optional<Integer> getCurrentAuditor() {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Integer userId = Integer.parseInt(req.getHeader("userId"));
        return Optional.of(userId);
    }
}
