package yourpackagehere;

import dnd.models.Exit;
import dnd.models.Monster;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Le
 */
public class PassageSectionTest {
    


    /**
     * Test of getDoor method, of class PassageSection.
     */
    @Test
    public void testGetDoor() {
        System.out.println("testGetDoor");
        String s = "passage ends in Door to a Chamber";
        PassageSection instance = new PassageSection(s);
        Door d = instance.getDoor();
        
        if(d != null){
            boolean result = (d.getSpaces().size() >= 0);
            boolean expResult = true;
            assertEquals(expResult, result);
        }
        else {
            fail("There is no door attach to this passage section.");
        }
                    
    }

    /**
     * Test of getMonster method, of class PassageSection.
     * Set a monster based on string description
     */
    @Test
    public void testGetMonsterOne() {
        System.out.println("getMonster");
        String s = "Wandering Monster (passage continues straight for 10 ft)";
        PassageSection instance = new PassageSection(s);
        Monster m = instance.getMonster();
        boolean result = ( m != null);
        boolean expResult = true;
        assertEquals(expResult, result);
    }
    /**
     * Test of getMonster method, of class PassageSection.
     * There is no monster based on string description
     */
    @Test
    public void testGetMonsterTwo() {
        System.out.println("getMonster");
        String s = "passage goes straight for 10 ft";
        PassageSection instance = new PassageSection(s);
        Monster m = instance.getMonster();
        boolean result = ( m != null);
        boolean expResult = false;
        assertEquals(expResult, result);
    }    


    /**
     * Test of getDescription method, of class PassageSection.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String description = "passage goes straight for 10 ft";
        PassageSection instance = new PassageSection(description);
        
        String expResult = "straight";
        String result = instance.getDescription();
        assertTrue(result.contains(expResult));

    }

    
}
