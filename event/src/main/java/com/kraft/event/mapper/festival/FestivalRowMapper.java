package com.kraft.event.mapper.festival;

import com.kraft.event.entity.Festival;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class FestivalRowMapper implements RowMapper<Festival> {

    @Override
    public Festival mapRow(ResultSet rs, int rowNum) throws SQLException {
        Festival festival = Festival.builder()
                .name(rs.getString("name"))
                .location(rs.getString("location"))
                .photo(rs.getString("photo"))
                .warningMessage(rs.getString("warning_message"))
                .showTime(rs.getObject("show_time", LocalDateTime.class))
                .shortName(rs.getString("short_name"))
                .isHidden(rs.getBoolean("is_hidden"))
                .startDate(rs.getObject("start_date", LocalDateTime.class))
                .endDate(rs.getObject("end_date", LocalDateTime.class))
                .termAndConditionId(rs.getLong("term_and_condition_id"))
                .build();

        festival.setId(rs.getLong("id"));
        festival.setCreatedDate(rs.getObject("created_date", LocalDateTime.class));
        festival.setUpdatedDate(rs.getObject("updated_date", LocalDateTime.class));
        festival.setCreatedUserId(rs.getLong("created_user_id"));
        festival.setUpdatedUserId(rs.getLong("updated_user_id"));
        festival.setDeleted(rs.getBoolean("is_deleted"));

        return festival;
    }
}
