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
public class AutoTest {
    
    private static Auto instance;
    
    public AutoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Auto(1100, Carburante.BENZINA, 40.5, "KB512RX", 0.3, Tipo.UTILITARIA);
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
     * Test of getCilindrata method, of class Auto (inherited from class AbstractVeicolo).
     */
    @Test
    public void testGetCilindrata() {
        System.out.println("getCilindrata");
        assertEquals(1100, instance.getCilindrata());
        assertNotEquals(2000, instance.getCilindrata());
    }
    
    /**
     * Test of setCilindrata method, of class Auto (inherited from class AbstractVeicolo).
     */
    @Test(expected = ValoriNegativiException.class)
    public void testSetCilindrata() {
        System.out.println("setCilindrata");
        instance.setCilindrata(-1000);
    }

    /**
     * Test of getCarburante method, of class Auto (inherited from class AbstractVeicolo).
     */
    @Test
    public void testGetCarburante() {
        System.out.println("getCarburante");
        assertEquals(Carburante.BENZINA, instance.getCarburante());
        assertNotEquals(Carburante.DIESEL, instance.getCarburante());
    }
    
    /**
     * Test of getVolumeSerbatoio method, of class Auto (inherited from class AbstractVeicolo).
     */
    @Test
    public void testGetVolumeSerbatoio() {
        System.out.println("getVolumeSerbatoio");
        assertEquals(40.5, instance.getVolumeSerbatoio(), 0.05);
        assertNotEquals(110.4, instance.getVolumeSerbatoio(), 0.05);
    }
    
    /**
     * Test of setVolumeSerbatoio method, of class Auto (inherited from class AbstractVeicolo).
     */
    @Test(expected = ValoriNegativiException.class)
    public void testSetVolumeSerbatoio() {
        System.out.println("setVolumeSerbatoio");
        instance.setVolumeSerbatoio(-30.7);
    }
    
    /**
     * Test of getTarga method, of class Auto (inherited from class VeicoloTerrestre).
     */
    @Test
    public void testGetTarga() {
        System.out.println("getTarga");
        assertEquals("KB512RX", instance.getTarga());
        assertNotEquals("KB123RX", instance.getTarga());
    }
    
    /**
     * Test of setTarga method, of class Auto (inherited from class VeicoloTerrestre).
     */
    @Test(expected = TargaInvalidaException.class)
    public void testSetTarga() {
        System.out.println("setTarga");
        instance.setTarga("hello");
    }
    
    /**
     * Test of getCoeffAttrito method, of class Auto (inherited from class VeicoloTerrestre).
     */
    @Test
    public void testGetCoeffAttrito() {
        System.out.println("getCoeffAttrito");
        assertEquals(0.3, instance.getCoeffAttrito(), 0.05);
        assertNotEquals(0.4, instance.getCoeffAttrito(), 0.05);
    }

    /**
     * Test of getTipo method, of class Auto.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        assertEquals(Tipo.UTILITARIA, instance.getTipo());
        assertNotEquals(Tipo.SUV, instance.getTipo());
    }

    /**
     * Test of velocitaMax method, of class Auto.
     */
    @Test
    public void testVelocitaMax() {
        System.out.println("velocitaMax");
        assertNotEquals(0, instance.velocitaMax());
        assertNotEquals(-1, instance.velocitaMax());
    }

    /**
     * Test of consumo method, of class Auto.
     */
    @Test
    public void testConsumo() {
        System.out.println("consumo");
        String result = instance.consumo();
        int index = result.indexOf("K");
        assertEquals("Km/l", result.substring(index));
    }

    /**
     * Test of peso method, of class Auto.
     */
    @Test
    public void testPeso() {
        System.out.println("peso");
        assertNotEquals(0.0, instance.peso(), 0.0);
    }
    
}
