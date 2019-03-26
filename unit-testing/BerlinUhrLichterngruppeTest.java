/*
 * Copyright (C) 2019 Alonso del Arte
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
 *
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
        for (int hh = 1; hh < 24; hh++) {
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
        for (int hh = 1; hh < 24; hh++) {
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
        for (int mm = 1; mm < 60; mm++) {
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
        for (int mm = 1; mm < 60; mm++) {
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
        System.out.println("decrementMinute");
        BerlinUhrLichterngruppe localLightsGroup;
        for (int ss = 1; ss < 60; ss++) {
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
        System.out.println("incrementMinute");
        BerlinUhrLichterngruppe localLightsGroup;
        for (int ss = 1; ss < 60; ss++) {
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
        BerlinUhrLichterngruppe maxGroup = new BerlinUhrLichterngruppe(LocalTime.MAX);
        List<BerlinUhrLichterngruppe> sortedLights = new ArrayList<>();
        sortedLights.add(midnightGroup);
        sortedLights.add(lightsGroup);
        sortedLights.add(maxGroup);
        List<BerlinUhrLichterngruppe> toBeSortedLights = new ArrayList<>();
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
    }
    
}
