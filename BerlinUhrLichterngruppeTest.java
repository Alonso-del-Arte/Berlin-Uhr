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

import java.time.LocalTime;
import javafx.scene.paint.Color;

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
    
    public BerlinUhrLichterngruppeTest() {
    }
    
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
        lightsGroup = new BerlinUhrLichterngruppe(LocalTime.NOON);
        System.out.println("Tested class instance re-initialized to noon");
    }
    
    @After
    public void tearDown() {
        testTime = lightsGroup.getTime();
        System.out.println("Tested class instance exited test with time " + testTime.toString());
    }

    /**
     * Test of setTime method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        BerlinUhrLichterngruppe instance = new BerlinUhrLichterngruppe(testTime);
        instance.setTime(testTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTime method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        BerlinUhrLichterngruppe instance = new BerlinUhrLichterngruppe(testTime);
        LocalTime result = instance.getTime();
        assertEquals(testTime, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decrementHour method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testDecrementHour() {
        System.out.println("decrementHour");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementHour method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testIncrementHour() {
        System.out.println("incrementHour");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decrementMinute method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testDecrementMinute() {
        System.out.println("decrementMinute");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementMinute method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testIncrementMinute() {
        System.out.println("incrementMinute");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of decrementMinute method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testDecrementSecond() {
        System.out.println("decrementMinute");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementMinute method, of class BerlinUhrLichterngruppe.
     */
    @Test
    public void testIncrementSecond() {
        System.out.println("incrementMinute");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
