# Universal Grid Analyzer(AP CSa Project)

A Java-based tool designed to generate and analyze 2D arrays. This project demonstrates various array traversal techniques, including row-major, column-major, and diagonal traversals.

## Features

This program generates a random grid (minimum 6x6) and provides a menu-driven interface to perform the following operations:

1.  **Show Grid**: Displays the current 2D array in a formatted table.
2.  **Row/Col Sums**: Calculates the sum of every row and column, identifying the highest and lowest values.
3.  **Max/Min**: Finds the absolute maximum and minimum values within the entire grid.
4.  **Frequency**: Counts how many times a specific user-inputted number appears.
5.  **Pattern Check**: Scans the grid to find the first row where the numbers are in strictly increasing order.
6.  **Transform**: Swaps two entire rows based on user input.
7.  **Subgrid**: Calculates the sum and maximum value within a specific rectangular section of the grid.
8.  **Boundary/Diagonals**: Extracts the "outer shell" of the grid as well as the main and secondary diagonals.
9.  **Check Duplicates**: Scans rows to see if any numbers are repeated.

## How to Run

1.  **Compile the program**:
    ```bash
    javac APCSAProject.java
    ```
2.  **Run the program**:
    ```bash
    java APCSAProject
    ```
3.  **Follow the prompts**: Enter the desired dimensions for your grid and choose an option from the menu.

## Requirements
* Java Development Kit (JDK) 8 or higher.
* A terminal or IDE (like BlueJ, Eclipse, or VS Code).
* Windows 7 or higher, or linux equivilant.