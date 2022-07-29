import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ListProducts listProducts = new ListProducts();
        listProducts.setProduct(new Products("Ложка", 100, 1));
        listProducts.setProduct(new Products("Вилка", 99, 2));
        listProducts.setProduct(new Products("Тарелка", 98, 3));
        listProducts.setProduct(new Products("Кружка", 97, 4));

        Client client = new Client();

        Scanner scanner = new Scanner(System.in);

        boolean commandsWereShown = false;

        while (true) {
            if (!commandsWereShown) {
                System.out.println("Список команд: \n" +
                        "1. Посмотреть список товаров доступных к покупке. \n" +
                        "2. Посмотреть рейтинг товаров доступных к покупке. \n" +
                        "3. Создать заказ. \n" +
                        "4. Просмотреть свой заказ. \n" +
                        "5. Вернуть свой заказ. \n" +
                        "6. Отследить свой заказ. \n" +
                        "7. Получить статус заказа. \n" +
                        "end. Выход из системы навигации.");
            }
            commandsWereShown = true;

            String input = scanner.nextLine();

            if (input.equals("end")) {
                System.out.println("Спасибо, что выбрали нас!");
                break;
            }

            ///Don’t Repeat Yourself
            int numberAction = getInputInteger(input);

            ///Don’t Repeat Yourself
            doAction(numberAction, listProducts, client);
        }
    }

    public static int getInputInteger(String input) {

        int numberAction = 0;

        try {
            numberAction = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Не удалось распознать ввод данных.");
        }

        return numberAction;
    }

    public static void doAction(int numberAction, ListProducts listProducts, Client client) {
        switch (numberAction) {
            case (1):
                listProducts.getListToString();
                break;
            case (2):
                listProducts.showRating();
                break;
            case (3):
                Order order = new Order();
                addProductInOrder(order, listProducts);
                client.setOrder(order);
                break;
            case (4):
                client.getOrder().getSummOrder();
                break;
            case (5):
                client.returnOrder();
                break;
            case (6):
                client.getLocation();
                break;
            case (7):
                client.getStatus();
                break;
        }
    }

    public static void addProductInOrder(Order order, ListProducts listProducts) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите порядковый номер товара или end для окончания подбора.");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println("Подбор товаров завершен.");
                break;
            }

            int numberProduct = getInputInteger(input);

            ////Магические числа
            if (listProducts.getSize() < numberProduct - 1) {
                System.out.println("Товара под данным номером нет.");
                continue;
            }
            order.setProduct(listProducts.getProduct(numberProduct));
        }
    }
}