    public class Test {
        public static void main(String[] args) {
            CoffeeKiosk kiosek = new CoffeeKiosk();
            kiosek.addMenuItem("drip coffee", 6.5);
            kiosek.addMenuItem("banana", 4.7);
            kiosek.addMenuItem("latte", 9.0);
            kiosek.addMenuItem("capuccino", 5.5);
            kiosek.addMenuItem("muffin", 5.0);
            kiosek.newOrder();
        }
    }

