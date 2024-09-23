package com.kraft.event.repository;

import com.kraft.event.entity.Token;
import com.kraft.event.mapper.token.TokenRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TokenRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${create.token}")
    private String createQuery;
    @Value("${search.by.application.user.id}")
    private String searchByApplicationUserId;
    @Value("${search.by.token}")
    private String searchByToken;
    @Value("${update.by.token}")
    private String updateToken;

    public boolean createAToken(Token token){
        var namedParameters = new BeanPropertySqlParameterSource(token);
        return namedParameterJdbcTemplate.update(createQuery, namedParameters) > 0;
    }

    public Token findByToken(String token){
        var parameters = new MapSqlParameterSource("token",token);
        return namedParameterJdbcTemplate.queryForObject(searchByToken,parameters,new TokenRowMapper());
    }

    public Token findByApplicationUserId(Long id){
        var parameters = new MapSqlParameterSource("application_user_id",id);
        return namedParameterJdbcTemplate.queryForObject(searchByApplicationUserId,parameters,new TokenRowMapper());
    }

    public void saveToken(Token token){
        var namedParameters = new BeanPropertySqlParameterSource(token);
        namedParameterJdbcTemplate.update(updateToken, namedParameters);
    }
}
