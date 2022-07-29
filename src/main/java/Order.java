import java.util.HashMap;
import java.util.Map;

public class Order {
    private HashMap<Products, Integer> products;

    public Order() {
        this.products = new HashMap<>();
    }

    public void setProduct(Products product) {
        Integer n = products.get(product);
        if (n == null) {
            n = 0;
        }
        products.put(product, n + 1);
    }

    public void getSummOrder() {
        double summ = 0;
        System.out.println("В заказе: ");
        for (Map.Entry entry : products.entrySet()) {
            Products products = (Products) entry.getKey();
            int count = (int) entry.getValue();
            double price = products.getPrice();
            summ += count * price;
            System.out.println(products.getName() + ": Количество: " + count);

        }
        System.out.println("Всего товара на сумму: " + summ);
    }

}
