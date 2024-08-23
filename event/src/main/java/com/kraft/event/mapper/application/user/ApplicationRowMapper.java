package com.kraft.event.mapper.application.user;

import com.kraft.event.entity.ApplicationUser;
import com.kraft.event.entity.enums.ROLE;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ApplicationRowMapper implements RowMapper<ApplicationUser> {

    @Override
    public ApplicationUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        var applicationUser = ApplicationUser.builder()
                .firstName(rs.getNString("first_name"))
                .lastName(rs.getNString("last_name"))
                .email(rs.getNString("email"))
                .password(rs.getNString("password"))
                .role(ROLE.valueOf(rs.getNString("role")))
                .build();
        applicationUser.setId(rs.getLong("id"));
        applicationUser.setCreatedDate(rs.getObject("created_date", LocalDateTime.class));
        applicationUser.setUpdatedDate(rs.getObject("updated_date", LocalDateTime.class));
        applicationUser.setDeleted(rs.getBoolean("is_deleted"));
        applicationUser.setCreatedUserId(rs.getLong("created_user_id"));
        applicationUser.setUpdatedUserId(rs.getLong("updated_user_id"));
        return applicationUser;
    }
}
