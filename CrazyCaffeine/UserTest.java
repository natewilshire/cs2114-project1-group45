package CrazyCaffeine;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * tests the user class
 * 
 * @author nate
 * @version Sep 22, 2026
 */
public class UserTest
    extends TestCase
{
    private User user;

    /**
     * creates a new User object before each test
     */
    public void setUp()
    {
        user = new User("male", 68, 160);
    }


    /**
     * tests getSex with a normal value and an empty/invalid value
     */
    public void testGetSex()
    {
        assertEquals("male", user.getSex());

        User empty = new User("", 68, 160);
        assertEquals("", empty.getSex());

        User nullSex = new User(null, 68, 160);
        assertNull(nullSex.getSex());
    }


    /**
     * tests getHeight with a normal value, zero, and a negative value
     */
    public void testGetHeight()
    {
        assertEquals(68, user.getHeight(), 0.0001);

        User zero = new User("male", 0, 160);
        assertEquals(0, zero.getHeight(), 0.0001);

        User negative = new User("male", -68, 160);
        assertEquals(-68, negative.getHeight(), 0.0001);
    }


    /**
     * tests getWeight with a normal value, zero, and a negative value
     */
    public void testGetWeight()
    {
        assertEquals(160, user.getWeight(), 0.0001);

        User zero = new User("male", 68, 0);
        assertEquals(0, zero.getWeight(), 0.0001);

        User negative = new User("male", 68, -160);
        assertEquals(-160, negative.getWeight(), 0.0001);
    }

}
