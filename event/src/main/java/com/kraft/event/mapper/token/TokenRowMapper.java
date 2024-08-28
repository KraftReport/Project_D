package com.kraft.event.mapper.token;
import com.kraft.event.entity.Token;
import com.kraft.event.entity.enums.TOKEN_TYPE;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TokenRowMapper implements RowMapper<Token> {
    @Override
    public Token mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Token.builder()
                .id(rs.getLong("id"))
                .token(rs.getString("token"))
                .isExpired(rs.getBoolean("is_expired"))
                .isRevoked(rs.getBoolean("is_revoked"))
                .tokenType(TOKEN_TYPE.valueOf(rs.getString("token_type")))
                .build();
    }
}
