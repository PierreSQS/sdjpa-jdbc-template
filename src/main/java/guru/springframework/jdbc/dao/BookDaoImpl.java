package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Pierrot on 7/18/22.
 */
@Component
public class BookDaoImpl implements BookDao {

    public static final String SELECT_BOOK_BY_TITLE = "SELECT * FROM BOOK WHERE title = ?";

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book findBookByTitle(String bookTitle) {
        return jdbcTemplate.queryForObject(
                SELECT_BOOK_BY_TITLE, BookMapper.bookRowMapper, bookTitle);
    }
}
