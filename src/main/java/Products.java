public class Products implements Building, Household {
    //Interface Segregation Principle
    private String name;
    private double price;
    private int rating;

    public Products(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("%s \nЦена: %s", name, price);
    }

    public String getRating() {
        return String.format("%s: Рейтинг: %s", name, rating);
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void totake() {
        System.out.println("Покрутили в руках, посмотрели!");
    }

    @Override
    public void checkWork() {
        System.out.println("выполняет свои заложенные функции!");
    }
}
