package ru.deusops.simplebackend.dao;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.deusops.simplebackend.model.SimpleUser;

import javax.sql.DataSource;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersDAO {

    private final DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<SimpleUser> getAllUsers() {
        return jdbcTemplate
                .queryForStream("SELECT * FROM tbl_users", DataClassRowMapper.newInstance(SimpleUser.class))
                .toList();
    }

    public void save(SimpleUser user) {
        jdbcTemplate.execute("INSERT INTO tbl_users(name) VALUES ('%s')".formatted(user.getName()));
    }

    public void delete(Integer userId) {
        jdbcTemplate.execute("DELETE FROM tbl_users WHERE id = '%d'".formatted(userId));
    }
}
