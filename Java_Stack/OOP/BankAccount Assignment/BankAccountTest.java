public class BankAccountTest {
    
    public static void main(String []args){
        BankAccount client1 = new BankAccount(1000 , 100);
        BankAccount client2 = new BankAccount(5000 , 40);
        BankAccount client3 = new BankAccount(600 , 20);
        client1.depositeCheck(1000);
        client1.withdrawCheck(7500);
        client1.withdrawCheck(550);
        client1.display();
        client2.display();
        client3.display();
        System.out.println(BankAccount.getCounter());
    }
}