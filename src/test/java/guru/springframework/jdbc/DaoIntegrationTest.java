package guru.springframework.jdbc;

import guru.springframework.jdbc.dao.AuthorDao;
import guru.springframework.jdbc.dao.AuthorDaoImpl;
import guru.springframework.jdbc.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Pierrot on 7/17/22.
 */

@Profile("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoIntegrationTest {

    @Test
    void testDeleteAuthor() {

    }

    @Test
    void testUpdateAuthor() {

    }

    @Test
    void testInsertAuthor() {

    }

    @Test
    void testGetAuthorByName() {

    }

    @Test
    void deleteAuthorById() {
    }
}
