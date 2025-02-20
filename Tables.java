import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Tables {
    public static ArrayList<String[]> createMoveList() {
        ArrayList<String[]> moves = new ArrayList<>();
        // moves.add(new String[]{"Backstab", "A quick strike from behind", "40", "A",
        // "1"}); // separate the string and the ints. move names are defined move
        // values are randomised.
        moves.add(new String[] { "Quick Stab", "A fast lunge forward", "35", "A", "2" });
        moves.add(new String[] { "Smoke Bomb", "Distracts the enemy", "0", "A", "3" });
        moves.add(new String[] { "Cunning Strike", "A clever attack", "50", "A", "1" });

        moves.add(new String[] { "Shield Bash", "Bash the enemy with your shield", "15", "K", "2" });
        moves.add(new String[] { "Sword Slash", "A strong slash with your sword", "25", "K", "1" });
        moves.add(new String[] { "Defensive Stance", "Increase defence for one turn", "0", "K", "3" });

        moves.add(new String[] { "Shield Bash", "Bash the enemy with your shield", "25", "W", "2" });
        moves.add(new String[] { "Sword Slash", "A strong slash with your sword", "35", "W", "1" });
        moves.add(new String[] { "Armour Buff", "Increase defence for one turn", "0", "W", "3" });

        moves.add(new String[] { "Protective Bubble", "Forms a protective dome", "0", "G", "3" });
        moves.add(new String[] { "Electic Zap", "Shoots a small bolt of lightning", "15", "G", "2" });
        moves.add(new String[] { "Fire Ball", "Shoots a FIRE BALL!", "25", "G", "1" });

        moves.add(new String[] { "Fire Ball", "Shoots a FIRE BALL!", "80", "T", "1" });
        moves.add(new String[] { "Electic zap", "Shoots a small bolt of lightning", "10", "T", "2" });
        moves.add(new String[] { "Protective Bubble", "Forms a protective dome", "0", "T", "3" });
        
        return moves;
    }
  // Method to save moves to a file
  public static void saveMovesToFile(String filename) {
    ArrayList<String[]> moves = createMoveList();
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        for (String[] move : moves) {
            writer.write(String.join(",", move)); // Join move details with commas
            writer.newLine(); // Add a new line for the next move
        }
        System.out.println("Moves saved to " + filename);
    } catch (IOException e) {
        System.out.println("An error occurred while saving moves: " + e.getMessage());
    }
}

