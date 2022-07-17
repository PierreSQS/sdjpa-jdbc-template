package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Author;
import org.springframework.jdbc.core.RowMapper;

public class AuthorMapper {

    private AuthorMapper() {
    }

    public static final RowMapper<Author> authorRowMapper = (rs, rowNum) -> {
        Author author = new Author();
        author.setId(rs.getLong("id"));
        author.setLastName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        return author;
    };
}
