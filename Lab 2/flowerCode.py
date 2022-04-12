class Flower(object):

   def __init__( self, petals:int ):
       self.__numPetals = petals
       self.__wilted = False
  
   def getNumPetals( self ) -> int:
       return self.__numPetals

   def isWilted( self ) -> bool:
       return self.__wilted

   def dropPetal( self ) -> None:
       if self.__numPetals > 0:
           self.__numPetals -= 1   

   def wilt( self ) -> None:
       self.__wilted = True

   def __str__( self ) -> str:
       baseRep:str = f"A flower with {self.__numPetals} petals that is "
       if self.isWilted():
           return baseRep + "wilted :("
       else:
           return baseRep + "not wilted!"

def main():
   Flower( 10 )
   buttercup:Flower = Flower( 5 )
   iris:Flower = Flower( 3 )
   print( buttercup )
   print( iris )

   for i in range( 4 ):
       buttercup.dropPetal()
       iris.dropPetal()

   print( buttercup )
   print( iris )
   iris.wilt()
   print( iris )

if __name__ == "__main__":
   main()