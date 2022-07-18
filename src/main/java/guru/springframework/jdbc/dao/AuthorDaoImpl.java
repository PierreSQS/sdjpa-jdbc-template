package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Pierrot on 7/17/22.
 */
@Component
public class AuthorDaoImpl implements AuthorDao {
    public static final String SELECT_AUTHOR_BY_ID =
            "SELECT * FROM AUTHOR where id = ?";

    public static final String SELECT_AUTHOR_BY_NAME =
            "SELECT * FROM AUTHOR where first_name = ? AND last_name = ?";

    public static final String INSERT_INTO_AUTHOR_FIRST_NAME_LAST_NAME =
            "INSERT INTO AUTHOR (first_name, last_name) VALUES (?, ?)";

    public static final String UPDATE_AUTHOR_SET_FIRST_NAME_LAST_NAME_WHERE_ID =
            "UPDATE AUTHOR SET first_name = ? , last_name = ? WHERE id = ?";

    public static final String SELECT_LAST_INSERT_ID =
            "SELECT LAST_INSERT_ID()";
    public static final String DELETE_FROM_AUTHOR_WHERE_ID = "DELETE FROM AUTHOR where id = ?";

    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Author findAuthorById(Long id) {
        return jdbcTemplate.queryForObject(
                SELECT_AUTHOR_BY_ID, AuthorMapper.authorRowMapper, id);
    }

    @Override
    public Author findAuthorByName(String firstName, String lastName) {
        return jdbcTemplate.queryForObject(
                SELECT_AUTHOR_BY_NAME, AuthorMapper.authorRowMapper, firstName, lastName);
    }

    @Override
    public Author saveNewAuthor(Author author) {
        this.jdbcTemplate.update(
                INSERT_INTO_AUTHOR_FIRST_NAME_LAST_NAME,
                author.getFirstName(), author.getLastName());

        Long createdId = jdbcTemplate.queryForObject(SELECT_LAST_INSERT_ID, Long.class);
        return findAuthorById(createdId);
    }

    @Override
    public Author updateAuthor(Author author) {
        this.jdbcTemplate.update(
                UPDATE_AUTHOR_SET_FIRST_NAME_LAST_NAME_WHERE_ID,
                author.getFirstName(), author.getLastName(), author.getId());

        Long createdId = jdbcTemplate.queryForObject(SELECT_LAST_INSERT_ID, Long.class);
        return findAuthorById(createdId);
    }

    @Override
    public void deleteAuthorById(Long id) {
        this.jdbcTemplate.update(DELETE_FROM_AUTHOR_WHERE_ID,id);
    }
}
