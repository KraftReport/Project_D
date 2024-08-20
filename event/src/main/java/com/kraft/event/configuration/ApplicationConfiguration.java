package com.kraft.event.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.AuditorAware;

@Configuration
@PropertySource("classpath:query.properties")
public class ApplicationConfiguration {

    @Bean
    @Primary
    public AuditorAware<Long> auditorAware(){
        return new AuditAwareConfig();
    }
}
