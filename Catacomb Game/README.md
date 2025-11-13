 # CataComb 

 ## Project Description
 The catacomb is an N-by-N square of rooms (for example, if the user selects 7, the catacomb will have seven rows of 7 rooms each, for a total of 49 rooms). The hero character begins with 100 health in the room in the northwest part of the catacomb. The game's goal is for the hero to reach the catacomb's southeast corner before running out of health. There will be obstacle like monster but also some awards like gold in the game

 ## Project Guide
 ### Dependencies
 This project is based on java code and is able to run on studio code. Java docs will be used a few times

 ### How to run the project
The code needs to be saves as .java file. It can be opened in in VS Code  or IntelliJ. Make sure it run inside a folder were it is saves mine is in the 1180 java projects. Run the program in the terminal and play the game.

 ### How to play the game
 **Movement**
 When game starts type hero's name like Bob. pick the size of the map 5-10 like 7. this will give you 49 rooms with the two d array
 Each turn, you can move by typing a direction:

 - N = North (up)

 - S = South (down)

 - E = East (right)

 - W = West (left)
 It needs to be uppercase, or else it will be invalid, so it can accept N, not n.

**Monster**
 - If you enter a room with a monster, you and the monster will take turns attacking each other. Your attacks deal between 1 and 10 random damage, while the monster's attacks deal between 1 and 5 random damage. You must defeat the monster in order to survive!

 **Gold** 
  - If you enter a room with gold, you automatically pick up one gold piece. Your goal is to survive and collect as much gold as possible!

**Win**
 - You win by reaching the bottom-right corner of the map, which is located at coordinates (N-1, N-1).
 - Game will show final result of gold and health

 **Lose** 
 - You lose the game if your health reaches zero.
 - Game will show final result of gold and health

 ## Lessons Learned
I learned more about 2D arrays and how to implement extra features in the game, along with creating getters and setters and defining objects in my class. At the beginning of the class, I didn't think we would cover multiple classes, but that turned out not to be true. I also learned about inheritance and how to use my UML diagram, which will be helpful for my future projects. During the summer, I can use this knowledge to help build projects like the app I mentioned or participate in my next virtual hackathon.
