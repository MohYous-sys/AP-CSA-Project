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
                case 1:  break;
                case 2:  break;
                case 3:  break;
                case 4:  break;
                case 5:  break;
                case 6:  break;
                case 7:  break;
                case 8:  break;
                case 9:  break;
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
}
