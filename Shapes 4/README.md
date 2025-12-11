# Shapes Phase 4
This project demonstrates how to draw simple shaped in a window and how to save and them using Java serialization tools.

## Project overview
The program displays a window containing basic shapes (rectangles and ovals).  
Users can interact with the program through keyboard commands:

- Press **A** to add a new rectangle.
- Press **S** to save the current drawing to a binary file.
- Press **R** to restore shapes from a previously saved binary file.

- All shapes are stored in a list and written to the file in a single `writeObject()` call
- When loading, the entire list is restored using `readObject()` and the window is repainted to update the display.

## Key Concepts Used
- Swing GUI (`JFrame`, `Graphics`)
- Keyboard input handling (`KeyListener`)
- `JFileChooser` for selecting save/load locations
- Java serialization  
  - `ObjectOutputStream`
  - `ObjectInputStream`
- Handling file exceptions safely
- Drawing shapes using custom classes

## How it works
- the program keeps a list shapes in the main class
- shapes extend and class myshapes that implements serializable
- **S** the entire list is saved to a binary file
- **R** the list is loaded back and the screen is repainted
- all file interactions used try catch blocks for safe stream handling

## Files 
- ShapePhase4.java - main program 
    - window setup
    - key listener
    - save and load methods
    - shape classes for rectangle and oval
