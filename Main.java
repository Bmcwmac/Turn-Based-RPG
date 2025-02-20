import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize Scanner here
        
        
        // Prompt user for a filename to save moves
        System.out.print("Enter the file name to save the moves (e.g., moves.txt): ");
        String fileName = scanner.nextLine();
        Tables.saveMovesToFile(fileName); // Save moves to the specified file

        // Load the moves from the specified file
        System.out.println("\nLoading the moves from the file...");
        ArrayList<String[]> loadedMoves = Tables.loadMovesFromFile(fileName);
        
        // Display the loaded moves
        System.out.println("\nLoaded Moves:");
        for (String[] move : loadedMoves) {
            System.out.println(Arrays.toString(move)); // Print each move's details
        }
        GameLogic.startGame();
        scanner.close(); // Close the scanner to free up resources

        
        //GameLogic.test();
        //GameLogic.battle();
    }
}

//Where all classes are run (Only use of this class)