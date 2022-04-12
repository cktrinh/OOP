"""Define a simple class that represents a marker. Write your class definition in a file named Marker.py, 
adhering to the following specification:
The class should be named Marker. There should be a two instance properties of type str that maintain:
the color of the marker
the color of the marker's cap
"""
class Marker:
    def __init__(self, colorMarker: str):
        self.colorMarker=colorMarker
        self.colorMarkerCap=colorMarker

    def getColor(self):
        return self.colorMarker

myMarker = Marker('green')
theColor = myMarker.getColor()

"""
The constructor should take in a single argument for the color of the marker. 
The cap should be initialized to the same color.
There should be getters for each instance property called getColor and getCapColor.
There should be a setter to change the marker cap color (because this happens in real life!) called setCapColor.
Since markers cant change color, there will be no setter for the marker's color.

There should be an instance method called __str__ that takes in no parameters and returns a string representation of the marker. If the marker is red with a blue cap, for example, it should return 
"A red marker with a blue cap."

main.py
In a file main.py, define a main function that:
Instantiates a new Marker instance that represents a red marker and assign it to a variable called redMarker.
Instantiates a new Marker instance that represents a green marker and assign it to a variable called greenMarker.
Print information about the greenMarker.
Print information about the redMarker.
Set the color of the cap of the red marker to be blue. 
Print information about the redMarker."""

