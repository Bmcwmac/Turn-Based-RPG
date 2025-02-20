
import java.util.*;

public class GameLogic {

    static Scanner scan = new Scanner(System.in);

    public static int count = 1;
    public static int roundNumber = 1;
    public static String gameStatus = "";
    public static String player1Name = "Player 1";
    public static String player2Name = "Player 2";
    public static boolean playersPassed = false;

    static Character one = new character1();
    static Character two = new character1();
    static Character three = new character1();
    static Character four = new character1();
    static Character five = new character1();
    static Character six = new character1();

    public static Character p1Active = one, p2Active = four;
    public static Character sub11 = two, sub12 = three, sub21 = five, sub22 = six;

    // This will be used to control the inputs
    public static int scanBrain(String prompt, int choiceAmount) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scan.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Try again");
            }
        } while (input < 1 || input > choiceAmount);
        return input;
    }

    public static void cleanConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void checkParticipation(String prompt) {
        Scanner temp = new Scanner(System.in);
        System.out.println(prompt);
        String cheese = temp.nextLine(); // Funny name am i right || String cheese :D
        if (cheese.isEmpty()); // you don't need to enter anything now 
    }

    public static void printSeparator(char thing) {
        System.out.println();
        for (int i = 0; i < 100; i++) {
            System.out.print(thing);
        }
        System.out.println();
    }

    public static void swap(int playerAsking, int swapTo) {
        if (playerAsking == 1) {
            if (swapTo == 1) {
                p1Active = sub11;
            } else if (swapTo == 2) {
                p1Active = sub12;
            }

        }
        if (playerAsking == 2) {
            if (swapTo == 1) {
                p2Active = sub21;
            } else if (swapTo == 2) {
                p2Active = sub22;
            }
        }
        subAllocation();
    }

    public static void playerStatPrintOut(int playerAsking, String gameStatus) {

        // Only time when the player can see all the character stats at once is when
        // gameStatus == swap or preBattle
        // if gameStatus != swap or preBattle then player can only view the stat for
        // character that is active
        // should add another toString or printTable for only critical stats so
        // playerStatPrintOut is just the primary stat printout
        if (gameStatus.equals("preBattle")) {
            Tables.preBattleTable(playerAsking);
        }

        if (gameStatus.equals("Battle")) {
            Tables.battleTable(playerAsking);
        }

        if (gameStatus.equals("Action Selection")) {
            Tables.actionSelectionTable(playerAsking);
        }

        if (gameStatus.equals("Move")) {
            Tables.moveTable(playerAsking);
        }

        if (gameStatus.equals("Swap")) {
            Tables.swapTable(playerAsking);
        }

        if (gameStatus.equals("Info")) {
            Tables.infoTable(playerAsking);
        }

    }

    public static void startGame() {
        introText();
    }

    public static void introText() {
        cleanConsole();
        System.out.println("Welcome Travellers how lovely to see... Oh its you two scoundrels");
        System.out.println("What were your names again?");
        player1Name = scan.next();
        System.out.println("Player 1 your name is: " + player1Name);

        checkParticipation("I don't care if thats correct. Thats what your name is now\n...I need you to acknowledge");

        System.out.println("Player 2 what was your name?");
        player2Name = scan.next();
        checkParticipation(
                "Whether thats right or not I don't care.\n \nIf you guys are here to ask people to fight for you the guys over there might do it for the right price. Now scram.");
        characterSelectionSetObject();
    }

    public static void characterSelectionSetObject() {
        if (count == 1) {
            characterSelection(one);
        }
        if (count == 2) {
            characterSelection(two);
        }
        if (count == 3) {
            characterSelection(three);
        }
        if (count == 4) {
            characterSelection(four);
        }
        if (count == 5) {
            characterSelection(five);
        }
        if (count == 6) {
            characterSelection(six);
        }
    }

    public static void subAllocation() {
        ArrayList<Character> subsPlayer1 = new ArrayList<>();
        ArrayList<Character> subsPlayer2 = new ArrayList<>();
        ArrayList<Character> charactersPlayer1 = new ArrayList<>();
        ArrayList<Character> charactersPlayer2 = new ArrayList<>();

        subsPlayer1.clear();
        subsPlayer2.clear();

        charactersPlayer1.clear();
        charactersPlayer1.add(one);
        charactersPlayer1.add(two);
        charactersPlayer1.add(three);

        charactersPlayer2.clear();
        charactersPlayer2.add(four);
        charactersPlayer2.add(five);
        charactersPlayer2.add(six);

        if (p1Active.type == one.type && p1Active.health == one.health) {
            one.hiddenStatus = "Active";
            two.hiddenStatus = "Sleeping";
            three.hiddenStatus = "Sleeping";
        }
        if (p1Active.type == two.type && p1Active.health == two.health) {
            one.hiddenStatus = "Sleeping";
            two.hiddenStatus = "Active";
            three.hiddenStatus = "Sleeping";
        }
        if (p1Active.type == three.type && p1Active.health == three.health) {
            one.hiddenStatus = "Sleeping";
            two.hiddenStatus = "Sleeping";
            three.hiddenStatus = "Active";
        }
        if (p2Active.type == four.type && p2Active.health == four.health) {
            four.hiddenStatus = "Active";
            five.hiddenStatus = "Sleeping";
            six.hiddenStatus = "Sleeping";
        }
        if (p2Active.type == five.type && p2Active.health == five.health) {
            four.hiddenStatus = "Sleeping";
            five.hiddenStatus = "Active";
            six.hiddenStatus = "Sleeping";
        }
        if (p2Active.type == six.type && p2Active.health == six.health) {
            four.hiddenStatus = "Sleeping";
            five.hiddenStatus = "Sleeping";
            six.hiddenStatus = "Active";
        }

        for (int i = 0; i <= charactersPlayer1.size() - 1; i++) {
            if (charactersPlayer1.get(i).hiddenStatus.equals("Sleeping")) {
                subsPlayer1.add(charactersPlayer1.get(i));
            } else {
                p1Active = charactersPlayer1.get(i);
            }
        }
        for (int i = 0; i <= charactersPlayer2.size() - 1; i++) {
            if (charactersPlayer2.get(i).hiddenStatus.equals("Sleeping")) {
                subsPlayer2.add(charactersPlayer2.get(i));
            } else {
                p2Active = charactersPlayer2.get(i);
            }
        }

        sub11 = subsPlayer1.get(0);
        sub12 = subsPlayer1.get(1);
        sub21 = subsPlayer2.get(0);
        sub22 = subsPlayer2.get(1);

    }

    public static void characterSelection(Character Active) {
        if (count > 3) {
            System.out.println(player2Name + " Select Your Characters!");
        } else {
            System.out.println(player1Name + " Select Your Characters!");
        }

        System.out.println("(1) Assassin\n(2) Knight\n(3) Warrior\n(4) Generalist\n(5) Theurgist");
        int input1 = scanBrain("-> ", 5);

        if (input1 == 1) {
            Active.setHealth(125, 100); // low values
            Active.setDefence(10, 0); // low values
            Active.setStrength(30, 20); // mid values
            Active.setStamina(150); // high values
            Active.setStatus("Healthy");
            Active.setType("Assassin");
            Active.randomizeMoves(Tables.createMoveList(), 3, "A", 1);
            cleanConsole();
            System.out.println("You chose Assassin!");
            checkParticipation("Enter something");
            cleanConsole();
            count++;

        }
        if (input1 == 2) {
            Active.setHealth(180, 160); // high values
            Active.setDefence(30, 20); // high values
            Active.setStrength(30, 20); // mid values
            Active.setStamina(50); // low values
            Active.setStatus("Healthy");
            Active.setType("Knight");
            Active.randomizeMoves(Tables.createMoveList(), 3, "K", 1);
            cleanConsole();
            System.out.println("You chose Knight!");
            checkParticipation("Enter something");
            cleanConsole();
            count++;

        }
        if (input1 == 3) {
            Active.setHealth(130, 150); // mid values
            Active.setDefence(20, 10); // mid values
            Active.setStrength(40, 30); // high values
            Active.setStamina(50); // low values
            Active.setStatus("Healthy");
            Active.setType("Warrior");
            Active.randomizeMoves(Tables.createMoveList(), 3, "W", 1);
            cleanConsole();
            System.out.println("You chose Warrior!");
            checkParticipation("Enter something");
            cleanConsole();
            count++;

        }
        if (input1 == 4) {
            Active.setHealth(180, 160); // high values
            Active.setDefence(30, 20); // high values
            Active.setStrength(20, 10); // low values
            Active.setStamina(100); // mid values
            Active.setStatus("Healthy");
            Active.setType("Generalist");
            Active.randomizeMoves(Tables.createMoveList(), 3, "G", 1);
            cleanConsole();
            System.out.println("You chose Generalist!");
            checkParticipation("Enter something");
            cleanConsole();
            count++;

        }
        if (input1 == 5) {
            Active.setHealth(150, 130); // mid values
            Active.setDefence(20, 10); // mid values
            Active.setStrength(40, 30); // high values
            Active.setStamina(50); // low values
            Active.setStatus("Healthy");
            Active.setType("Theurgist");
            Active.randomizeMoves(Tables.createMoveList(), 3, "T", 1);
            cleanConsole();
            System.out.println("You chose Theurgist!");
            checkParticipation("Enter something");
            cleanConsole();
            count++;
        }

        characterSelectionSetObject();

        if (count == 7) { // prebattle tables
            p1Active.hiddenStatus = "Active";
            p2Active.hiddenStatus = "Active";
            subAllocation();
            playerStatPrintOut(1, "preBattle");
            checkParticipation("Player 1 press Enter to ready up!");
            playerStatPrintOut(2, "preBattle");
            checkParticipation("Player 2 press Enter to ready up!");
            battle();
        }

    }

    public static void battle() { // battle
        count++;
        p1Active.setMove1DamageOverride(p2Active.defence, p2Active.move3DamageReduction, p1Active.move1DamageOriginal,
                p1Active.strength);
        p1Active.setMove2DamageOverride(p2Active.defence, p2Active.move3DamageReduction, p1Active.move2DamageOriginal,
                p1Active.strength);

        p2Active.setMove1DamageOverride(p1Active.defence, p1Active.move3DamageReduction, p2Active.move1DamageOriginal,
                p2Active.strength);
        p2Active.setMove2DamageOverride(p1Active.defence, p1Active.move3DamageReduction, p2Active.move1DamageOriginal,
                p2Active.strength);

        gameStatus = "Battle";

        boolean player1Alive = true;
        boolean player2Alive = true;

        // Sets substitute characters, information used in swap
        if (one.health <= 0 && two.health <= 0 && three.health <= 0) {
            player1Alive = false;
        } else {
            player1Alive = true;
        }

        if (four.health <= 0 && five.health <= 0 && six.health <= 0) {
            player2Alive = false;
        } else {
            player2Alive = true;
        }

        int p1Pathway = 0;
        int p2Pathway = 0;

        int p1PrimaryAction = 0;
        int p1SecondaryAction = 0;

        int p2PrimaryAction = 0;
        int p2SecondaryAction = 0;

        if (p1Active.stamina < 100 && p1Active.stamina > 50) {
            p1Active.status = "Healthy";
        }
        if (p1Active.stamina <= 50 && p1Active.stamina > 0) {
            p1Active.status = "Tired";
        }
        if (p1Active.stamina <= 0) {
            p1Active.status = "Exhausted";
        }

        if (p2Active.stamina < 100 && p2Active.stamina > 50) {
            p2Active.status = "Healthy";
        }
        if (p2Active.stamina <= 50 && p2Active.stamina > 0) {
            p2Active.status = "Tired";
        }
        if (p2Active.stamina <= 0) {
            p2Active.status = "Exhausted";
        }

        if (p1Active.health <= 0) {
            System.out.println("Your current characetr is dead! swap to one of your other characters!");
            playerStatPrintOut(1, gameStatus);
            printSeparator('=');
            playerStatPrintOut(1, "Swap");
            if ((sub11.health > 0 && sub12.health <= 0) || (sub11.health <= 0 && sub12.health > 0)) {
                int input12 = scanBrain("-> ", 1);
                switch (input12) {
                    case 1:
                        swap(1, 1);
                        break;
                }
            } else {
                int input121 = scanBrain("-> ", 2);
                switch (input121) {
                    case 1:
                        swap(1, 1);
                        break;
                    case 2:
                        swap(1, 2);
                        break;
                }
            }
        }

        cleanConsole();
        System.out.println("The Round is: " + roundNumber);
        playerStatPrintOut(1, gameStatus);
        printSeparator('=');
        playerStatPrintOut(1, "Action Selection");
        int input1 = scanBrain("-> ", 3);
        if (p1Active.stamina <= 0) {
            p1Pathway = 5;
        } else {
            p1Pathway = input1;
        }

        if (p1Pathway == 1) {
            p1PrimaryAction = 1;
            cleanConsole();
            System.out.println("The Round is: " + roundNumber);
            playerStatPrintOut(1, gameStatus);
            printSeparator('=');
            playerStatPrintOut(1, "Move");
            int input11 = scanBrain("-> ", 4);
            switch (input11) {
                case 1:
                    p1SecondaryAction = 1;
                    break;
                case 2:
                    p1SecondaryAction = 2;
                    break;
                case 3:
                    p1SecondaryAction = 3;
                    break;
                case 4:
                    p1Pathway = 4;
                    break;
            }

        }
        if (p1Pathway == 2) {
            cleanConsole();
            System.out.println("The Round is: " + roundNumber);
            playerStatPrintOut(1, gameStatus);
            printSeparator('=');
            playerStatPrintOut(1, "Info");
            checkParticipation("Enter to return");
            p1Pathway = 4;
        }
        if (p1Pathway == 3) {
            p1PrimaryAction = 3;
            System.out.println("The Round is: " + roundNumber);
            playerStatPrintOut(1, gameStatus);
            printSeparator('=');
            playerStatPrintOut(1, "Swap");
            if ((sub11.health > 0 && sub12.health <= 0) || (sub11.health <= 0 && sub12.health > 0)) {
                int input12 = scanBrain("-> ", 2);
                switch (input12) {
                    case 1:
                        p1SecondaryAction = 1;
                        break;
                    case 2:
                        p1Pathway = 4;
                        break;
                }
            } else {
                int input121 = scanBrain("-> ", 3);
                switch (input121) {
                    case 1:
                        p1SecondaryAction = 1;
                        break;
                    case 2:
                        p1SecondaryAction = 2;
                        break;
                    case 3:
                        p1Pathway = 4;
                        break;
                }
            }
        }
        if (p1Pathway == 4) {
            cleanConsole();
            System.out.println("The Round is: " + roundNumber);
            playerStatPrintOut(1, gameStatus);
            printSeparator('=');
            playerStatPrintOut(1, "Action Selection");
            int input14 = scanBrain("IM LOSING MY PATIENCE WITH YOU...\nFine make your choice!\n->", 3);
            if (input14 == 1) {
                cleanConsole();
                System.out.println("The Round is: " + roundNumber);
                playerStatPrintOut(1, gameStatus);
                printSeparator('=');
                playerStatPrintOut(1, "Move");
                int input141 = scanBrain("-> ", 4);
                switch (input141) {
                    case 1:
                        p1PrimaryAction = 1;
                        p1SecondaryAction = 1;
                        break;
                    case 2:
                        p1PrimaryAction = 1;
                        p1SecondaryAction = 2;
                        break;
                    case 3:
                        p1PrimaryAction = 1;
                        p1SecondaryAction = 3;
                        break;
                    case 4:
                        System.out.println(
                                "No! You can have no turn now. " + player2Name + " will show you how its done.");
                        p1PrimaryAction = 0;
                        break;
                }
            } else if (input14 == 2) {
                cleanConsole();
                System.out.println("The Round is: " + roundNumber);
                playerStatPrintOut(1, gameStatus);
                printSeparator('=');
                p1Active.status = "Indecisive";
                playerStatPrintOut(1, "Info");
                p1Active.status = "Healthy";
                System.out.println("You have a bad memory " + player1Name + "! Maybe " + player2Name + "'s "
                        + p1Active.type + " can knock some brains into ya aye?");
                checkParticipation("You can press anything to hopefully see how its done");
                p1PrimaryAction = 0;

            } else if (input14 == 3) {
                p1PrimaryAction = 3;
                cleanConsole();
                System.out.println("The Round is: " + roundNumber);
                playerStatPrintOut(1, gameStatus);
                printSeparator('=');
                playerStatPrintOut(1, "Swap");
                if ((sub11.health > 0 && sub12.health <= 0) || (sub11.health <= 0 && sub12.health > 0)) {
                    int input141 = scanBrain("-> ", 2);
                    switch (input141) {
                        case 1:
                            p1SecondaryAction = 1;
                            break;
                        case 2:
                            p1PrimaryAction = 0;
                            System.out.println("I give up. I'm skipping your turn");
                            break;
                    }
                } else {
                    int input121 = scanBrain("-> ", 3);
                    switch (input121) {
                        case 1:
                            p1SecondaryAction = 1;
                            break;
                        case 2:
                            p1SecondaryAction = 2;
                            break;
                        case 3:
                            p1PrimaryAction = 0;
                            System.out.println("I give up. I'm skipping your turn");
                            break;
                    }
                }
            }

        }
        if (p1Pathway == 5) {
            p1PrimaryAction = 4;
            System.out.println(
                    "Looks like you exhausted your " + p1Active.type + " now they need a nap and you lost your turn!");
            checkParticipation("Let's see if " + player2Name + " can do better.");
        }

        printSeparator('=');
        System.out.println("I don't know what " + player1Name + " is cooking up over there but its your turn to respond!");
        checkParticipation("You ready " + player2Name + "?");

        if (p2Active.health <= 0) {
            System.out.println("Your current characetr is dead! swap to one of your other characters!");
            playerStatPrintOut(2, gameStatus);
            printSeparator('=');
            playerStatPrintOut(2, "Swap");
            if ((sub21.health > 0 && sub22.health <= 0) || (sub21.health <= 0 && sub22.health > 0)) {
                int input22 = scanBrain("-> ", 1);
                switch (input22) {
                    case 1:
                        swap(2, 1);
                        break;
                }
            } else {
                int input221 = scanBrain("-> ", 2);
                switch (input221) {
                    case 1:
                        swap(2, 1);
                        break;
                    case 2:
                        swap(2, 2);
                        break;
                }
            }
        }

        cleanConsole();
        System.out.println("The Round is: " + roundNumber);
        playerStatPrintOut(2, gameStatus);
        printSeparator('=');
        playerStatPrintOut(2, "Action Selection");
        int input2 = scanBrain("-> ", 3);
        if (p2Active.stamina <= 0) {
            p2Pathway = 5;
        } else {
            p2Pathway = input2;
        }
        if (p2Pathway == 1) {
            cleanConsole();
            System.out.println("The Round is: " + roundNumber);
            playerStatPrintOut(2, gameStatus);
            printSeparator('=');
            playerStatPrintOut(2, "Move");
            int input21 = scanBrain("-> ", 4);
            switch (input21) {
                case 1:
                    p2PrimaryAction = 1;
                    p2SecondaryAction = 1;
                    break;
                case 2:
                    p2PrimaryAction = 1;
                    p2SecondaryAction = 2;
                    break;
                case 3:
                    p2PrimaryAction = 1;
                    p2SecondaryAction = 3;
                    break;
                case 4:
                    p2Pathway = 4;
                    break;
            }

        } else if (p2Pathway == 2) {
            cleanConsole();
            System.out.println("The Round is: " + roundNumber);
            playerStatPrintOut(1, gameStatus);
            printSeparator('=');
            playerStatPrintOut(2, "Info");
            checkParticipation("Enter to return");
            p2Pathway = 4;

        } else if (p2Pathway == 3) {
            p2PrimaryAction = 3;
            cleanConsole();
            System.out.println("The Round is: " + roundNumber);
            playerStatPrintOut(2, gameStatus);
            printSeparator('=');
            playerStatPrintOut(2, "Swap");
            if ((sub11.health > 0 && sub12.health <= 0) || (sub11.health <= 0 && sub12.health > 0)) {
                int input23 = scanBrain("-> ", 2);
                switch (input23) {
                    case 1:
                        p2SecondaryAction = 1;
                        break;
                    case 2:
                        p2Pathway = 4;
                        break;
                }
            } else {
                int input231 = scanBrain("-> ", 3);
                switch (input231) {
                    case 1:
                        p2SecondaryAction = 1;
                        break;
                    case 2:
                        p2SecondaryAction = 2;
                        break;
                    case 3:
                        p2Pathway = 4;
                        break;
                }
            }
        }
        if (p2Pathway == 4) {
            cleanConsole();
            System.out.println("The Round is: " + roundNumber);
            playerStatPrintOut(2, gameStatus);
            printSeparator('=');
            playerStatPrintOut(2, "Action Selection");
            int input24 = scanBrain("IM LOSING MY PATIENCE WITH YOU " + player2Name + "\nFine make your choice!\n->",
                    3);
            if (input24 == 1) {
                p2PrimaryAction = 1;
                cleanConsole();
                System.out.println("The Round is: " + roundNumber);
                playerStatPrintOut(2, gameStatus);
                printSeparator('=');
                playerStatPrintOut(2, "Move");
                int input241 = scanBrain("-> ", 4);
                switch (input241) {
                    case 1:
                        p2SecondaryAction = 1;
                        break;
                    case 2:
                        p2SecondaryAction = 2;
                        break;
                    case 3:
                        p2SecondaryAction = 3;
                        break;
                    case 4:
                        System.out.println(
                                "No! You can have no turn now. " + player1Name + " will show you how its done.");
                        checkParticipation("Enter something to continue");
                        p2PrimaryAction = 0;
                        break;
                }
            } else if (input24 == 2) {
                cleanConsole();
                System.out.println("The Round is: " + roundNumber);
                playerStatPrintOut(2, gameStatus);
                printSeparator('=');
                p1Active.status = "Indecisive";
                playerStatPrintOut(2, "Info");
                p1Active.status = "Healthy";
                System.out.println("You have a bad memory " + player2Name + "! Hopefully " + player1Name
                        + " will show you how its done!");
                checkParticipation("Press anything to get your forgetfull behind to the next turn");
                p2PrimaryAction = 0;

            } else if (input24 == 3) {
                p2PrimaryAction = 3;
                cleanConsole();
                System.out.println("The Round is: " + roundNumber);
                playerStatPrintOut(2, gameStatus);
                printSeparator('=');
                playerStatPrintOut(2, "Swap");
                if ((sub11.health > 0 && sub12.health <= 0) || (sub11.health <= 0 && sub12.health > 0)) {
                    int input242 = scanBrain("-> ", 2);
                    switch (input242) {
                        case 1:
                            p2SecondaryAction = 1;
                            break;
                        case 2:
                            p2PrimaryAction = 0;
                            System.out.println("I give up. I'm skipping your turn");
                            break;
                    }
                } else {
                    int input243 = scanBrain("-> ", 3);
                    switch (input243) {
                        case 1:
                            p2SecondaryAction = 1;
                            break;
                        case 2:
                            p2SecondaryAction = 2;
                            break;
                        case 3:
                            p2PrimaryAction = 0;
                            System.out.println("I give up. I'm skipping your turn");
                            break;

                    }

                }

                // the printing and reading should occur in the battle section. takeTurn should
                // only be used to compute what happens.
                // this needs to change given that there are more than two players. define 2
                // local variables to set player1 and player2 dead
            }
        }
        if (p2Pathway == 5) {
            p2PrimaryAction = 4;
            System.out.println(
                    "Looks like you exhausted your " + p2Active.type + " now they need a nap and you lost your turn!");
            checkParticipation("Let's see if " + player1Name + " can do better next turn.");
        }
        takeTurn(p1PrimaryAction, p1SecondaryAction, p2PrimaryAction, p2SecondaryAction); // should have prority int
                                                                                          // values
    }

    public static void takeTurn(int p1PrimaryAction, int p1SecondaryAction, int p2PrimaryAction, int p2SecondaryAction) {
        cleanConsole();
        if (p1PrimaryAction == 1 && p2PrimaryAction == 1) { // Both combat
            int tally = p1SecondaryAction * (p1SecondaryAction + p2SecondaryAction);
            switch (tally) {
                // P1 first
                case 2:
                    p1Active.health -= p2Active.move1DamageOver;
                    p2Active.health -= p1Active.move1DamageOver;
                    p1Active.stamina -= 50;
                    p2Active.stamina -= 50;
                    System.out.println(player1Name + "'s " + p1Active.type + " attacked using " + p1Active.move1Name
                            + " and " + player2Name + "'s " + p2Active.type + " attacked using " + p2Active.move1Name
                            + "!");
                    System.out.println(player1Name + "'s " + p1Active.type + " dealt " + p1Active.move1DamageOver
                            + " points of damage to " + player2Name + "'s " + p2Active.type + "!");
                    System.out.println(player2Name + "'s " + p2Active.type + " dealt " + p2Active.move1DamageOver
                            + " points of damage to " + player1Name + "'s " + p1Active.type + "!");
                    break;
                case 3:
                    p1Active.health -= p2Active.move2DamageOver;
                    p2Active.health -= p1Active.move1DamageOver;
                    p1Active.stamina -= 50;
                    System.out.println(player1Name + "'s " + p1Active.type + " attacked using " + p1Active.move1Name
                            + ". But " + player2Name + "'s " + p2Active.type + " also attacked using "
                            + p2Active.move2Name + "!");
                    System.out.println(player1Name + "'s " + p1Active.type + " dealt " + p1Active.move1DamageOver
                            + " points of damage to " + player2Name + "'s " + p2Active.type + "!");
                    System.out.println(player2Name + "'s " + p2Active.type + " dealt " + p2Active.move2DamageOver
                            + " points of damage to " + player1Name + "'s " + p1Active.type + "!");
                    break;
                case 4:
                    p2Active.health -= p1Active.move1DamageDefended;
                    p1Active.stamina -= 50;
                    p2Active.move3DamageReduction -= 25;
                    System.out.println(player1Name + "'s " + p1Active.type + " used " + p1Active.move1Name + ". But "
                            + player2Name + "'s " + p2Active.type + " defended using " + p2Active.move3Name + "!");
                    System.out
                            .println(player1Name + "'s " + p1Active.type + " only dealt " + p1Active.move1DamageDefended
                                    + " points of damage to " + player2Name + "'s " + p2Active.type + "!");
                    break;
                // P1 second
                case 6:
                    p1Active.health -= p2Active.move1DamageOver;
                    p2Active.health -= p1Active.move2DamageOver;
                    p2Active.stamina -= 50;
                    System.out.println(player1Name + "'s " + p1Active.type + " attacked using " + p1Active.move2Name
                            + ". But " + player2Name + "'s " + p2Active.type + " also attacked using "
                            + p2Active.move1Name + "!");
                    System.out.println(player1Name + "'s " + p1Active.type + " dealt " + p1Active.move2DamageOver
                            + " points of damage to " + player2Name + "'s " + p2Active.type + "!");
                    System.out.println(player2Name + "'s " + p2Active.type + " dealt " + p2Active.move1DamageOver
                            + " points of damage to " + player1Name + "'s " + p1Active.type + "!");
                    break;
                case 8:
                    p1Active.health -= p2Active.move2DamageOver;
                    p2Active.health -= p1Active.move2DamageOver;
                    System.out.println(player1Name + "'s " + p1Active.type + " attacked using " + p1Active.move2Name
                            + " and " + player2Name + "'s " + p2Active.type + " attacked using " + p2Active.move2Name
                            + "!");
                    System.out.println(player1Name + "'s " + p1Active.type + " dealt " + p1Active.move2DamageOver
                            + " points of damage to " + player2Name + "'s " + p2Active.type + "!");
                    System.out.println(player2Name + "'s " + p2Active.type + " dealt " + p2Active.move2DamageOver
                            + " points of damage to " + player1Name + "'s " + p1Active.type + "!");
                    break;
                case 10:
                    p2Active.health -= p1Active.move2DamageDefended;
                    p2Active.move3DamageReduction -= 25;
                    System.out.println(player1Name + "'s " + p1Active.type + " used " + p1Active.move2Name + ". But "
                            + player2Name + "'s " + p2Active.type + " defended using " + p2Active.move3Name + "!");
                    System.out.println(player1Name + "'s " + p1Active.type + " dealt " + p1Active.move2DamageDefended
                            + " points of damage to " + player2Name + "'s " + p2Active.type + "!");
                    break;
                // P1 def (three)
                case 12:
                    p1Active.health -= p2Active.move1DamageDefended;
                    p1Active.move3DamageReduction -= 25;
                    p2Active.stamina -= 50;
                    System.out.println(player2Name + "'s " + p2Active.type + " used " + p2Active.move1Name + ". But "
                            + player1Name + "'s " + p1Active.type + " defended using " + p1Active.move3Name + "!");
                    System.out.println(player2Name + "'s " + p2Active.type + " dealt " + p2Active.move1DamageDefended
                            + " points of damage to " + player1Name + "'s " + p1Active.type + "!");
                    break;
                case 15:
                    p1Active.health -= p2Active.move2DamageDefended;
                    p1Active.move3DamageReduction -= 25;
                    System.out.println(player2Name + "'s " + p2Active.type + " used " + p2Active.move2Name + ". But "
                            + player1Name + "'s " + p1Active.type + " defended using " + p1Active.move3Name + "!");
                    System.out.println(player2Name + "'s " + p2Active.type + " dealt " + p2Active.move1DamageDefended
                            + " points of damage to " + player1Name + "'s " + p1Active.type + "!");
                    break;
                case 18:
                    System.out.println(player2Name + "'s " + p2Active.type + " defended using " + p2Active.move2Name
                            + " and " + player1Name + "'s " + p1Active.type + " also.. defended... using "
                            + p1Active.move3Name + "... well that was anticlimactic...\nMoving on!");
                    break;
            }

        }

        if (p1PrimaryAction * (p1PrimaryAction + p2PrimaryAction) == 18) { // Both swap
            int tally = p1SecondaryAction * (p1SecondaryAction + p2SecondaryAction);
            switch (tally) {
                case 2:
                    System.out.println("Both " + player1Name + "'s " + p1Active.type + " and " + player2Name + "'s "
                            + p2Active.type + " flee from the battlefield!");
                    System.out.println(player1Name + "'s " + p1Active.type + " calls upon " + player1Name + "'s "
                            + sub11.type + " to replace them in the battle.");
                    System.out.println("And " + player2Name + "'s " + p2Active.type + " calls upon " + player2Name
                            + "'s " + sub21.type + " to replace them.");
                    swap(1, 1);
                    swap(2, 1);
                    break;
                case 8:
                    System.out.println("Both " + player1Name + "'s " + p1Active.type + " and " + player2Name + "'s "
                            + p2Active.type + " flee from the battlefield!");
                    System.out.println(player1Name + "'s " + p1Active.type + " calls upon " + player1Name + "'s "
                            + sub12.type + " to replace them in the battle.");
                    System.out.println("And " + player2Name + "'s " + p2Active.type + " calls upon " + player2Name
                            + "'s " + sub22.type + " to replace them.");
                    swap(1, 2);
                    swap(2, 2);
                    break;
                case 3:
                    System.out.println("Both " + player1Name + "'s " + p1Active.type + " and " + player2Name + "'s "
                            + p2Active.type + " flee from the battlefield!");
                    System.out.println(player1Name + "'s " + p1Active.type + " calls upon " + player1Name + "'s "
                            + sub11.type + " to replace them in the battle.");
                    System.out.println("And " + player2Name + "'s " + p2Active.type + " calls upon " + player2Name
                            + "'s " + sub22.type + " to replace them.");
                    swap(1, 1);
                    swap(2, 2);
                    break;
                case 6:
                    System.out.println("Both " + player1Name + "'s " + p1Active.type + " and " + player2Name + "'s "
                            + p2Active.type + " flee from the battlefield!");
                    System.out.println(player1Name + "'s " + p1Active.type + " calls upon " + player1Name + "'s "
                            + sub12.type + " to replace them in the battle.");
                    System.out.println("And " + player2Name + "'s " + p2Active.type + " calls upon " + player2Name
                            + "'s " + sub21.type + " to replace them.");
                    swap(1, 2);
                    swap(2, 1);
                    break;
            }

        }

        if (p1PrimaryAction * (p1PrimaryAction + p2PrimaryAction) == 12) { // player 1 swap :: player 2 combat
            int tally = p1SecondaryAction * (p1SecondaryAction + p2SecondaryAction);
            switch (tally) {
                case 2:
                    p1Active.health -= p2Active.move1DamageOver;
                    p2Active.stamina -= 50;
                    System.out.println(
                            player1Name + " tried to swap out their " + p1Active.type + " to their " + sub11.type
                                    + ". But " + player2Name + "'s " + p2Active.type + " got them as they ran away!");
                    System.out.println(player2Name + "'s " + p2Active.type + " used " + p2Active.move1Name + " dealing "
                            + p2Active.move1DamageOver + " points of damage to " + player1Name + "'s " + p1Active.type
                            + "!");
                    swap(1, 1);
                    break;
                case 3:
                    p1Active.health -= p2Active.move2DamageOver;
                    System.out.println(
                            player1Name + " tried to swap out their " + p1Active.type + " to their " + sub11.type
                                    + ". But " + player2Name + "'s " + p2Active.type + " got them as they ran away!");
                    System.out.println(player2Name + "'s " + p2Active.type + " used " + p2Active.move2Name + " dealing "
                            + p2Active.move2DamageOver + " points of damage to " + player1Name + "'s " + p1Active.type
                            + "!");
                    swap(1, 1);
                    break;
                case 4:
                    System.out.println(player2Name + "'s" + p2Active.type + " prepares to defend with "
                            + p2Active.move3Name + ". But " + player1Name + "'s " + p1Active.type
                            + " flees the battlefield and " + player1Name + "'s " + sub11.type + "takes their place");
                    swap(1, 1);
                    break;

                case 6:
                    p1Active.health -= p2Active.move1DamageOver;
                    p2Active.stamina -= 50;
                    System.out.println(
                            player1Name + " tried to swap out their " + p1Active.type + " to their " + sub12.type
                                    + ". But " + player2Name + "'s " + p2Active.type + " got them as they ran away!");
                    System.out.println(player2Name + "'s " + p2Active.type + " used " + p2Active.move1Name + " dealing "
                            + p2Active.move1DamageOver + " points of damage to " + player1Name + "'s " + p1Active.type
                            + "!");
                    swap(1, 2);
                    break;
                case 8:
                    p1Active.health -= p2Active.move2DamageOver;
                    System.out.println(
                            player1Name + " tried to swap out their " + p1Active.type + " to their " + sub12.type
                                    + ". But " + player2Name + "'s " + p2Active.type + " got them as they ran away!");
                    System.out.println(player2Name + "'s " + p2Active.type + " used " + p2Active.move2Name + " dealing "
                            + p2Active.move2DamageOver + " points of damage to " + player1Name + "'s " + p1Active.type
                            + "!");
                    swap(1, 2);
                    break;
                case 10:
                    System.out.println(player2Name + "'s" + p2Active.type + " prepares to defend with "
                            + p2Active.move3Name + ". But " + player1Name + "'s " + p2Active.type
                            + " flees the battlefield and " + player1Name + "'s " + sub12.type + "takes their place");
                    swap(1, 2);
                    break;

            }
        }

        if (p1PrimaryAction * (p1PrimaryAction + p2PrimaryAction) == 4) { // player 1 combat :: player 2 swap
            int tally = p1SecondaryAction * (p1SecondaryAction + p2SecondaryAction);
            switch (tally) {
                case 2:
                    p2Active.health -= p1Active.move1DamageOver;
                    p1Active.stamina -= 50;
                    System.out.println(
                            player2Name + " tried to swap out their " + p2Active.type + " to their " + sub21.type
                                    + ". But " + player1Name + "'s " + p1Active.type + " got them as they ran away!");
                    System.out.println(player1Name + "'s " + p1Active.type + " used " + p1Active.move1Name + " dealing "
                            + p1Active.move1DamageOver + " points of damage to " + player2Name + "'s " + p2Active.type
                            + "!");
                    swap(2, 1);
                    break;
                case 3:
                    p2Active.health -= p1Active.move1DamageOver;
                    p1Active.stamina -= 50;
                    System.out.println(
                            player2Name + " tried to swap out their " + p2Active.type + " to their " + sub22.type
                                    + ". But " + player1Name + "'s " + p1Active.type + " got them as they ran away!");
                    System.out.println(player1Name + "'s " + p1Active.type + " used " + p1Active.move1Name + " dealing "
                            + p1Active.move1DamageOver + " points of damage to " + player2Name + "'s " + p2Active.type
                            + "!");
                    swap(2, 2);
                    break;

                case 6:
                    p2Active.health -= p1Active.move2DamageOver;
                    System.out.println(
                            player2Name + " tried to swap out their " + p2Active.type + " to their " + sub21.type
                                    + ". But " + player1Name + "'s " + p1Active.type + " got them as they ran away!");
                    System.out.println(player1Name + "'s " + p1Active.type + " used " + p1Active.move2Name + " dealing "
                            + p1Active.move2DamageOver + " points of damage to " + player2Name + "'s " + p2Active.type
                            + "!");
                    swap(2, 1);
                    break;
                case 8:
                    p2Active.health -= p1Active.move2DamageOver;
                    System.out.println(
                            player2Name + " tried to swap out their " + p2Active.type + " to their " + sub22.type
                                    + ". But " + player1Name + "'s " + p1Active.type + " got them as they ran away!");
                    System.out.println(player1Name + "'s " + p1Active.type + " used " + p1Active.move2Name + " dealing "
                            + p1Active.move2DamageOver + " points of damage to " + player2Name + "'s " + p2Active.type
                            + "!");
                    swap(1, 2);
                    break;

                case 12:
                    System.out.println(player1Name + "'s" + p1Active.type + " prepares to defend with "
                            + p1Active.move3Name + ". But " + player2Name + "'s " + p2Active.type
                            + " flees the battlefield and " + player2Name + "'s " + sub21.type + "takes their place");
                    swap(2, 1);
                    break;
                case 15:
                    System.out.println(player1Name + "'s" + p1Active.type + " prepares to defend with "
                            + p1Active.move3Name + ". But " + player2Name + "'s " + p2Active.type
                            + " flees the battlefield and " + player2Name + "'s " + sub22.type + "takes their place");
                    swap(2, 2);
                    break;

            }

        }
        // If player chooses return a second time
        if (p1PrimaryAction == 0 || p2PrimaryAction == 0) {
            if (p1PrimaryAction == 1) {
                switch (p1SecondaryAction) {
                    case 1:
                        p2Active.health -= p1Active.move1DamageOver;
                        p1Active.stamina -= 50;
                        System.out.println("Because " + player2Name + " can't make up their mind " + player1Name + "'s "
                                + p1Active.type + " gives them a smack to wake them back up!");
                        System.out.println(player1Name + "'s " + p1Active.type + " used " + p1Active.move1Name
                                + " dealing " + p1Active.move1DamageOver + " points of damage to " + player2Name + "'s "
                                + p2Active.type + ".");
                        break;
                    case 2:
                        p2Active.health -= p1Active.move2DamageOver;
                        System.out.println("Because " + player2Name + " can't make up their mind " + player1Name + "'s "
                                + p1Active.type + " gives them a smack to wake them back up!");
                        System.out.println(player1Name + "'s " + p1Active.type + " used " + p1Active.move2Name
                                + " dealing " + p1Active.move2DamageOver + " points of damage to " + player2Name + "'s "
                                + p2Active.type + ".");
                        break;
                    case 3:
                        System.out.println("While " + player2Name + " daydreams " + player1Name + "'s " + p1Active.type
                                + " waits patiently for " + player2Name + "'s " + p2Active.type + " to come hit them.");
                        break;
                }
            }
            if (p1PrimaryAction == 3) {
                switch (p1SecondaryAction) {
                    case 1:
                        System.out.println("While " + player2Name + " was waffling about " + player1Name + "'s "
                                + p1Active.type + " snuck of the battlefield and " + sub11 + " took their place!");
                        swap(1, 1);
                        break;
                    case 2:
                        System.out.println("While " + player2Name + " was waffling about " + player1Name + "'s "
                                + p1Active.type + " snuck of the battlefield and " + sub11 + " took their place!");
                        swap(1, 2);
                        break;
                }
            }

            if (p2PrimaryAction == 1) {
                switch (p2SecondaryAction) {
                    case 1:
                        p1Active.health -= p2Active.move1DamageOver;
                        p2Active.stamina -= 50;
                        System.out.println("Because " + player1Name + " can't make up their mind " + player2Name + "'s "
                                + p2Active.type + " gives them a smack to wake them back up!");
                        System.out.println(player2Name + "'s " + p2Active.type + " used " + p2Active.move1Name
                                + " dealing " + p2Active.move1DamageOver + " points of damage to " + player1Name + "'s "
                                + p1Active.type + ".");
                        break;
                    case 2:
                        p1Active.health -= p2Active.move2DamageOver;
                        System.out.println("Because " + player1Name + " can't make up their mind " + player2Name + "'s "
                                + p2Active.type + " gives them a smack to wake them back up!");
                        System.out.println(player2Name + "'s " + p2Active.type + " used " + p2Active.move2Name
                                + " dealing " + p2Active.move2DamageOver + " points of damage to " + player1Name + "'s "
                                + p1Active.type + ".");
                        break;
                    case 3:
                        System.out.println("While " + player1Name + " daydreams " + player2Name + "'s " + p2Active.type
                                + " waits patiently for " + player1Name + "'s " + p1Active.type + " to come hit them.");
                        break;
                }
            } else if (p2PrimaryAction == 3) {
                switch (p2SecondaryAction) {
                    case 1:
                        System.out.println("While " + player1Name + " was waffling about " + player2Name + "'s "
                                + p2Active.type + " snuck of the battlefield and " + sub21 + " took their place!");
                        swap(2, 1);
                        break;
                    case 2:
                        System.out.println("While " + player1Name + " was waffling about " + player2Name + "'s "
                                + p2Active.type + " snuck of the battlefield and " + sub22 + " took their place!");
                        swap(2, 2);
                        break;
                }
            }
            if (p1PrimaryAction == 0 && p2PrimaryAction == 0) {
                System.out.println("God neither of you can make up your minds! \nThat's it no one gets a turn!");
            }
        }
        if (p1PrimaryAction == 4 || p2PrimaryAction == 4) { // Exhausted character
            if (p1PrimaryAction == 1) {
                switch (p1SecondaryAction) {
                    case 1:
                        p2Active.health -= p1Active.move1DamageOver;
                        p1Active.stamina -= 50;
                        p2Active.stamina += 50;
                        break;
                    case 2:
                        p2Active.health -= p1Active.move2DamageOver;
                        p2Active.stamina += 50;
                        break;
                    case 3:
                        p2Active.stamina += 50;
                        break;
                }
            }
            if (p1PrimaryAction == 3) {
                switch (p1SecondaryAction) {
                    case 1:
                        p2Active.stamina += 50;
                        swap(1, 1);
                        break;
                    case 2:
                        p2Active.stamina += 50;
                        swap(1, 2);
                        break;
                }
            }

            if (p2PrimaryAction == 1) {
                switch (p2SecondaryAction) {
                    case 1:
                        p1Active.health -= p2Active.move1DamageOver;
                        p2Active.stamina -= 50;
                        p1Active.stamina += 50;
                        System.out.println(player1Name + "'s " + p1Active.type + " is exhausted! " + player2Name + "'s "
                                + p2Active.type + " takes the oppurtunity to attack with " + p2Active.move1Name +
                                ".\n " + p2Active.move1Name + " did " + p2Active.move1DamageOver
                                + " points of damage to " + player1Name + "'s " + p1Active.type);
                        break;
                    case 2:
                        p1Active.health -= p2Active.move1DamageOver;
                        p1Active.stamina += 50;
                        System.out.println(player1Name + "'s " + p1Active.type + " is exhausted! " + player2Name + "'s "
                                + p2Active.type + " takes the oppurtunity to attack with " + p2Active.move2Name +
                                ".\n " + p2Active.move2Name + " did " + p2Active.move2DamageOver
                                + " points of damage to " + player1Name + "'s " + p1Active.type);

                        break;
                    case 3:
                        p1Active.stamina += 50;
                        System.out.println(player1Name + "'s " + p1Active.type + " is exhausted. For some reason "
                                + player2Name + "'s " + p2Active.type + " decided to defend themself");
                        break;
                }
            } else if (p2PrimaryAction == 3) {
                switch (p2SecondaryAction) {
                    case 1:
                        p1Active.stamina += 50;
                        swap(2, 1);
                        break;
                    case 2:
                        p1Active.stamina += 50;
                        swap(2, 2);
                        break;
                }
            }
        }
        
        roundNumber++;
        if (roundNumber <= 10){
        checkParticipation("Wow that was thrilling to watch! Do you want to continue?");
        }
        if (roundNumber > 10 && roundNumber <= 20 ){
            checkParticipation("This is getting boring now. If you guys don't wrap this up soon I'm going inside. But anyway do you want to continue?");
        }
        if(roundNumber == 21){
            checkParticipation("I'm sick of this! I'm going inside! ");
        }if(roundNumber > 21){
            checkParticipation("The guy who was so interested in watching you is gone! Whats the point of going on with this? Enter to continue.");
        }
        battle();

    }

    public static void gameEnd(int condition) {
        if (condition == 1) {
            cleanConsole();
            System.out.println(player2Name + " has defeated " + player1Name
                    + "! Oh no who ever could have seen that coming... Shocking");
            System.out.println("Anyway you can play again if you want but I'm off to lunch so tell me now or leave!");
            System.out.println("(1) ''Yes I'm a sore loser and want to play again''");
            System.out.println("(2) ''No I'm scared''");
            int input = scanBrain("->", 2);
            if (input == 1) {
                System.out.println("Your words not mine. I was lying you can't play again. Go away!");
                System.exit(0);
            }
            if (input == 2) {
                System.out.println(
                        "Wow you really are a wimp... I didn't think the rumors were true! You discust me! NOW SCRAM");
                System.exit(0);
            }
        }
    }

}

// Congrats you reached the bottom! help theres so much code ):