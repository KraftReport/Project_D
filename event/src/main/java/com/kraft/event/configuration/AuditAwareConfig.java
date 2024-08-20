package com.kraft.event.configuration;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditAwareConfig implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.of(1L);
    }
}
