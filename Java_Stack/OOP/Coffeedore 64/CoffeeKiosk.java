import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;
     //const
    public CoffeeKiosk(){
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }

    //get & ste

    public ArrayList<Item> getmenu(){
        return menu;
    }
    public void setMenu(ArrayList<Item> menu){
        this.menu = menu;
    }

    public ArrayList<Order> getorder(){
        return orders;
    }
    public void setOrder(ArrayList<Order> orders){
        this.orders = orders;
    }

    // addMenuItem
    public void addMenuItem(String name, double price){
        Item item = new Item(name, price);
        item.setIndex(menu.size());
        menu.add(item);
    }

    // displayMenu
    public void displayMenu(){
        for (Item item: menu){
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
        }
    }

    // newOrder
    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    	// Your code:
        // Create a new order with the given input string
        Order newOrder = new Order(name);
        orders.add(newOrder);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")){
            newOrder.addItem(menu.get(Integer.parseInt(itemNumber)));
            System.out.println("Please enter another menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        newOrder.display();
    
    }

}
