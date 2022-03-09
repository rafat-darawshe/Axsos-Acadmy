import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order() {
        name = "Guest";
        items = new ArrayList<Item>();
    }

    public Order(String name) {
        this.name = name;
        items = new ArrayList<Item>();
    }

 
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setReady(boolean isReady) {
        ready = isReady;
    }

    public boolean isReady() {
        return ready;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

 
    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);

    }

    public String getStatusMessage() {
        if (ready) {
            return "Your order is ready";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public void display() {
        System.out.println("Customer name: " + name);
        for (Item item : items) {
            System.out.println(String.format("%s - $%.2f\n", item.getName(), item.getPrice()));
        }

    }

    public double getOrderTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}