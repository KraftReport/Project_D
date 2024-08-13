package com.kraft.event.repository;

import com.kraft.event.entity.Festival;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@RequiredArgsConstructor
public class FestivalRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final Environment environment;

    public boolean createFestival(Festival festival){
        var query = environment.getProperty("CREATE_NEW_FESTIVAL");
        System.err.println(query);

    }
}
