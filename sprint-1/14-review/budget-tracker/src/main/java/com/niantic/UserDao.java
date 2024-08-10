package com.niantic;

import com.niantic.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.util.ArrayList;

public class UserDao {
    JdbcTemplate jdbcTemplate;

    public ArrayList<User> getAllUsers() {

        var users = new ArrayList<User>();

        String sql = """
                SELECT user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                FROM users
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int userId = row.getInt("user_name");
            String userName = row.getString("user_name");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");
            String phone = row.getString("phone");
            String email = row.getString("email");

            User user = new User(userId, userName, firstName, lastName, phone, email);

            users.add(user);
        }
        return users;
    }

    public User getUserById(int userId)
    {
        String sql = """
                SELECT user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                FROM users
                WHERE user_id = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);


        int usersId = row.getInt("user_id");
        String userName = row.getString("user_name");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        String phone = row.getString("phone");
        String email = row.getString("email");

        User user = new User(usersId, userName, firstName, lastName, phone, email);

        user.setUserId(userId);
        user.setUsername(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phone);
        user.setEmail(email);

        return user;
    }

    public User getUserByName(String name)
    {
        String sql = """
                SELECT user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                FROM users
                WHERE user_name = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, name);

        int userId = row.getInt("user_id");
        String userName = row.getString("user_name");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        String phone = row.getString("phone");
        String email = row.getString("email");

        User user = new User(userId, userName, firstName, lastName, phone, email);

        user.setUserId(userId);
        user.setUsername(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phone);
        user.setEmail(email);

        return user;
    }

    public void addUser(User user)
    {
        String sql = """
                INSERT INTO users(user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email)
                VALUES(?, ?, ?, ?, ?, ?);
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
                UPDATE users
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
                DELETE FROM users
                WHERE user_id = ?;
                """;

        jdbcTemplate.update(sql, userId);
    }
}
