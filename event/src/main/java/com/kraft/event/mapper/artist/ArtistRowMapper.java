package com.kraft.event.mapper.artist;

import com.kraft.event.entity.Artist;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ArtistRowMapper implements RowMapper<Artist> {
    @Override
    public Artist mapRow(ResultSet rs, int rowNum) throws SQLException {
        var artist = Artist.builder()
                .name(rs.getString("name"))
                .photo(rs.getString("photo")).build();

        artist.setId(rs.getLong("id"));
        artist.setDeleted(rs.getBoolean("is_deleted"));
        artist.setCreatedDate(rs.getObject("created_date", LocalDateTime.class));
        artist.setUpdatedDate(rs.getObject("updated_date", LocalDateTime.class));
        artist.setCreatedUserId(rs.getLong("created_user_id"));
        artist.setCreatedUserId(rs.getLong("created_user_id"));
        return null;
    }
}
