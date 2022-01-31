class User:	
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 150
    def make_deposit(self, amount):
    	self.account_balance += amount
    	return self
    def make_withdrawal(self, amount):
        self.account_balance -= amount
        return self
guido = User("rafat", "amount")    	
guido.make_deposit(100).make_deposit(200).make_deposit(300).make_withdrawal(50)
print(guido.account_balance)

