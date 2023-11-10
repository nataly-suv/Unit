package Shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Shop {

    public static void main(String[] args) {
//        List<Product> products = new ArrayList<>();
////
////        products.add(new Product(39, "морковь"));
////        products.add(new Product(150, "сахар"));
////        products.add(new Product(65, "хлеб"));
////        products.add(new Product(99, "молоко"));
////
////        products = getSortedListProducts(products);
////        System.out.println(products);
////
////        System.out.println(getMostExpensiveProduct(products));

    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public static  List<Product> getSortedListProducts(List<Product> products) {

       products.sort(Comparator.comparingLong(Product::getCost));

        return products;
    };

    /**
     * @return самый дорогой продукт
     */
    public static Product getMostExpensiveProduct(List<Product> products) {
        products.sort(Comparator.comparingLong(Product::getCost).reversed());
        Product mostExpensive = products.get(0);
        return mostExpensive;
    };



}
