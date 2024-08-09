package com.niantic;

import com.niantic.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class UserDao
{
    JdbcTemplate jdbcTemplate;
    public void addUser(User user)
    {
        String sql = """
                INSERT INTO user(user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email)
                VALUES(?, ?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(sql,
                user.getUserId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getEmail());
    }

    public void updateUser(User user)
    {
        String sql = """
                UPDATE user
                SET user_name = ?,
                    first_name = ?,
                    last_name = ?,
                    phone = ?,
                    email = ?
                WHERE user_id = ?;
                """;

        jdbcTemplate.update(sql,
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getUserId());
    }

    public void deleteUser(int userId)
    {
        String sql = """
                DELETE FROM user
                WHERE user_id = ?;
                """;

        jdbcTemplate.update(sql, userId);
    }
}
