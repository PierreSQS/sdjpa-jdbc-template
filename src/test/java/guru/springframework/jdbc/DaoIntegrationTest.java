package guru.springframework.jdbc;

import guru.springframework.jdbc.dao.AuthorDao;
import guru.springframework.jdbc.dao.AuthorDaoImpl;
import guru.springframework.jdbc.domain.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Pierrot on 7/17/22.
 */

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(AuthorDaoImpl.class)
class DaoIntegrationTest {

    @Autowired
    AuthorDao authorDao;

    @Test
    void testDeleteAuthor() {
        Author author = new Author();
        author.setFirstName("john");
        author.setLastName("t");

        System.out.printf("%n###### the author to delete: %s %s ######%n%n"
                , author.getFirstName(), author.getLastName());

        Author saved = authorDao.saveNewAuthor(author);
        Long id = saved.getId();

        authorDao.deleteAuthorById(saved.getId());

        Assertions.assertThrows(EmptyResultDataAccessException.class,
                () -> authorDao.findAuthorById(id));

    }

    @Test
    void testUpdateAuthor() {
        Author author = new Author();
        author.setFirstName("john");
        author.setLastName("t");

        System.out.printf("%n###### the author to update: %s %s ######%n%n"
                , author.getFirstName(), author.getLastName());

        Author saved = authorDao.saveNewAuthor(author);

        saved.setLastName("Thompson");
        Author updated = authorDao.updateAuthor(saved);

        assertThat(updated.getLastName()).isEqualTo("Thompson");

        System.out.printf("%n###### the updated author name: %s %s ######%n%n"
                , updated.getFirstName(), updated.getLastName());
    }

    @Test
    void testInsertAuthor() {
        Author author = new Author();
        author.setFirstName("john");
        author.setLastName("t");

        Author saved = authorDao.saveNewAuthor(author);
        assertThat(saved).isNotNull();
        System.out.printf("%n###### the saved author name: %s %s ######%n%n"
                , author.getFirstName(), author.getLastName());
    }

    @Test
    void testGetAuthorByName() {
        Author author = authorDao.findAuthorByName("Craig", "Walls");
        assertThat(author).isNotNull();
        System.out.printf("%n###### the found author name: %s ######%n%n", author.getLastName());
    }

    @Test
    void testGetAuthorById() {
        Author author = authorDao.findAuthorById(2L);
        assertThat(author.getId()).isNotNull();
        System.out.printf("%n###### the found author name: %s ######%n%n", author.getLastName());

    }
}
