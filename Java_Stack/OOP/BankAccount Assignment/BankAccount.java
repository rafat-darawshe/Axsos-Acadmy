public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int counter;
    private static double totalAmount;

    public static double getCounter(){
        return counter;
    }


    public BankAccount(double checkingBalance , double savingsBalance){
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        counter++;
    }
    public double getcheckingBalance(){
        return this.checkingBalance;
    }
    public double getsavingsBalance(){
        return this.savingsBalance;
    }
    public void depositeCheck(double amount){
        this.checkingBalance +=amount;
    }
    public void depositeSave(double amount){
        this.savingsBalance +=amount;
    }
    public void withdrawCheck(double amount){
        if (this.checkingBalance - amount < 0){
            System.out.println("Sorry , you don't have enough money");
        }
        else {
            this.checkingBalance -=amount;
        }
        
    }
    public void withdrawalSave(double amount){
        if (this.savingsBalance - amount < 0){
            System.out.println("Sorry , you don't have enough money");
        }
        else {
            this.savingsBalance -=amount;
        }
    }
    public void display(){
        System.out.println(this.checkingBalance);
        System.out.println(this.savingsBalance);
    }

}