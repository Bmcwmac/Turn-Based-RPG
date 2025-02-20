import java.util.*;

public class Character { //Super class
    public String type;
    public int health, defence, strength;
    public int stamina;
    String status, hiddenStatus;


    public String move1Name, move2Name, move3Name;
    public String move1Info, move2Info,move3Info;
    public int move1DamageOriginal, move2DamageOriginal ,move3DamageReduction;
    public int move1DamageDefended, move2DamageDefended;
    public int move1DamageOver, move2DamageOver;

    void setMove1(String name, String info, int strength){
        move1Name = name;
        move1Info = info;
        move1DamageOriginal = strength;
    }

    void setMove2(String name, String info, int strength){
        move2Name = name;
        move2Info = info;
        move2DamageOriginal = strength;
    }

    void setMove3(String name, String info, int strength){
        move3Name = name;
        move3Info = info;
        move3DamageReduction = strength;
        
    }
    void setMove1DamageOverride(int p2defence, int p2Move3Val, int OriginalDamage, int strength){
        move1DamageOver = (OriginalDamage/2 + strength)-(p2defence);
        move1DamageDefended = move1DamageOver - p2Move3Val;
        
    }
    void setMove2DamageOverride(int p2defence, int p2Move3val, int OriginalDamage, int strength){
        move2DamageOver = (OriginalDamage/2 + strength) - p2defence;
        move2DamageDefended = move2DamageOver - p2Move3val;
    }

    void setType(String name){
        type = name;
    }
    void setHealth(int max, int min){
        health = (int) (Math.random()*(max - min) + min);      
    }
    void setDefence(int max, int min){
        defence = (int) (Math.random()*(max - min) + min);
    }
    void setStrength(int max, int min){
        strength = (int) (Math.random()*(max - min) + min);
    }
    void setStamina(int stamval){
        stamina = stamval;
    }
    void setStatus(String effect){
        status = effect;
    }
    void setHiddenStatus(String hideStat){
        hiddenStatus = hideStat;
    }

    public void printTable(){}

    public void randomizeMoves(ArrayList<String[]> moves, int moveCount, String moveType, int order){}

    
    
    

}
   

class character1 extends Character{
    //This block of code probably isn't allowed but its fun so until i find out if i can use it ill leave it in.
    @Override
    public void printTable(){
        String leftAlignFormat = "| %-15s | %-9s |%n";
        System.out.format("+-----------------+-----------+%n");
        System.out.format("|       PLAYER    |     ID    |%n");
        System.out.format("+-----------------+-----------+%n");
        
            System.out.format(leftAlignFormat, "name", type);
            System.out.format(leftAlignFormat, "Health", health);
            System.out.format(leftAlignFormat, "Defence", defence);
            System.out.format(leftAlignFormat, "Strength", strength);
            System.out.format(leftAlignFormat, "Move 1", move1Name);
            System.out.format(leftAlignFormat, "Move 2", move2Name);
        
        System.out.format("+-----------------+-----------+%n");
    }

    public void randomizeMoves(ArrayList<String[]> moves, int moveCount, String moveType, int order){
        if (moveCount == 0){
           return; 
        }
        String[]selectedMove = Compare(moves, moveType, order);
        if (moveCount == 3 && Integer.parseInt(selectedMove[4]) == 1){
            setMove1(selectedMove[0], selectedMove[1], Integer.parseInt(selectedMove[2]));
        }
        if(moveCount == 2 && Integer.parseInt(selectedMove[4]) == 2) {
            setMove2(selectedMove[0], selectedMove[1], Integer.parseInt(selectedMove[2]));
        }
        if(moveCount == 1 && Integer.parseInt(selectedMove[4]) == 3){
            setMove3(selectedMove[0], selectedMove[1], Integer.parseInt(selectedMove[2]));
        }
        //Remove the selected move to avoid duplication
        
        //moves.remove(randomIndex);
        
        // Recursive call for next move
        randomizeMoves(moves, moveCount - 1, moveType,order+1);
    }

    public String[] Compare(ArrayList<String[]> moves, String moveType,int order){
        Random rand = new Random();
        int randomIndex = rand.nextInt(moves.size());
        String[] selectedMove = moves.get(randomIndex);
        if(selectedMove[3]==moveType && Integer.parseInt(selectedMove[4])==order){
            return selectedMove;
        }
        return Compare(moves, moveType, order);
    }

    @Override
    void setMove1DamageOverride(int p2defence, int p2Move3Val, int OriginalDamage, int strength){
        super.setMove1DamageOverride(p2defence, p2Move3Val,OriginalDamage,strength);
    }

    @Override
    void setMove2DamageOverride(int p2defence, int p2Move3Val, int OriginalDamage, int strength){
        super.setMove2DamageOverride(p2defence, p2Move3Val,OriginalDamage,strength);
    }


    @Override
    void setMove1(String name, String info, int strength){
        super.setMove1(name, info, strength);
    }
    @Override
    void setMove2(String name, String info, int strength){
        super.setMove2(name, info, strength);
    }
    @Override
    void setMove3(String name, String info, int strength){
        super.setMove3(name, info, strength);
    }

    //character stats
    @Override
    void setType(String name){
        super.setType(name);
    }
    @Override
    void setHealth(int max, int min){
        super.setHealth(max, min);
    }
    @Override
    void setDefence(int max, int min){
        super.setDefence(max, min);
    }
    @Override
    void setStrength(int max, int min){
        super.setStrength(max, min);
    }
    @Override
    void setStamina(int stamval){
        super.setStamina(stamval);
    }
    @Override
    void setStatus(String effect){
        super.setStatus(effect);
    }
    @Override
    void setHiddenStatus(String hideStat){
        super.setHiddenStatus(hideStat);
    }

}