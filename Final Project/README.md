# NASA Meteorite Database (Java)

## Description
This program is a menu-driven Java application that loads, stores, and analyzes meteorite landing data from NASA.
The data is read from a JSON file, stored in memory, and can be saved to or loaded from a binary file for later use.

## Features
- Load meteorite data from a JSON file
- Display all meteorites
- Save meteorite data to a binary file
- Search meteorites by name
- Search meteorites by ID
- List the largest meteorites by mass
- List the most recent meteorites by year
- List meteorites by classification

## Files
- UserInterface.java – Handles the menu and user interaction
- MyMeteor.java – Contains the main method
- Meteorite.java – Meteorite data model
- Geolocation.java – Location data for meteorites
- NASA_Meteorite.json – Input data file
- meteorites.dat – Binary data file (created at runtime)

## How to Run
Compile the program:
javac -cp ".;lib/gson-2.10.1.jar" *.java

Run the program:
java -cp ".;lib/gson-2.10.1.jar" MyMeteor



