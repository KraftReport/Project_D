package com.kraft.event.repository;

import com.kraft.event.entity.Festival;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@RequiredArgsConstructor
@Repository
public class FestivalRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final Environment environment;

    public boolean createFestival(Festival festival){
        var query = "insert into festival(name,short_name,start_date,end_date,photo,location,show_time,term_and_condition_id,created_date,created_user_id,is_deleted,updated_date,updated_user_id,is_hidden,warning_message) values(:name,:shortName,:startDate,:endDate,:photo,:location,:showTime,:termAndConditionId,:createdDate,:createdUserId,:isDeleted,:updatedDate,:updatedUserId,:isHidden,:warningMessage)";
        System.err.println(query);
        var map = new HashMap<String ,Object>();
        var namedParameters = new BeanPropertySqlParameterSource(festival);
        namedParameterJdbcTemplate.update(query,namedParameters);
        return true;
    }
}
