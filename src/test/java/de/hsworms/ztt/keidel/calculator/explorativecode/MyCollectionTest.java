package de.hsworms.ztt.keidel.calculator.explorativecode;

import de.hsworms.ztt.keidel.calculator.explorativecode.MyCollection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyCollectionTest {

    private MyCollection myCollection;
    private static String TEST_STRING = "The quick brown fox";
    private static String[] EXPECTED_STRINGS = {"The", "quick", "brown", "fox"};

    @Before
    public void setUp() throws Exception {
        myCollection = new MyCollection(TEST_STRING);
    }

    @After
    public void tearDown() throws Exception {
        myCollection = null;
    }

    @Test
    public void hasNext() {
        int counter = 0;
        while(myCollection.hasNext()) {
            assertEquals(EXPECTED_STRINGS[counter], myCollection.next());
            counter++;
        }
    }

    @Test
    public void collectionNotEmpty() {
        assertTrue(myCollection.hasNext());
    }
}