public class Client extends Human implements Employee {
    //Dependency Inversion Principle
    //Open Closed Principle - имплементируя интерфейс Employee мы добавляем
    private Order order;
    private String statusOrder;
    private String locationOrder;

    public void setOrder(Order order) {
        this.order = order;
        this.locationOrder = "Ваш заказ находится на складе.";
        this.statusOrder = "Заказ на стадии сборки.";
    }

    public Order getOrder() {
        if (this.order == null) {
            this.order = new Order();
            System.out.println("У вас нет открытого заказа. Корзина сформирована автоматически.");
        }
        return this.order;
    }

    public void getStatus() {
        System.out.println(this.statusOrder == null ? "" : this.statusOrder);
    }

    public void getLocation() {
        System.out.println(this.locationOrder == null ? "" : this.locationOrder);
    }

    public void returnOrder() {
        this.order = null;
        this.locationOrder = null;
        this.statusOrder = null;
        System.out.println("Заказ отменен.");
    }


    @Override
    public int getDiscount() {
        return 50;
    }
}
