# **Minesweeper Game in Java**  
Academic Assignment for Unitelma Sapienza University.

This project is an implementation of the classic Minesweeper game in Java vanilla.

## Features

* **Grid Generation:** Creates a game grid with randomly placed mines.
* **Cell Discovery:** Allows the player to uncover cells and reveal the numbers of adjacent mines.
* **Mine Management:** Handles the game logic to reveal mines and end the game in case of defeat.
* **Command-Line Interface:** Provides a simple interface to interact with the game via the command line.

## Getting Started

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/piedg/Java-MineSweeper.git
    ```

2.  **Compile the Code:**
    ```bash
    javac MineSweeper.java
    ```

3.  **Run the Game:**
    ```bash
    java MineSweeper
    ```

## How to Play
* The game presents a grid of hidden cells.
* Enter coordinates to reveal cell.
* Some cells contain mines.
* The goal is to uncover all the cells that do not contain mines.
* When you uncover a cell, a number is revealed that indicates how many mines are present in the adjacent cells.
* If you uncover a cell with a mine, the game ends.

## Contributions

Contributions are welcome! If you find bugs or have suggestions for improvements, feel free to open an issue or submit a pull request.

## License

This project is distributed under the MIT license. See the `LICENSE` file for more details.
