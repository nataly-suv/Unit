package seminars.five;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    /** 5.1. */
    // проверка запоняемости листа
    @Test
    void checkListNumbers() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        List<Integer> listNumbers =  randomNumberModule.generateListNumbers();

        assertThat(listNumbers.size()).isEqualTo(10);
    }

    // проверка поиска максимального числа
    @Test
    void searchMax() {
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        List<Integer> list = new ArrayList<>(Arrays.asList(10, 15, 100, 56, 13));

        assertThat(maxNumberModule.maxNumberInList(list)).isEqualTo(100);
    }

    // проверка взаимодействия двух ксаллов
    @Test
    void randomNumberMaxTest() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        List<Integer> listNumbers =  randomNumberModule.generateListNumbers();
        int max = maxNumberModule.maxNumberInList(listNumbers);

        assertThat(max).isEqualTo(Collections.max(listNumbers));
    }

    /** 5.2. */
    @ParameterizedTest
    @ValueSource(ints = {1, 100, -10})
    void testUserIntegration(int id) {
        UserRepository ur = new UserRepository();
        UserService us = new UserService(ur);

        String result = us.getUserName(id);

        assertEquals("select username from users where id = " + id, result);
    }





    /** 5.3. */
    @Test
    void orderServiceTest() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("10", 120);

        assertTrue(result);
    }
}