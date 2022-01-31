
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

guido = BankAccount("rafat", "amount")    	
guido.make_deposit(100).make_deposit(200).make_deposit(300).make_withdrawal(50)
print(guido.account_balance)