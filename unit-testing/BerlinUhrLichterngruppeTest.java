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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of the BerlinUhrLichterngruppe class. I've been going back on forth on 
 * whether the round light at the top should blink on for odd or even seconds. 
 * After deciding that the light group class should implement 
 * <code>Comparable</code>, and that the comparison would be based on the hash 
 * code, I ultimately decided that the second light should blink for odd 
 * seconds.
 * @author Alonso del Arte
 */
public class BerlinUhrLichterngruppeTest {
    
    private static LocalTime testTime;
    
    private BerlinUhrLichterngruppe lightsGroup;
    
    @BeforeClass
    public static void setUpClass() {
        testTime = LocalTime.now();
        System.out.println("Tests begun at " + testTime.toString());
    }
    
    @AfterClass
    public static void tearDownClass() {
        testTime = LocalTime.now();
        System.out.println("Tests concluded at " + testTime.toString());
    }
    
    @Before
    public void setUp() {
        testTime = LocalTime.NOON;
        lightsGroup = new BerlinUhrLichterngruppe(testTime);
        System.out.println("Tested class instance re-initialized to noon");
    }
    
    @After
    public void tearDown() {
        testTime = lightsGroup.getTime();
        System.out.println("Tested class instance exited test with reported time " + testTime.toString());
        System.out.println("Light group has this hash code (in binary): " + Integer.toString(lightsGroup.hashCode(), 2));
    }

