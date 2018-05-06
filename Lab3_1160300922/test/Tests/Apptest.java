package Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import helper.ParseCommandHelper;
public class Apptest {
	/**
     * Tests that assertions are enabled.
     */
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false;
    }
    
    @Test
    public void AppTest() throws FileNotFoundException
    {
    	ParseCommandHelper parse = new ParseCommandHelper();
    	assertEquals(true , parse.OpenFile());
    }
}
