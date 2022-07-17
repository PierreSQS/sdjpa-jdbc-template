package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Author;

/**
 * Created by Pierrot on 7/17/22.
 */
public interface AuthorDao {
    Author findAuthorById(Long id);

    Author findAuthorByName(String firstName, String lastName);

    Author saveNewAuthor(Author author);

    Author updateAuthor(Author author);

    void deleteAuthorById(Long id);
}
