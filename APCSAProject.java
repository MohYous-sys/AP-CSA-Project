import java.util.Scanner;

public class APCSAProject {
    
    static Scanner input = new Scanner(System.in);
    static int[][] grid;
    static int rows, cols;
    
    public static void main(String[] args) {
        System.out.println("Universal Grid Analyzer(AP CSA project)");

        System.out.print("Enter rows (min 6): ");
        rows = input.nextInt();
        while(rows < 6) {
            System.out.print("Need at least 6: ");
            rows = input.nextInt();
        }
        
        System.out.print("Enter cols (min 6): ");
        cols = input.nextInt();
        while(cols < 6) {
            System.out.print("Need at least 6: ");
            cols = input.nextInt();
        }
        
        grid = new int[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                grid[i][j] = (int)(Math.random() * 50) + 1;
                }
            }
        showGrid();

        // menu
        boolean run = true;
        while(run) {
            System.out.println("MENU");
            System.out.println("1.Show Grid");
            System.out.println("2.Row/Col Sums");
            System.out.println("3.Max/Min");
            System.out.println("4.Frequency");
            System.out.println("5.Pattern Check");
            System.out.println("6.Transform");
            System.out.println("7.Subgrid");
            System.out.println("8.Boundary/Diagonals");
            System.out.println("9.Check Duplicates");
            System.out.println("0.Exit");
            
            int opt = input.nextInt();

            switch(opt) {
                case 1: showGrid(); break;
                case 2: Sum(); break;
                case 3: maxAndMin(); break;
                case 4: frequency(); break;
                case 5: pattern(); break;
                case 6: transform(); break;
                case 7: subgrid(); break;
                case 8: boundaryDiag(); break;
                case 9: checkDuplicates(); break;
                case 0: run = false; System.out.println("End"); break;
                default: System.out.println("Please choose a valid number");
            }
        }
    }
    
    static void showGrid() {
        System.out.println("Grid:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", grid[i][j]);
            }
            System.out.println();
        }
    }

    static void Sum() {
        int[] sumofrows = new int[rows];
        int[] sumofcols = new int[cols];

        for(int i=0; i<rows; i++) {
            int sum = 0;
            for(int j=0; j<cols; j++) {
                sum += grid[i][j];
            }
            sumofrows[i] = sum;
        }

        for(int j=0; j<cols; j++) {
            int sum = 0;
            for(int i=0; i<rows; i++) {
                sum += grid[i][j];
            }
            sumofcols[j] = sum;
        }

        System.out.println("Row sums:");
        for(int i=0; i<rows; i++) {
            System.out.println("  Row " + i + ": " + sumofrows[i]);
        }

        System.out.println("Col sums:");
        for(int j=0; j<cols; j++) {
            System.out.println("  Col " + j + ": " + sumofcols[j]);
        }

        int maxRow = 0, minCol = 0;
        for(int i=1; i<rows; i++) {
            if(sumofrows[i] > sumofrows[maxRow]) maxRow = i;
        }
        for(int j=1; j<cols; j++) {
            if(sumofcols[j] < sumofcols[minCol]) minCol = j;
        }
        System.out.println("Sum of Row: " + " (" + sumofrows[maxRow] + ")");
        System.out.println("Sum of Col: " +  " (" + sumofcols[minCol] + ")");
        System.out.println("Sum of All: " +  " (" + (sumofcols[minCol] + sumofrows[maxRow]) + ")");
    }

    static void maxAndMin() {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
                if (grid[i][j] < min) {
                    min = grid[i][j];
                }
            }
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min );
    }

    static void frequency() {
        System.out.print("Value to count: ");
        int val = input.nextInt();

        int countVal = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == val) {
                    countVal++;
                }
            }
        }

        System.out.println(val + " appears " + countVal + " times");
    }

    static void pattern() {
        int foundRow = -1;

        for (int i = 0; i < rows; i++) {
            boolean increasing = true;

            for (int j = 1; j < cols; j++) {
                if (grid[i][j] <= grid[i][j - 1]) {
                    increasing = false;
                    break;
                }
            }

            if (increasing) {
                foundRow = i;
                break;
            }
        }

        if (foundRow != -1) System.out.println("First increasing row found at Row: " + foundRow); else System.out.println("No increasing row found.");
    }

    static void transform() {
        System.out.print("Enter two row to swap: ");
        int r1 = input.nextInt(), r2 = input.nextInt();

        if (r1 >= 0 && r1 < rows && r2 >= 0 && r2 < rows) {
            int[] t = grid[r1];
            grid[r1] = grid[r2];
            grid[r2] = t;

            System.out.println("Rows swapped.");
            showGrid();
        }
    }

    static void subgrid() {
        System.out.print("Enter bounds (rs re cs ce): ");
        int rs = input.nextInt(), re = input.nextInt(), cs = input.nextInt(), ce = input.nextInt();

        if (rs < 0 || re >= rows || cs < 0 || ce >= cols || rs > re || cs > ce) return;

        int sum = 0, max = grid[rs][cs];

        for (int i = rs; i <= re; i++) {
            for (int j = cs; j <= ce; j++) {
                int val = grid[i][j];
                sum += val;
                max = Math.max(max, val);
            }
        }

        System.out.printf("Sum: " + sum +  " Max: " + max);
    }

    static void boundaryDiag() {
        System.out.print("Boundary: ");
        for (int j = 0; j < cols; j++) System.out.print(grid[0][j] + " ");
        for (int i = 1; i < rows - 1; i++) System.out.print(grid[i][cols - 1] + " ");
        if (rows > 1) for (int j = cols - 1; j >= 0; j--) System.out.print(grid[rows - 1][j] + " ");
        if (cols > 1) for (int i = rows - 2; i > 0; i--) System.out.print(grid[i][0] + " ");

        System.out.print("Main Diagonal: ");
        int size = Math.min(rows, cols);
        for (int i = 0; i < size; i++) System.out.print(grid[i][i] + " ");

        System.out.print("Secondary Diagonal: ");
        for (int i = 0; i < size; i++) System.out.print(grid[i][cols - 1 - i] + " ");

        System.out.println();
    }

    static void checkDuplicates() {
        boolean duplicates = false;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                for(int k=j+1; k<cols; k++) {
                    if(grid[i][j] == grid[i][k]) {
                        duplicates = true;
                        break;
                    }
                }
                if(duplicates) break;
            }
            if(duplicates) break;
        }

        if (duplicates) System.out.println("duplicates found"); else System.out.println("no duplicates");
    }
}
