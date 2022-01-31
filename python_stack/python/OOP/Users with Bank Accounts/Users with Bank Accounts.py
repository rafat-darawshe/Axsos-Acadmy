class BankAccount:
      def __init__(self, int_rate, balance):
        self.int_rate = int_rate
        self.balance = balance
    
      def deposit(self, amount):
        self.balance += amount
        return self
    
      def withdraw(self, amount):
        self.balance -= amount
        return self
    
      def display_account_info(self):
        print("Account balance: $" + str(self.balance) +
              "\n" + "Interest rate:", self.int_rate)
        return self
    
      def yield_interest(self):
        self.balance += self.balance * self.int_rate / 100
        return self

class User:
      def __init__(self, name, email, int_rate, balance):
        self.name = name
        self.email = email
        self.account = BankAccount(int_rate, balance)

rafat = User('rafat', 'rafat@com', 3, 1000)
gnida = User('Gnida', 'gnida@com', 2, 2000)