    /**
     * Test of setTime method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        testTime = LocalTime.now();
        lightsGroup.setTime(testTime);
        assertEquals(testTime, lightsGroup.getTime());
        BerlinUhrLichterngruppe comparisonLights = new BerlinUhrLichterngruppe(testTime);
        assertEquals(comparisonLights, lightsGroup);
    }

    /**
     * Test of getTime method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        assertEquals(LocalTime.NOON, lightsGroup.getTime());
    }

    /**
     * Test of decrementHour method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testDecrementHour() {
        System.out.println("decrementHour");
        BerlinUhrLichterngruppe localLightsGroup;
        for (int hh = 1; hh < 48; hh++) {
            testTime = testTime.minusHours(1);
            lightsGroup.decrementHour();
            assertEquals(testTime, lightsGroup.getTime());
            localLightsGroup = new BerlinUhrLichterngruppe(testTime);
            assertEquals(localLightsGroup, lightsGroup);
        }
    }

    /**
     * Test of incrementHour method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testIncrementHour() {
        System.out.println("incrementHour");
        BerlinUhrLichterngruppe localLightsGroup;
        for (int hh = 1; hh < 48; hh++) {
            testTime = testTime.plusHours(1);
            lightsGroup.incrementHour();
            assertEquals(testTime, lightsGroup.getTime());
            localLightsGroup = new BerlinUhrLichterngruppe(testTime);
            assertEquals(localLightsGroup, lightsGroup);
        }
    }

    /**
     * Test of decrementMinute method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testDecrementMinute() {
        System.out.println("decrementMinute");
        BerlinUhrLichterngruppe localLightsGroup;
        for (int mm = 1; mm < 120; mm++) {
            testTime = testTime.minusMinutes(1);
            lightsGroup.decrementMinute();
            assertEquals(testTime, lightsGroup.getTime());
            localLightsGroup = new BerlinUhrLichterngruppe(testTime);
            assertEquals(localLightsGroup, lightsGroup);
        }
    }

    /**
     * Test of incrementMinute method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testIncrementMinute() {
        System.out.println("incrementMinute");
        BerlinUhrLichterngruppe localLightsGroup;
        for (int mm = 1; mm < 120; mm++) {
            testTime = testTime.plusMinutes(1);
            lightsGroup.incrementMinute();
            assertEquals(testTime, lightsGroup.getTime());
            localLightsGroup = new BerlinUhrLichterngruppe(testTime);
            assertEquals(localLightsGroup, lightsGroup);
        }
    }
    
    /**
     * Test of decrementMinute method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testDecrementSecond() {
        System.out.println("decrementSecond");
        BerlinUhrLichterngruppe localLightsGroup;
        for (int ss = 1; ss < 120; ss++) {
            testTime = testTime.minusSeconds(1);
            lightsGroup.decrementSecond();
            assertEquals(testTime, lightsGroup.getTime());
            localLightsGroup = new BerlinUhrLichterngruppe(testTime);
            assertEquals(localLightsGroup, lightsGroup);
        }
    }

    /**
     * Test of incrementMinute method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testIncrementSecond() {
        System.out.println("incrementSecond");
        BerlinUhrLichterngruppe localLightsGroup;
        for (int ss = 1; ss < 120; ss++) {
            testTime = testTime.plusSeconds(1);
            lightsGroup.incrementSecond();
            assertEquals(testTime, lightsGroup.getTime());
            localLightsGroup = new BerlinUhrLichterngruppe(testTime);
            assertEquals(localLightsGroup, lightsGroup);
        }
    }
    
    /**
     * Test of toString method, of class BerlinUhrLichterngruppe. This test 
     * ignores spaces.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expected = "Lichtern" + LocalTime.NOON.toString();
        String actual = lightsGroup.toString().replace(" ", "");
        assertEquals(expected, actual);
        lightsGroup = new BerlinUhrLichterngruppe(LocalTime.MIDNIGHT);
        expected = "Lichtern" + LocalTime.MIDNIGHT.toString();
        actual = lightsGroup.toString().replace(" ", "");
        assertEquals(expected, actual);
        lightsGroup = new BerlinUhrLichterngruppe(LocalTime.MAX);
        expected = "Lichtern" + LocalTime.MAX.toString();
        actual = lightsGroup.toString().replace(" ", "");
        assertEquals(expected, actual);
    }
    
    /**
     * Test of equals method, of class BerlinUhrLichterngruppe. Two light groups 
     * should be considered equal if they correspond to the same hour and same 
     * minute, and the second is of the same parity.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        BerlinUhrLichterngruppe secondLightsGroup = new BerlinUhrLichterngruppe(LocalTime.NOON);
        assertEquals(lightsGroup, secondLightsGroup);
        secondLightsGroup = new BerlinUhrLichterngruppe(LocalTime.MIDNIGHT);
        assertNotEquals(lightsGroup, secondLightsGroup);
        lightsGroup = new BerlinUhrLichterngruppe(LocalTime.MIDNIGHT);
        assertEquals(lightsGroup, secondLightsGroup);
        secondLightsGroup = new BerlinUhrLichterngruppe(LocalTime.MAX);
        assertNotEquals(lightsGroup, secondLightsGroup);
        lightsGroup = new BerlinUhrLichterngruppe(LocalTime.MAX);
        assertEquals(lightsGroup, secondLightsGroup);
    }
    
    /**
     * Test of hashCode method, of class BerlinUhrLichterngruppe. Two light 
     * groups should have the same hash code if they correspond to the same hour 
     * and same minute, and the second is of the same parity.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        BerlinUhrLichterngruppe secondLightsGroup = new BerlinUhrLichterngruppe(LocalTime.NOON);
        assertEquals(lightsGroup.hashCode(), secondLightsGroup.hashCode());
        secondLightsGroup = new BerlinUhrLichterngruppe(LocalTime.MIDNIGHT);
        assertNotEquals(lightsGroup.hashCode(), secondLightsGroup.hashCode());
        lightsGroup = new BerlinUhrLichterngruppe(LocalTime.MIDNIGHT);
        assertEquals(lightsGroup.hashCode(), secondLightsGroup.hashCode());
        secondLightsGroup = new BerlinUhrLichterngruppe(LocalTime.MAX);
        assertNotEquals(lightsGroup.hashCode(), secondLightsGroup.hashCode());
        lightsGroup = new BerlinUhrLichterngruppe(LocalTime.MAX);
        assertEquals(lightsGroup.hashCode(), secondLightsGroup.hashCode());
    }
    
    /**
     * Test of compareTo method, of class BerlinUhrLichterngruppe, implementing 
     * Comparable. Two light groups should be considered equal if they 
     * correspond to the same hour and same minute, and the second is of the 
     * same parity. If they differ in the hour and the minute, the earlier one 
     * should be less than and the later one should be greater than. This test 
     * does not prescribe what should happen if they differ only in the seconds.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        BerlinUhrLichterngruppe midnightGroup = new BerlinUhrLichterngruppe(LocalTime.MIDNIGHT);
        testTime = testTime.plusSeconds(1);
        BerlinUhrLichterngruppe localGroup = new BerlinUhrLichterngruppe(testTime);
        BerlinUhrLichterngruppe maxGroup = new BerlinUhrLichterngruppe(LocalTime.MAX);
        List<BerlinUhrLichterngruppe> sortedLights = new ArrayList<>();
        sortedLights.add(midnightGroup);
        sortedLights.add(lightsGroup);
        sortedLights.add(localGroup);
        sortedLights.add(maxGroup);
        List<BerlinUhrLichterngruppe> toBeSortedLights = new ArrayList<>();
        toBeSortedLights.add(localGroup);
        toBeSortedLights.add(maxGroup);
        toBeSortedLights.add(midnightGroup);
        toBeSortedLights.add(lightsGroup);
        Collections.sort(toBeSortedLights);
        assertEquals(sortedLights, toBeSortedLights);
    }
    
    /**
     * Test of constructor of class BerlinUhrLichterngruppe. Relies on 
     * <code>@Before</code> to set tested class instance to noon.
     */
    @Test
    public void testConstructor() {
        System.out.println("constructor");
        String assertionMessage = "Light should be on";
        assertTrue(assertionMessage, lightsGroup.funfStundenZeile[0].getStatus());
        assertTrue(assertionMessage, lightsGroup.funfStundenZeile[1].getStatus());
        assertionMessage = "Light should be off";
        assertFalse(assertionMessage, lightsGroup.funfStundenZeile[2].getStatus());
        assertFalse(assertionMessage, lightsGroup.funfStundenZeile[3].getStatus());
        assertionMessage = "Light should be on";
        assertTrue(assertionMessage, lightsGroup.eineStundeZeile[0].getStatus());
        assertTrue(assertionMessage, lightsGroup.eineStundeZeile[1].getStatus());
        assertionMessage = "Light should be off";
        assertFalse(assertionMessage, lightsGroup.eineStundeZeile[2].getStatus());
        assertFalse(assertionMessage, lightsGroup.eineStundeZeile[3].getStatus());
        for (int i = 0; i < 4; i++) {
            assertEquals(Color.RED, lightsGroup.funfStundenZeile[i].getColor());
            assertEquals(Color.RED, lightsGroup.eineStundeZeile[i].getColor());
            assertFalse(lightsGroup.eineMinuteZeile[i].getStatus());
            assertEquals(Color.ORANGE, lightsGroup.eineMinuteZeile[i].getColor());
        }
        assertFalse(assertionMessage, lightsGroup.rundeAnzeige.getStatus());
        assertEquals(Color.ORANGE, lightsGroup.rundeAnzeige.getColor());
        try {
            System.out.println("Fifth 5-hour light is of color " + lightsGroup.funfStundenZeile[4].getColor().toString());
            fail("There should only be four 5-hour lights");
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Trying to access fifth 5-hour light correctly triggered IndexOutOfBoundsException");
            System.out.println("IndexOutOfBoundsException has this message: \"" + ioobe.getMessage() + "\"");
        } catch (Exception e) {
            String failMessage = "Exception " + e.getClass().getName() + " is wrong exception for trying to access fifth 5-hour light";
            fail(failMessage);
        }
        try {
            System.out.println("Fifth 1-hour light is of color " + lightsGroup.eineStundeZeile[4].getColor().toString());
            fail("There should only be four 1-hour lights");
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Trying to access fifth 1-hour light correctly triggered IndexOutOfBoundsException");
            System.out.println("IndexOutOfBoundsException has this message: \"" + ioobe.getMessage() + "\"");
        } catch (Exception e) {
            String failMessage = "Exception " + e.getClass().getName() + " is wrong exception for trying to access fifth 1-hour light";
            fail(failMessage);
        }
        try {
            System.out.println("Twelfth 5-minute light is of color " + lightsGroup.funfMinutenZeile[11].getColor().toString());
            fail("There should only be eleven 5-minute lights");
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Trying to access twelfth 5-minute light correctly triggered IndexOutOfBoundsException");
            System.out.println("IndexOutOfBoundsException has this message: \"" + ioobe.getMessage() + "\"");
        } catch (Exception e) {
            String failMessage = "Exception " + e.getClass().getName() + " is wrong exception for trying to access twelfth 5-minute light";
            fail(failMessage);
        }
        try {
            System.out.println("Fifth 1-minute light is of color " + lightsGroup.eineMinuteZeile[4].getColor().toString());
            fail("There should only be four 1-minute lights");
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Trying to access fifth 1-minute light correctly triggered IndexOutOfBoundsException");
            System.out.println("IndexOutOfBoundsException has this message: \"" + ioobe.getMessage() + "\"");
        } catch (Exception e) {
            String failMessage = "Exception " + e.getClass().getName() + " is wrong exception for trying to access fifth 1-minute light";
            fail(failMessage);
        }
    }
    
}
