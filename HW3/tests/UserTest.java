import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class UserTest {
    private User user1;
    private User user2;
    private User admin;


    @BeforeEach
    void setUp() {
        user1 = new User("Nataly", "123456", false);
        user2 = new User("Ivan", "12345", false);
        admin = new User("Nika", "123", true);
    }

    // проверка позитивного сценария аутентификации
    @Test
    void checkDataPositiveCase() {
        assertThat(user1.authenticate("Nataly", "123456")).isTrue();
    }


    // проверка негативного сценария аутентификации
    @Test
    void checkDataNegativeCase() {
        assertThat(user1.authenticate("Natalia", "123456")).isFalse();
    }


    // проверка добавления пользователя
    @Test
    void addUserTest(){
        UserRepository userRepository = new UserRepository() ;
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        int quantityBefore = userRepository.data.size();

        userRepository.addUser(admin);

        assertThat(userRepository.data.size()).isEqualTo(quantityBefore+1);

    }

    // разлогинивание всех пользователей, кроме администратора
    @Test
    void logOutTest(){
        UserRepository userRepository = new UserRepository() ;
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(admin);
        userRepository.logOut();

        assertThat(userRepository.data.size()).isEqualTo(1);

    }






}
