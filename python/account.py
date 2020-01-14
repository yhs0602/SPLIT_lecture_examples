class NoMoneyError(BaseException):
    pass

class Account:
    def __init__(self, name):
        self.money = 0
        self.name = name
    
    def deposit(self, amount):
        self.money += amount
    
    def spend(self, amount):
        if self.money < amount:
            print("돈이 없습니다")
            raise NoMoneyError()
        self.money -= amount

    def showMoneny(self):
        print(self.money)
    
    def sendTo(self, target, amount):
        try:
            self.spend(amount)
            target.deposit(amount)
        except:
            pass
        
    def __repr__(self):
        return "Account(" + self.name + ") left = " + str(self.money)

    def __str__(self):
        return "str version of " + self.__repr__()

account1 = Account("계좌 1")
account2 = Account("받을 계좌")
account1.deposit(10000)
account1.showMoneny()
account1.sendTo(account2, 20000)
