import java.util.ArrayList;

public class ListProducts {
    private ArrayList<Products> arrayList;

    public ListProducts() {
        this.arrayList = new ArrayList<>();
    }

    public void setProduct(Products product) {
        this.arrayList.add(product);
    }

    public void getListToString() {
        for (Products p : arrayList
        ) {
            System.out.println(p.toString() + "\n------------");
        }
    }

    public void showRating() {
        for (Products p : arrayList
        ) {
            System.out.println(p.getRating() + "\n------------");
        }
    }

    public Products getProduct(int numberProduct) {
        System.out.println("Товар добавлен.");
        return arrayList.get(numberProduct - 1);
    }

    public int getSize() {
        return arrayList.size();
    }

}
