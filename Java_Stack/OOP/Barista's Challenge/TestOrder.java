public class TestOrder {

    public static void main(String[] args) {
        // Items
        Item item1 = new Item("mocha", 2.5);
        Item item2 = new Item("latte", 4.5);
        Item item3 = new Item("drip coffe", 6);

        // Orders
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("ٌRafat");
        Order order4 = new Order("nader");
        Order order5 = new Order("Abed");

        // Add items
        order1.addItem(item1);
        order1.addItem(item2);
        order4.addItem(item2);
        order5.addItem(item1);
        order5.addItem(item3);

        // Display
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

        // Ready
        order1.setReady(true);
        order5.setReady(false);
        order4.setReady(true);
        System.out.println(order1.getStatusMessage());
        System.out.println(order5.getStatusMessage());
        System.out.println(order4.getStatusMessage());

    }
}