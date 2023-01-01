package pl.valdemar.flashcardsboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

//@Sql({"/data.sql"})
@SpringBootTest
class FlashcardsBootApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    public void givenDatasourceAvailableWhenAccessDetailsThenExpectDetails() throws SQLException {
        assertThat(dataSource.getClass().getName()).isEqualTo("com.zaxxer.hikari.HikariDataSource");
        assertThat(dataSource.getConnection().getMetaData().getDatabaseProductName()).isEqualTo("H2");
    }

    @Test
    public void whenCountAllCoursesThenExpectFiveCourses() throws SQLException {
        ResultSet rs = null;
        int noOfCourses = 0;
        try(PreparedStatement ps = dataSource.getConnection().prepareStatement("SELECT COUNT(1) FROM COURSES")) {
            rs = ps.executeQuery();
            while(rs.next()) {
                noOfCourses = rs.getInt(1);

            }
            assertThat(noOfCourses).isEqualTo(5L);
        }
        finally {
            if(rs != null) {
                rs.close();
            }
        }
    }

    @Test
    public void whenCountAllDecksThenExpectFiveDecks() throws SQLException {
        ResultSet rs = null;
        int noOfDecks = 0;
        try(PreparedStatement ps = dataSource.getConnection().prepareStatement("SELECT COUNT(1) FROM DECKS")) {
            rs = ps.executeQuery();
            while(rs.next()) {
                noOfDecks = rs.getInt(1);

            }
            assertThat(noOfDecks).isEqualTo(5L);
        }
        finally {
            if(rs != null) {
                rs.close();
            }
        }
    }

    @Test
    public void whenCountAllFlashcardsThenExpectEightFlashcards() throws SQLException {
        ResultSet rs = null;
        int noOfFlashcards = 0;
        try(PreparedStatement ps = dataSource.getConnection().prepareStatement("SELECT COUNT(1) FROM FLASHCARDS")) {
            rs = ps.executeQuery();
            while(rs.next()) {
                noOfFlashcards = rs.getInt(1);

            }
            assertThat(noOfFlashcards).isEqualTo(8L);
        }
        finally {
            if(rs != null) {
                rs.close();
            }
        }
    }

    @Test
    public void whenCountAllUsersThenExpectTwoUsers() throws SQLException {
        ResultSet rs = null;
        int noOfUsers = 0;
        try(PreparedStatement ps = dataSource.getConnection().prepareStatement("SELECT COUNT(1) FROM USERS")) {
            rs = ps.executeQuery();
            while(rs.next()) {
                noOfUsers = rs.getInt(1);

            }
            assertThat(noOfUsers).isEqualTo(2L);
        }
        finally {
            if(rs != null) {
                rs.close();
            }
        }
    }
}
