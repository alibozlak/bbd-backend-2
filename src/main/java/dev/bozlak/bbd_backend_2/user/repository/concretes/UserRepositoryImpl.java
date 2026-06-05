package dev.bozlak.bbd_backend_2.user.repository.concretes;

import dev.bozlak.bbd_backend_2.user.dtos.UserDtoForAuthModule;
import dev.bozlak.bbd_backend_2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public UserDtoForAuthModule getUserDtoForAuthModule(String userCode) {
        String sql = "SELECT id, user_name, password FROM users WHERE user_name = ?;";
        PreparedStatementSetter preparedStatementSetter = ps -> ps.setString(1, userCode);
        ResultSetExtractor<UserDtoForAuthModule> resultSetExtractor
                = rs -> {
            if (rs.next())
                return new UserDtoForAuthModule(rs.getInt("id"), userCode, rs.getString("password"));
            return null;
        };
        return jdbcTemplate.query(sql, preparedStatementSetter, resultSetExtractor);
    }

    @Override
    public Integer getUserIdByUserCode(String userCode) {
        String sql = "SELECT id FROM users WHERE user_name = ?;";
        ResultSetExtractor<Integer> resultSetExtractor
                = rs -> {
            if (rs.next())
                return rs.getInt("id");
            return null;
        };
        return jdbcTemplate.query(
                sql,
                ps -> ps.setString(1, userCode),
                resultSetExtractor
        );
    }
}
