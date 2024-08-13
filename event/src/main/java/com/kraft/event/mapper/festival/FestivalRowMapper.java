package com.kraft.event.mapper.festival;

import com.kraft.event.entity.Festival;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FestivalRowMapper implements RowMapper<Festival> {
    @Override
    public Festival mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Festival.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .location(rs.getString("location"))
                .photo(rs.getString("photo"))
                .warningMessage(rs.getString("warningMessage"))
                .
                .build();
    }
}
