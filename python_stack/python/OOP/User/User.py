class User:		
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 150
    def make_deposit(self, amount):
    	self.account_balance += amount
    def make_withdrawal(self, amount):
        self.account_balance -= amount
guido = User("rafat", "amount")    	
guido.make_deposit(100)
guido.make_withdrawal(200)
print(guido.account_balance)	

