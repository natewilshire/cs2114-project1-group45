package CrazyCaffeine;

import student.TestCase;

public class ValidationTest
    extends TestCase
{
    private Validation validation;

    /**
     * creates a new Validation object before each test
     */
    public void setUp()
    {
        validation = new Validation();
    }


    /**
     * tests validDrinkName with a normal name, a blank name, and null
     */
    public void testValidDrinkName()
    {
        assertTrue(validation.validDrinkName("Cold Brew"));
        assertTrue(validation.validDrinkName("  Latte  "));
        assertFalse(validation.validDrinkName(""));
        assertFalse(validation.validDrinkName("   "));
        assertFalse(validation.validDrinkName(null));
    }


    /**
     * tests validSize with each valid size, different capitals, a bad size, and
     * null
     */
    public void testValidSize()
    {
        assertTrue(validation.validSize("small"));
        assertTrue(validation.validSize("medium"));
        assertTrue(validation.validSize("large"));
        assertTrue(validation.validSize(" LARGE "));
        assertFalse(validation.validSize("huge"));
        assertFalse(validation.validSize(""));
        assertFalse(validation.validSize(null));
    }


    /**
     * tests validTime with normal times, the edges 0 and 24, and times that are
     * too small or too large
     */
    public void testValidTime()
    {
        assertTrue(validation.validTime(14.5));
        assertTrue(validation.validTime(0));
        assertTrue(validation.validTime(23.9));
        assertFalse(validation.validTime(24));
        assertFalse(validation.validTime(-1));
        assertFalse(validation.validTime(25));
    }


    /**
     * tests validWeight with a normal weight, 0, a negative weight, and the
     * edges around MAX_VALUE
     */
    public void testValidWeight()
    {
        assertTrue(validation.validWeight(160));
        assertTrue(validation.validWeight(Validation.MAX_VALUE));
        assertFalse(validation.validWeight(0));
        assertFalse(validation.validWeight(-160));
        assertFalse(validation.validWeight(1001));
    }


    /**
     * tests validHeight with a normal height, 0, a negative height, and the
     * edges around MAX_VALUE
     */
    public void testValidHeight()
    {
        assertTrue(validation.validHeight(68));
        assertTrue(validation.validHeight(Validation.MAX_VALUE));
        assertFalse(validation.validHeight(0));
        assertFalse(validation.validHeight(-68));
        assertFalse(validation.validHeight(1001));
    }


    /**
     * tests validSex with male, female, different capitals, a bad value, and
     * null
     */
    public void testValidSex()
    {
        assertTrue(validation.validSex("male"));
        assertTrue(validation.validSex("female"));
        assertTrue(validation.validSex(" Female "));
        assertFalse(validation.validSex("other"));
        assertFalse(validation.validSex(""));
        assertFalse(validation.validSex(null));
    }


    /**
     * tests validCaffeineAmount with a normal amount, 0, a negative amount, and
     * the edges around MAX_VALUE
     */
    public void testValidCaffeineAmount()
    {
        assertTrue(validation.validCaffeineAmount(95));
        assertTrue(validation.validCaffeineAmount(Validation.MAX_VALUE));
        assertFalse(validation.validCaffeineAmount(0));
        assertFalse(validation.validCaffeineAmount(-50));
        assertFalse(validation.validCaffeineAmount(1001));
    }


    /**
     * tests validRequestedTime with a time after the drink, the same time as
     * the drink, a time before the drink, and an invalid time
     */
    public void testValidRequestedTime()
    {
        assertTrue(validation.validRequestedTime(18, 8));
        assertTrue(validation.validRequestedTime(8, 8));
        assertFalse(validation.validRequestedTime(8, 10));
        assertFalse(validation.validRequestedTime(25, 8));
        assertFalse(validation.validRequestedTime(-1, -2));
    }

}
