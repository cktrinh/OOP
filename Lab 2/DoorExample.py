""" create/behavior/data/blueprint/particular object
== construct/ method / property/ ... / instance
order a glass door: construct a door instance

Create an instance of a door
glassDoor = Door("glass")

Access instance property: " self.__something__ "
(data associated to the object. Ask if it's true/false? that's when we access it?)

invokes an instance method: anything but definitions

"""
### TRACING OOP IN PYTHON ###

class BankAccount(object):
   def __init__( self, initialDollars:int, initialCents:int ):
       self.__dollars:int = initialDollars
       self.__cents:int = initialCents

   def getDollars( self ) -> int:
       return self.__dollars

   def getCents( self ) -> int:
       return self.__cents

   def getBalance( self ) -> float:
       return self.__dollars + self.__cents/100.0

   def setDollars( self, updatedDollars:int ):
       self.__dollars = updatedDollars

   def setCents( self, updatedCents:int ):
       self.__cents = updatedCents

   def deposit( self, additionalDollars:int, additionalCents:int ):
       totalCents:int = self.getCents() + additionalCents       
       if totalCents >= 100:           
           self.setDollars( self.getDollars() + additionalDollars + 1)
           self.setCents( totalCents - 100 )
       else:
           self.setDollars( self.getDollars() + additionalDollars )
           self.setCents( totalCents )

def main():
   BankAccount( 0, 0 )
   checkingAccount:BankAccount = BankAccount( 1837, 22 )
   print( f"Account has ${checkingAccount.getBalance()}" )
   checkingAccount.deposit( 184, 81 );
   print( f"After deposit, now ${checkingAccount.getBalance()}" )

if __name__ == "__main__":
   main()
