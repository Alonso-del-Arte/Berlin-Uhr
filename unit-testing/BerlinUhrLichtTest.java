/*
 * Copyright (C) 2019 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package berlinuhr;

import java.awt.Color;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of the BerlinUhrLicht class.
 * @author Alonso del Arte
 */
public class BerlinUhrLichtTest {
    
    private BerlinUhrLicht redLight, greenLight, blueLight;
    
    /**
     * Sets up three lights with the colors red, green and blue. Although these 
     * are not the actual colors that will be used in the actual Berlin Clock, 
     * they are good enough for testing purposes.
     */
    @Before
    public void setUp() {
        redLight = new BerlinUhrLicht(Color.RED);
        greenLight = new BerlinUhrLicht(Color.GREEN);
        blueLight = new BerlinUhrLicht(Color.BLUE);
    }
    
    /**
     * Test of toggleStatus method, of class BerlinUhrLicht. Lights should be 
     * off coming from the initialization of <code>@Before</code>, so toggling 
     * should bring them on.
     */
    @Test
    public void testToggleStatus() {
        System.out.println("toggleStatus");
        redLight.toggleStatus();
        greenLight.toggleStatus();
        blueLight.toggleStatus();
        String assertionMessage = "This light should be on after toggling from initialization";
        assertTrue(assertionMessage, redLight.getStatus());
        assertTrue(assertionMessage, greenLight.getStatus());
        assertTrue(assertionMessage, blueLight.getStatus());
    }

    /**
     * Test of getStatus method, of class BerlinUhrLicht. Lights should be 
     * off coming from the initialization of <code>@Before</code>.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        String assertionMessage = "This light should be off since it's just been initialized";
        assertFalse(assertionMessage, redLight.getStatus());
        assertFalse(assertionMessage, greenLight.getStatus());
        assertFalse(assertionMessage, blueLight.getStatus());
    }

    /**
     * Test of getColor method, of class BerlinUhrLicht.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        assertEquals(Color.RED, redLight.getColor());
        assertEquals(Color.GREEN, greenLight.getColor());
        assertEquals(Color.BLUE, blueLight.getColor());
    }
    
    /**
     * Test of toString method, of class BerlinUhrLicht. This test ignores 
     * spaces.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expected = "ausgeschaltetLicht" + Color.RED.toString();
        String actual = redLight.toString().replace(" ", "");
        System.out.println(actual);
        assertEquals(expected, actual);
        expected = expected.replace("aus", "ein");
        redLight.toggleStatus();
        actual = redLight.toString().replace(" ", "");
        System.out.println(actual);
        assertEquals(expected, actual);
        expected = "ausgeschaltetLicht" + Color.GREEN.toString();
        actual = greenLight.toString().replace(" ", "");
        System.out.println(actual);
        assertEquals(expected, actual);
        expected = expected.replace("aus", "ein");
        greenLight.toggleStatus();
        actual = greenLight.toString().replace(" ", "");
        System.out.println(actual);
        assertEquals(expected, actual);
        expected = "ausgeschaltetLicht" + Color.BLUE.toString();
        actual = blueLight.toString().replace(" ", "");
        System.out.println(actual);
        assertEquals(expected, actual);
        expected = expected.replace("aus", "ein");
        blueLight.toggleStatus();
        actual = blueLight.toString().replace(" ", "");
        System.out.println(actual);
        assertEquals(expected, actual);
    }
    
    /**
     * Test of equals method, of class BerlinUhrLicht.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        BerlinUhrLicht sameLight = new BerlinUhrLicht(Color.RED);
        assertEquals(redLight, sameLight);
        redLight.toggleStatus();
        assertNotEquals(redLight, sameLight);
        sameLight.toggleStatus();
        assertEquals(redLight, sameLight);
        sameLight = new BerlinUhrLicht(Color.GREEN);
        assertEquals(greenLight, sameLight);
        greenLight.toggleStatus();
        assertNotEquals(greenLight, sameLight);
        sameLight.toggleStatus();
        assertEquals(greenLight, sameLight);
        sameLight = new BerlinUhrLicht(Color.BLUE);
        assertEquals(blueLight, sameLight);
        blueLight.toggleStatus();
        assertNotEquals(blueLight, sameLight);
        sameLight.toggleStatus();
        assertEquals(blueLight, sameLight);
    }
    
    /**
     * Test of hashCode method, of class BerlinUhrLicht. Checks that the hash 
     * codes for three lights, each on and off, makes for six distinct hash 
     * codes. Also checks that off lights have negative hash codes and on lights 
     * have positive hash codes.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        HashSet<Integer> lightHashes = new HashSet<>(6);
        int currHash = redLight.hashCode();
        String assertionMessageOffLight = "Light that is off should have negative hash code";
        assertTrue(assertionMessageOffLight, currHash < 0);
        System.out.println("Red light that is off hashed as " + currHash);
        lightHashes.add(currHash);
        redLight.toggleStatus();
        currHash = redLight.hashCode();
        String assertionMessageOnLight = "Light that is on should have positive hash code";
        assertTrue(assertionMessageOnLight, currHash > 0);
        System.out.println("Red light that is on hashed as " + currHash);
        lightHashes.add(currHash);
        currHash = greenLight.hashCode();
        assertTrue(assertionMessageOffLight, currHash < 0);
        System.out.println("Green light that is off hashed as " + currHash);
        lightHashes.add(currHash);
        greenLight.toggleStatus();
        currHash = greenLight.hashCode();
        assertTrue(assertionMessageOnLight, currHash > 0);
        System.out.println("Green light that is on hashed as " + currHash);
        lightHashes.add(currHash);
        currHash = blueLight.hashCode();
        assertTrue(assertionMessageOffLight, currHash < 0);
        System.out.println("Blue light that is off hashed as " + currHash);
        lightHashes.add(currHash);
        blueLight.toggleStatus();
        currHash = blueLight.hashCode();
        assertTrue(assertionMessageOnLight, currHash > 0);
        System.out.println("Blue light that is on hashed as " + currHash);
        lightHashes.add(currHash);
        String assertionMessage = "Set of BerlinUhrLicht hash codes should have six distinct hash codes";
        assertEquals(assertionMessage, 6, lightHashes.size());
    }
    
}
