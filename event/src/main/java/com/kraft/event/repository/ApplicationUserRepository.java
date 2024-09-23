package com.kraft.event.repository;

import com.kraft.event.entity.ApplicationUser;
import com.kraft.event.mapper.application.user.ApplicationRowMapper;
import com.kraft.event.service.audit.AuditorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ApplicationUserRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final AuditorService auditorService;

    @Value("${search.by.email}")
    private String searchByEmail;

    public ApplicationUser findByEmail(String email){
        var parameters = new MapSqlParameterSource("email",email);
        return namedParameterJdbcTemplate.queryForObject(searchByEmail,parameters,new ApplicationRowMapper());
    }
}
