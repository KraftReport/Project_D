package com.kraft.event.service.audit;
import com.kraft.event.configuration.AuditAwareConfig;
import com.kraft.event.entity.BaseEntity;
import com.kraft.event.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class AuditorService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AuditAwareConfig auditAwareConfig;
    private static final Random random = new Random();

    public <T extends BaseEntity> BaseEntity entityCreation(T t){
        t.setCreatedDate(LocalDateTime.now());
        t.setUpdatedDate(null);
        t.setCreatedUserId(auditAwareConfig.getCurrentAuditor().orElseThrow(()->new UserNotFoundException("not found")));
        t.setUpdatedUserId(null);
        t.setDeleted(false);
        t.setId(random.nextLong());
        return t;
    }
}
