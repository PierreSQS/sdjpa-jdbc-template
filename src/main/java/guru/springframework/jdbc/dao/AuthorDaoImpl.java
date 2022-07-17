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

    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Author findAuthorById(Long id) {
        return jdbcTemplate.queryForObject(SELECT_AUTHOR_BY_ID,AuthorMapper.authorRowMapper,id);
    }

    @Override
    public Author findAuthorByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Author saveNewAuthor(Author author) {
        return null;
    }

    @Override
    public Author updateAuthor(Author author) {
        return null;
    }

    @Override
    public void deleteAuthorById(Long id) {

    }
}
