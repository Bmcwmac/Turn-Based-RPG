import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CharacterTest {

    private Character character;

    @Before
    public void setUp() {
        character = new Character();
    }

    @Test
    public void testSetMove1() {
        character.setMove1("Strike", "A powerful strike", 15);
        assertEquals("Strike", character.move1Name);
        assertEquals("A powerful strike", character.move1Info);
        assertEquals(15, character.move1DamageOriginal);
    }

    @Test
    public void testSetMove2() {
        character.setMove2("Shield Bash", "A defensive bash", 10);
        assertEquals("Shield Bash", character.move2Name);
        assertEquals("A defensive bash", character.move2Info);
        assertEquals(10, character.move2DamageOriginal);
    }

    @Test
    public void testSetMove3() {
        character.setMove3("Guard", "Reduces incoming damage", 5);
        assertEquals("Guard", character.move3Name);
        assertEquals("Reduces incoming damage", character.move3Info);
        assertEquals(5, character.move3DamageReduction);
    }

    @Test
    public void testSetHealth() {
        character.setHealth(100, 50);
        assertTrue("Health should be within the specified range", character.health >= 50 && character.health <= 100);
    }

    @Test
    public void testSetDefence() {
        character.setDefence(50, 20);
        assertTrue("Defence should be within the specified range", character.defence >= 20 && character.defence <= 50);
    }

    @Test
    public void testSetStrength() {
        character.setStrength(30, 10);
        assertTrue("Strength should be within the specified range", character.strength >= 10 && character.strength <= 30);
    }

    @Test
    public void testSetStamina() {
        character.setStamina(100);
        assertEquals(100, character.stamina);
    }

    @Test
    public void testSetType() {
        character.setType("Warrior");
        assertEquals("Warrior", character.type);
    }


    @Test
    public void testSetHiddenStatus() {
        character.setHiddenStatus("Invisible");
        assertEquals("Invisible", character.hiddenStatus);
    }
}
