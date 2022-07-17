package guru.springframework.jdbc;


import guru.springframework.jdbc.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testMySQL() {

        long numberOfBooks = bookRepository.count();
        assertThat(numberOfBooks).isEqualTo(5);

        System.out.printf("%n####### The number of books in the MySQL-DB: %d #######%n%n",numberOfBooks);

    }

}


