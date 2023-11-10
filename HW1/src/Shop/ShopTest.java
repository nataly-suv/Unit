package Shop;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {
        /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product(39, "морковь"));
        products.add(new Product(150, "сахар"));
        products.add(new Product(65, "хлеб"));
        products.add(new Product(99, "молоко"));

//        products = Shop.getSortedListProducts(products);
//        System.out.println(products);
//
//        System.out.println(Shop.getMostExpensiveProduct(products));

        // проверка количества продуктов в магазине
        assertThat(products.size()).isEqualTo(4);

        // проверка самого догорого продукта
        assertThat(Shop.getMostExpensiveProduct(products).getCost()).isEqualTo(150);

        // проверка сортировки по цене
        check(products);

    }

    // проверка сортировки по цене
    static void check(List<Product> products) {
        String productSort = "";
        Shop.getSortedListProducts(products);
        for (Product product : products) {
            productSort = productSort + product.getCost();
        }
        assertThat(productSort).isEqualTo("396599150");
    }

}