// Method to load moves from a file
public static ArrayList<String[]> loadMovesFromFile(String filename) {
    ArrayList<String[]> moves = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            moves.add(line.split(",")); // Split line by commas
        }
        System.out.println("Moves loaded from " + filename);
    } catch (IOException e) {
        System.out.println("An error occurred while loading moves: " + e.getMessage());
    }
    return moves;
}



    public static void preBattleTable(int playerAsking){
        String bigAlignmentFormat = "| %12s | %-6s | %-7s | %-8s | %-7s |::| %18s | %6s |%n";
            String titleAlignmentFormat = "|                                   %-10.10s                                          |%n";
            if (playerAsking == 1) {

                System.out.printf("+---------------------------------------------------------------------------------------+%n");
                System.out.printf(titleAlignmentFormat, GameLogic.player1Name); // change this to player name
                System.out.printf("+--------------+--------+---------+----------+---------+--+--------------------+--------+%n");

                System.out.printf(bigAlignmentFormat, "Character", "Health", "Defence", "Strength", "Stamina", "   Move Name", "Damage");
                System.out.printf("+--------------+--------+---------+----------+---------+--+--------------------+--------+%n");
                System.out.printf(bigAlignmentFormat, "", "", "", "", "", GameLogic.one.move1Name, GameLogic.one.move1DamageOriginal);
                System.out.printf(bigAlignmentFormat, GameLogic.one.type, GameLogic.one.health, GameLogic.one.defence, GameLogic.one.strength, GameLogic.one.stamina, GameLogic.one.move2Name, GameLogic.one.move2DamageOriginal);
                System.out.printf(bigAlignmentFormat, "", "", "", "", "", GameLogic.one.move3Name, GameLogic.one.move3DamageReduction);
                System.out.printf("+--------------+--------+---------+----------+---------+--+--------------------+--------+%n");
                System.out.printf(bigAlignmentFormat, "", "", "", "", "", GameLogic.two.move1Name, GameLogic.two.move1DamageOriginal);
                System.out.printf(bigAlignmentFormat, GameLogic.two.type, GameLogic.two.health, GameLogic.two.defence, GameLogic.two.strength, GameLogic.two.stamina, GameLogic.two.move2Name, GameLogic.two.move2DamageOriginal);
                System.out.printf(bigAlignmentFormat, "", "", "", "", "", GameLogic.two.move3Name, GameLogic.two.move3DamageReduction);
                System.out.printf("+--------------+--------+---------+----------+---------+--+--------------------+--------+%n");
                System.out.printf(bigAlignmentFormat, "", "", "", "", "", GameLogic.three.move1Name, GameLogic.three.move1DamageOriginal);
                System.out.printf(bigAlignmentFormat, GameLogic.three.type, GameLogic.three.health, GameLogic.three.defence, GameLogic.three.strength, GameLogic.three.stamina, GameLogic.three.move2Name, GameLogic.three.move2DamageOriginal);
                System.out.printf(bigAlignmentFormat, "", "", "", "", "", GameLogic.three.move3Name, GameLogic.three.move3DamageReduction);
                System.out.printf("+--------------+--------+---------+----------+---------+--+--------------------+--------+%n");

            }
            if (playerAsking == 2) {

                System.out.printf("+---------------------------------------------------------------------------------------+%n");
                System.out.printf(titleAlignmentFormat, GameLogic.player2Name); // change this to player name
                System.out.printf("+--------------+--------+---------+----------+---------+--+--------------------+--------+%n");

                System.out.printf(bigAlignmentFormat, "Character", "Health", "Defence", "Strength", "Stamina", "   Move Name", "Damage");
                System.out.printf("+--------------+--------+---------+----------+---------+--+--------------------+--------+%n");
                System.out.printf(bigAlignmentFormat, "", "", "", "", "", GameLogic.four.move1Name, GameLogic.four.move1DamageOriginal);
                System.out.printf(bigAlignmentFormat, GameLogic.four.type, GameLogic.four.health, GameLogic.four.defence, GameLogic.four.strength, GameLogic.four.stamina, GameLogic.four.move2Name, GameLogic.four.move2DamageOriginal);
                System.out.printf(bigAlignmentFormat, "", "", "", "", "", GameLogic.four.move3Name, GameLogic.four.move3DamageReduction);
                System.out.printf("+--------------+--------+---------+----------+---------+--+--------------------+--------+%n");
                System.out.printf(bigAlignmentFormat, "", "", "", "", "", GameLogic.five.move1Name, GameLogic.five.move1DamageOriginal);
                System.out.printf(bigAlignmentFormat, GameLogic.five.type, GameLogic.five.health, GameLogic.five.defence, GameLogic.five.strength, GameLogic.five.stamina, GameLogic.five.move2Name, GameLogic.five.move2DamageOriginal);
                System.out.printf(bigAlignmentFormat, "", "", "", "", "", GameLogic.five.move3Name, GameLogic.five.move3DamageReduction);
                System.out.printf("+--------------+--------+---------+----------+---------+--+--------------------+--------+%n");
                System.out.printf(bigAlignmentFormat, "", "", "", "", "", GameLogic.six.move1Name, GameLogic.six.move1DamageOriginal);
                System.out.printf(bigAlignmentFormat, GameLogic.six.type, GameLogic.six.health, GameLogic.six.defence, GameLogic.six.strength, GameLogic.six.stamina, GameLogic.six.move2Name, GameLogic.six.move2DamageOriginal);
                System.out.printf(bigAlignmentFormat, "", "", "", "", "", GameLogic.six.move3Name, GameLogic.six.move3DamageReduction);
                System.out.printf("+--------------+--------+---------+----------+---------+--+--------------------+--------+%n");
            }
    }
    public static void battleTable(int playerAsking){
        String alignmentFormat = "| %-14s | %-12s |          | %-14s | %-12s |%n";
            String bottomAlignmentFormat = "| %-14s | %-12s |          +----------------+--------------+%n";
            if (playerAsking == 1) {

                System.out.printf("+----------------+--------------+          +----------------+--------------+%n");
                System.out.printf(alignmentFormat, GameLogic.player1Name, GameLogic.p1Active.type, GameLogic.player2Name, GameLogic.p2Active.type);
                System.out.printf("+----------------+--------------+          +----------------+--------------+%n");
                System.out.printf(alignmentFormat, "Health", GameLogic.p1Active.health, "Health", GameLogic.p2Active.health);
                System.out.printf(alignmentFormat, "Status", GameLogic.p1Active.status, "Status", GameLogic.p2Active.status);
                System.out.printf(bottomAlignmentFormat, "Stamina", GameLogic.p1Active.stamina);
                System.out.printf("+----------------+--------------+%n");

                // under here put a line separator then in the battle() the options will be displayed under the previously mentioned separator
            }

            if (playerAsking == 2) {

                System.out.printf("+----------------+--------------+          +----------------+--------------+%n");
                System.out.printf(alignmentFormat, GameLogic.player2Name, GameLogic.p2Active.type, GameLogic.player1Name, GameLogic.p1Active.type);
                System.out.printf("+----------------+--------------+          +----------------+--------------+%n");
                System.out.printf(alignmentFormat, "Health", GameLogic.p2Active.health, "Health", GameLogic.p1Active.health);
                System.out.printf(alignmentFormat, "Status", GameLogic.p2Active.status, "Status", GameLogic.p1Active.status);
                System.out.printf(bottomAlignmentFormat, "Stamina", GameLogic.p2Active.stamina);
                System.out.printf("+----------------+--------------+%n");
            }
    }
    public static void actionSelectionTable(int playerAsking){
        String actionSelectionAlignmentFormat = "| %-14s |%n";
            if (playerAsking == 1) {
                System.out.printf("+--------------------+%n");
                System.out.printf(actionSelectionAlignmentFormat, "(1) Combat        ");
                System.out.printf(actionSelectionAlignmentFormat, "(2) Character Info");
                System.out.printf(actionSelectionAlignmentFormat, "(3) Character Swap");
                System.out.printf("+--------------------+%n");
            }
            if (playerAsking == 2) {
                System.out.printf("+--------------------+%n");
                System.out.printf(actionSelectionAlignmentFormat, "(1) Combat        ");
                System.out.printf(actionSelectionAlignmentFormat, "(2) Character Info");
                System.out.printf(actionSelectionAlignmentFormat, "(3) Character Swap");
                System.out.printf("+--------------------+%n");
            }
    }


    public static void moveTable(int playerAsking){
        String moveSelectionAlignmentFormat = "| %18s |::| %-5s | %17s | %-6s |%n";
            String topSelectionAlignmentFormat = " %18s  |::| %-5s | %-17s | %-6s |%n";
            String bottomSelectionAlignmentFormat = "%23s | %-34s |%n";

            if (playerAsking == 1) {

                System.out.printf("                     +--+-------+-------------------+--------+%n");
                System.out.printf(topSelectionAlignmentFormat, "", "INPUT", "Move Name", "Damage");
                System.out.printf("+--------------------+--+-------+-------------------+--------+%n");
                System.out.printf(moveSelectionAlignmentFormat, "Move", "(1)", GameLogic.p1Active.move1Name, GameLogic.p1Active.move1DamageOriginal);
                System.out.printf(moveSelectionAlignmentFormat, "", "(2)", GameLogic.p1Active.move2Name, GameLogic.p1Active.move2DamageOriginal);
                System.out.printf(moveSelectionAlignmentFormat, "", "(3)", GameLogic.p1Active.move3Name, GameLogic.p1Active.move3DamageReduction);
                System.out.printf("+--------------------+--+-------+-------------------+--------+%n");
                System.out.printf(bottomSelectionAlignmentFormat, "", "(4) Return");
                System.out.printf("                        +-------+-------------------+--------+%n");
            }
            if (playerAsking == 2) {

                System.out.printf("                     +--+-------+-------------------+--------+%n");
                System.out.printf(topSelectionAlignmentFormat, "", "INPUT", "Move Name", "Damage");
                System.out.printf("+--------------------+--+-------+-------------------+--------+%n");
                System.out.printf(moveSelectionAlignmentFormat, "Move", "(1)", GameLogic.p2Active.move1Name, GameLogic.p2Active.move1DamageOriginal);
                System.out.printf(moveSelectionAlignmentFormat, "", "(2)", GameLogic.p2Active.move2Name, GameLogic.p2Active.move2DamageOriginal);
                System.out.printf(moveSelectionAlignmentFormat, "", "(3)", GameLogic.p2Active.move3Name, GameLogic.p2Active.move3DamageReduction);
                System.out.printf("+--------------------+--+-------+-------------------+--------+%n");
                System.out.printf(bottomSelectionAlignmentFormat, "", "(4) Return");
                System.out.printf("                        +-------+-------------------+--------+%n");
            }
    }
    public static void infoTable(int playerAsking) {
        String infoAlignmentFormat = "|%18s  |::| %20s | %-18s%n";
        String topInfoAlignmentFormat = " %19s |::| %20s | %-62s%n";
        String bottomInfoAlignmentFormat = "%23s | %-43s |%n";
        if (playerAsking == 1) {

            System.out.printf("                     +--+----------------------+------------------------------%n");
            System.out.printf(topInfoAlignmentFormat, "", "STATS", "Move Info");
            System.out.printf("+--------------------+--+----------------------+------------------------------%n");
            System.out.printf(infoAlignmentFormat, "Character Info", "Type :>: " + GameLogic.p1Active.type, GameLogic.p1Active.move1Name + " || " + GameLogic.p1Active.move1Info);
            System.out.printf(infoAlignmentFormat, "", "Status :>: " + GameLogic.p1Active.status, GameLogic.p1Active.move2Name + " || " + GameLogic.p1Active.move2Info);
            System.out.printf(infoAlignmentFormat, "", "", "", GameLogic.p1Active.move3Name + " || " + GameLogic.p1Active.move3Info);
            System.out.printf("+--------------------+--+----------------------+------------------------------%n");
        }
        if (playerAsking == 2) {

            System.out.printf("                     +--+----------------------+------------------------------%n");
            System.out.printf(topInfoAlignmentFormat, "", "STATS", "Move Info");
            System.out.printf("+--------------------+--+----------------------+------------------------------%n");
            System.out.printf(infoAlignmentFormat, "Character Info", "Type :>: " + GameLogic.p2Active.type, GameLogic.p2Active.move1Name + " || " + GameLogic.p2Active.move1Info);
            System.out.printf(infoAlignmentFormat, "", "Status :>: " + GameLogic.p2Active.status, GameLogic.p2Active.move2Name + " || " + GameLogic.p2Active.move2Info);
            System.out.printf(infoAlignmentFormat, "", "", "", GameLogic.p2Active.move3Name + " || " + GameLogic.p2Active.move3Info);
            System.out.printf("+--------------------+--+----------------------+------------------------------%n");
        }
    }

    public static void swapTable(int playerAsking){
        String swapAlignmentFormat = "| %18s |::| %-5s | %-12s | %-8s | %-9s |%n";
        String topSwapAlignmentFormat = " %18s  |::| %-5s | %-12s | %-8s | %-9s |%n";
        String bottomSwapAlignmentFormat = "%23s | %-43s |%n";
        if (playerAsking == 1) {
            System.out.printf("                     +--+-------+--------------+----------+-----------+%n");
            System.out.printf(topSwapAlignmentFormat, "", "INPUT", "Type", "Health", "Status");
            System.out.printf("+--------------------+--+-------+--------------+----------+-----------+%n");

            if (GameLogic.sub11.health > 0 && GameLogic.sub12.health <= 0) {
                System.out.printf(swapAlignmentFormat, "Chararcter Swap", "(1)", GameLogic.sub11.type, GameLogic.sub11.health, GameLogic.sub11.status);
                System.out.printf(swapAlignmentFormat, "", "", "", "", "");
                System.out.printf(swapAlignmentFormat, "", "", "", "", "");
                System.out.printf("+--------------------+--+-------+--------------+----------+-----------+%n");
                System.out.printf(bottomSwapAlignmentFormat, "", "(2) Return");
                System.out.printf("                        +---------------------------------------------+%n");
            } else if (GameLogic.sub11.health <= 0 && GameLogic.sub12.health > 0) {
                System.out.printf(swapAlignmentFormat, "Chararcter Swap", "(1)", GameLogic.sub12.type, GameLogic.sub12.health, GameLogic.sub12.status);
                System.out.printf(swapAlignmentFormat, "", "", "", "", "");
                System.out.printf(swapAlignmentFormat, "", "", "", "", "");
                System.out.printf("+--------------------+--+-------+--------------+----------+-----------+%n");
                System.out.printf(bottomSwapAlignmentFormat, "", "(2) Return");
                System.out.printf("                        +---------------------------------------------+%n");
            } else {
                System.out.printf(swapAlignmentFormat, "Chararcter Swap", "(1)", GameLogic.sub11.type, GameLogic.sub11.health, GameLogic.sub11.status);
                System.out.printf(swapAlignmentFormat, "", "(2)", GameLogic.sub12.type, GameLogic.sub12.health, GameLogic.sub12.status);
                System.out.printf(swapAlignmentFormat, "", "", "", "", "");
                System.out.printf("+--------------------+--+-------+--------------+----------+-----------+%n");
                System.out.printf(bottomSwapAlignmentFormat, "", "(3) Return");
                System.out.printf("                        +---------------------------------------------+%n");
            }

        }
        if (playerAsking == 2) {
            System.out.printf("                     +--+-------+--------------+----------+-----------+%n");
            System.out.printf(topSwapAlignmentFormat, "", "INPUT", "Type", "Health", "Status");
            System.out.printf("+--------------------+--+-------+--------------+----------+-----------+%n");
            if (GameLogic.sub21.health > 0 && GameLogic.sub22.health <= 0) {
                System.out.printf(swapAlignmentFormat, "Chararcter Swap", "(1)", GameLogic.sub21.type, GameLogic.sub11.health, GameLogic.sub21.status);
                System.out.printf(swapAlignmentFormat, "", "", "", "", "");
                System.out.printf(swapAlignmentFormat, "", "", "", "", "");
                System.out.printf("+--------------------+--+-------+--------------+----------+-----------+%n");
                System.out.printf(bottomSwapAlignmentFormat, "", "(2) Return");
                System.out.printf("                        +---------------------------------------------+%n");
            } else if (GameLogic.sub21.health <= 0 && GameLogic.sub22.health > 0) {
                System.out.printf(swapAlignmentFormat, "Chararcter Swap", "(1)", GameLogic.sub22.type, GameLogic.sub22.health, GameLogic.sub22.status);
                System.out.printf(swapAlignmentFormat, "", "", "", "", "");
                System.out.printf(swapAlignmentFormat, "", "", "", "", "");
                System.out.printf("+--------------------+--+-------+--------------+----------+-----------+%n");
                System.out.printf(bottomSwapAlignmentFormat, "", "(2) Return");
                System.out.printf("                        +---------------------------------------------+%n");
            } else {
                System.out.printf(swapAlignmentFormat, "Chararcter Swap", "(1)", GameLogic.sub21.type, GameLogic.sub21.health, GameLogic.sub21.status);
                System.out.printf(swapAlignmentFormat, "", "(2)", GameLogic.sub22.type, GameLogic.sub22.health, GameLogic.sub22.status);
                System.out.printf(swapAlignmentFormat, "", "", "", "", "");
                System.out.printf("+--------------------+--+-------+--------------+----------+-----------+%n");
                System.out.printf(bottomSwapAlignmentFormat, "", "(3) Return");
                System.out.printf("                        +---------------------------------------------+%n");
            }
        }
    }
}