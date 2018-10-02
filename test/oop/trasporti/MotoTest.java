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
public class MotoTest {
    
    private static Moto instance;
    
    public MotoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Moto(600, Carburante.BENZINA, 20.4, "TY999ZR", 0.1, Tipo.SPORTIVA, Tempi.QUATTRO);
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
     * Test of getTipo method, of class Moto.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Tipo result = instance.getTipo();
        assertEquals(Tipo.SPORTIVA, result);
        assertNotEquals(Tipo.NAKED, result);
    }

    /**
     * Test of getTempi method, of class Moto.
     */
    @Test
    public void testGetTempi() {
        System.out.println("getTempi");
        Tempi result = instance.getTempi();
        assertEquals(Tempi.QUATTRO, result);
        assertNotEquals(Tempi.DUE, result);
    }
    
}
