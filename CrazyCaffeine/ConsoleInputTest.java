package CrazyCaffeine;

import student.TestCase;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * testing console input class
 * 
 * @author shafiursarker
 * @version Sep 22, 2026
 */
public class ConsoleInputTest
    extends TestCase
{
    private Validation validation;

    /**
     * creates a new Validation object before each test
     */
    public void setUp()
    {
        validation = new Validation();
        systemOut().clearHistory();
    }


    /**
     * makes a ConsoleInput that reads from the given text instead of the
     * keyboard
     *
     * @param text
     *            the fake user input, with each answer on its own line
     * @return a ConsoleInput that reads the text
     */
    private ConsoleInput makeInput(String text)
    {
        return new ConsoleInput(new Scanner(text), validation);
    }


    /**
     * tests readSex with a good answer, and with a bad answer followed by a
     * good one
     */
    public void testReadSex()
    {
        assertEquals("male", makeInput("male\n").readSex());
        assertEquals("female", makeInput("abc\n Female \n").readSex());
        assertTrue(
            systemOut().getHistory()
                .contains("Rejected: please type male or female."));
    }


    /**
     * tests readHeight with a good number, a word, and a negative number
     */
    public void testReadHeight()
    {
        assertEquals(70.0, makeInput("70\n").readHeight(), 0.01);
        assertEquals(68.0, makeInput("abc\n-5\n68\n").readHeight(), 0.01);
        assertTrue(
            systemOut().getHistory()
                .contains("Rejected: please enter a number."));
        assertTrue(
            systemOut().getHistory()
                .contains("Rejected: height must be greater than 0"));
    }


    /**
     * tests readWeight with a good number, 0, and a number that is too large
     */
    public void testReadWeight()
    {
        assertEquals(170.0, makeInput("170\n").readWeight(), 0.01);
        assertEquals(150.0, makeInput("0\n5000\n150\n").readWeight(), 0.01);
        assertTrue(
            systemOut().getHistory()
                .contains("Rejected: weight must be greater than 0"));
    }


    /**
     * tests readCaffeineAmount with a good amount and a negative amount
     */
    public void testReadCaffeineAmount()
    {
        assertEquals(95.0, makeInput("95\n").readCaffeineAmount(), 0.01);
        assertEquals(80.0, makeInput("-50\n80\n").readCaffeineAmount(), 0.01);
        assertTrue(
            systemOut().getHistory()
                .contains("Rejected: caffeine must be greater than 0"));
    }


    /**
     * tests readDrinkName with a good name, and with a blank name followed by a
     * good one
     */
    public void testReadDrinkName()
    {
        assertEquals("Cold Brew", makeInput("Cold Brew\n").readDrinkName());
        assertEquals("Latte", makeInput("   \n  Latte  \n").readDrinkName());
        assertTrue(
            systemOut().getHistory()
                .contains("Rejected: drink name can't be blank."));
    }


    /**
     * tests readSize with a good size, and with a bad size followed by a good
     * one
     */
    public void testReadSize()
    {
        assertEquals("small", makeInput("small\n").readSize());
        assertEquals("large", makeInput("huge\nLARGE\n").readSize());
        assertTrue(
            systemOut().getHistory()
                .contains("Rejected: size must be small, medium, or large."));
    }


    /**
     * tests readTime with a good time, and with times that are too large or too
     * small
     */
    public void testReadTime()
    {
        assertEquals(8.5, makeInput("8.5\n").readTime("Time: "), 0.01);
        assertEquals(14.0, makeInput("25\n-1\n14\n").readTime("Time: "), 0.01);
        assertTrue(
            systemOut().getHistory().contains(
                "Rejected: time must be at least 0 and less than 24."));
    }


    /**
     * tests readRequestedTime with a time after the first drink, and with a
     * time before the first drink followed by a good one
     */
    public void testReadRequestedTime()
    {
        assertEquals(18.0, makeInput("18\n").readRequestedTime(8), 0.01);
        assertEquals(12.0, makeInput("7\n12\n").readRequestedTime(8), 0.01);
        assertTrue(
            systemOut().getHistory()
                .contains("Rejected: that is before your first drink"));
    }


    /**
     * tests readMenuChoice with a good choice, a word, and numbers that are too
     * small or too large
     */
    public void testReadMenuChoice()
    {
        assertEquals(2, makeInput("2\n").readMenuChoice("Choice: ", 3));
        assertEquals(
            3,
            makeInput("abc\n0\n4\n3\n").readMenuChoice("Choice: ", 3));
        assertTrue(
            systemOut().getHistory()
                .contains("Rejected: pick a number from 1 to 3."));
    }


    /**
     * tests readYesNo with y, n, and a bad answer followed by a good one
     */
    public void testReadYesNo()
    {
        assertTrue(makeInput("y\n").readYesNo("More? "));
        assertFalse(makeInput("n\n").readYesNo("More? "));
        assertTrue(makeInput("maybe\n Y \n").readYesNo("More? "));
        assertTrue(
            systemOut().getHistory().contains("Rejected: please type y or n."));
    }
}
