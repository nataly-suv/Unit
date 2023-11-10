import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class Main {
    public static void main(String[] args) {

        // assert
        int x = -1;
        assert x < 0 : "error";

        // библиотека AssertJ
        assertThat(6 + 2).isEqualTo(8);

        // Задание 3
        // Исправьте метод сложения двух чисел так, чтобы при переполнении переменной выбрасывалось предупреждение.
        sum(2147483647, 0);

        // Задание 4
        String[] colors = {"aqua", "orange", "green", "violet", "yellow", "blue", "gold"};
        testingJavaCollectionsAssertJ(colors);

        // Задание 5
        List<String> heroBag = Arrays.asList("Bow", "Axe", "Gold");
        Hero emmett = new Hero("Emmett", 50, "sword", heroBag, true);
        checkingHero(emmett);

    }


    // Задание 3
    public static int sum(int a, int b) {
        assert Integer.MAX_VALUE - a >= b : "произошло переполнение разряда!";
        return a + b;
    }

    // задание 4

    /**
     * У вас есть следующий метод, который использует assert-выражения из библиотеки AssertJ для проверки
     * содержания массива строк:
     */
//    Создайте массив строк colors, который удовлетворяет всем этим условиям.
    public static void testingJavaCollectionsAssertJ(String[] colors) {
        assertThat(colors)
                .isNotEmpty()
                .hasSize(7)
                .doesNotHaveDuplicates()
                .contains("orange", "green", "violet")
                .endsWith("gold")
                .startsWith("aqua")
                .containsSequence("yellow", "blue")
                .doesNotContain("red", "black");
    }

    /**
     * Задание 5
     * 8) Удовлетворить всем условиям: <p>
     * 1. Проверить, что герой создался с именем Emmett<p>
     * 2. Проверить, что значение прочности брони героя равно 50<p>
     * 3. Проверить, что у героя оружие типа sword<p>
     * 4. Проверить содержимое инвентаря героя (размер 3, содержимое "Bow", "Axe", "Gold", порядок не важен)<p>
     * 5. Проверить, что герой это человек (свойство isHuman)<p>
     */


    public static void checkingHero(Hero hero) {
        assertThat(hero.getName()).isEqualTo("Emmett");
        assertThat(hero.getArmorStrength()).isEqualTo(50);
        assertThat(hero.getWeapon()).isEqualTo("sword");
        assertThat(hero.getBag()).isNotEmpty()
                .hasSize(3)
                .contains("Bow", "Axe", "Gold");
        assertThat(hero.isHuman()).isTrue();
    }

}