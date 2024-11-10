package com.kraft.event.repository;

import com.kraft.event.entity.Artist;
import com.kraft.event.mapper.artist.ArtistRowMapper;
import com.kraft.event.service.audit.AuditorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArtistRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final AuditorService auditorService;

    @Value("${create.artist}")
    private String  createQuery;
    @Value("${search.by.id}")
    private String  searchByIdQuery;

    public Long addArtistToDatabase(Artist artist) {
        var artistEntity = auditorService.entityCreation(artist);
        var namedParameters = new BeanPropertySqlParameterSource(artistEntity);
        return namedParameterJdbcTemplate.update(createQuery,namedParameters) > 0 ? artistEntity.getId() : null;
    }

    public Artist searchArtistById(Long id) {
        var parameters = new MapSqlParameterSource("id",id);
        return namedParameterJdbcTemplate.queryForObject(searchByIdQuery,parameters,new ArtistRowMapper());
    }
}
