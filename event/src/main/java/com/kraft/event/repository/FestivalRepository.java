package com.kraft.event.repository;

import com.kraft.event.entity.Festival;
import com.kraft.event.service.audit.AuditorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class FestivalRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final Environment environment;
    private final AuditorService auditorService;

    @Value("${create.festival}")
    private String createQuery ;

    public boolean createFestival(Festival festival){
        System.err.println(festival.getName() + "----------------------");
        var festivalEntity = auditorService.entityCreation(festival);
        System.err.println(festivalEntity.getName() + "++++++++++++++++++++++++");
        var namedParameters = new BeanPropertySqlParameterSource(festivalEntity);
        return namedParameterJdbcTemplate.update(createQuery,namedParameters) > 0;
    }
}
