/*
 * Copyright (C) 2018 Antonio
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package oop.trasporti;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class FurgoneTest {
    
    private static Furgone instance;
    
    public FurgoneTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Furgone(2000, Carburante.DIESEL, 50.3, "HJ313PP", 0.6, 100.14);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCapacita method, of class Furgone.
     */
    @Test
    public void testGetCapacita() {
        System.out.println("getCapacita");
        assertEquals(100.14, instance.getCapacita(), 0.005);
        assertNotEquals(10.14, instance.getCapacita(), 0.005);
    }

    /**
     * Test of setCapacita method, of class Furgone.
     */
    @Test(expected = ValoriNegativiException.class)
    public void testSetCapacita() {
        System.out.println("setCapacita");
        instance.setCapacita(-70.33);
    }
    
}
