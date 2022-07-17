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
        int updatedRowID = this.jdbcTemplate.update(
                INSERT_INTO_AUTHOR_FIRST_NAME_LAST_NAME,
                author.getFirstName(), author.getLastName());

        if (updatedRowID != 0) {
            return author;
        } else {
            return null;
        }

    }

    @Override
    public Author updateAuthor(Author author) {
        int updatedRowID = this.jdbcTemplate.update(
                UPDATE_AUTHOR_SET_FIRST_NAME_LAST_NAME_WHERE_ID,
                author.getFirstName(), author.getLastName(), author.getId());

        if (updatedRowID != 0) {
            return author;
        } else {
            return null;
        }
    }

    @Override
    public void deleteAuthorById(Long id) {

    }
}
