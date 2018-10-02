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
package oop.regex;

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
public class StringMatcherTest {
    
    private static StringMatcher instance;
    
    public StringMatcherTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = new StringMatcher();
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
     * Test of isTrue method, of class StringMatcher.
     */
    @Test
    public void testIsTrue() {
        System.out.println("isTrue");
        assertTrue(instance.isTrue("true"));
        assertFalse(instance.isTrue("true2"));
        assertFalse(instance.isTrue("True"));
    }

    /**
     * Test of isTrueVersion2 method, of class StringMatcher.
     */
    @Test
    public void testIsTrueVersion2() {
        System.out.println("isTrueVersion2");
        assertTrue(instance.isTrueVersion2("true"));
        assertFalse(instance.isTrueVersion2("true2"));
        assertTrue(instance.isTrueVersion2("True"));
    }

    /**
     * Test of isTrueOrYes method, of class StringMatcher.
     */
    @Test
    public void testIsTrueOrYes() {
        System.out.println("isTrueOrYes");
        assertTrue(instance.isTrueOrYes("true"));
        assertTrue(instance.isTrueOrYes("yes"));
        assertTrue(instance.isTrueOrYes("Yes"));
        assertFalse(instance.isTrueOrYes("no"));
    }

    /**
     * Test of containsTrue method, of class StringMatcher.
     */
    @Test
    public void testContainsTrue() {
        System.out.println("containsTrue");
        assertTrue(instance.containsTrue("thetruewithin"));
    }

    /**
     * Test of isThreeLetters method, of class StringMatcher.
     */
    @Test
    public void testIsThreeLetters() {
        System.out.println("isThreeLetters");
        assertTrue(instance.isThreeLetters("abc"));
        assertFalse(instance.isThreeLetters("abcd"));
    }

    /**
     * Test of isValidPlate method, of class StringMatcher.
     */
    @Test
    public void isValidPlate() {
        System.out.println("isValidPlate");
        assertTrue(instance.isValidPlate("CK987VV"));
        assertFalse(instance.isValidPlate("D9D44KL"));
    }

    /**
     * Test of isNoNumberAtBeginning method, of class StringMatcher.
     */
    @Test
    public void testIsNoNumberAtBeginning() {
        System.out.println("isNoNumberAtBeginning");
        assertTrue(instance.isNoNumberAtBeginning("abc"));
        assertFalse(instance.isNoNumberAtBeginning("1abcd"));
        assertTrue(instance.isNoNumberAtBeginning("a1bcd"));
        assertTrue(instance.isNoNumberAtBeginning("asdfdsf"));
    }

    /**
     * Test of isIntersection method, of class StringMatcher.
     */
    @Test
    public void testIsIntersection() {
        System.out.println("isIntersection");
        assertTrue(instance.isIntersection("1"));
        assertFalse(instance.isIntersection("abcksdfkdskfsdfdsf"));
        assertTrue(instance.isIntersection("skdskfjsmcnxmvjwque484242"));
    }

    /**
     * Test of isLessThenThreeHundred method, of class StringMatcher.
     */
    @Test
    public void testIsLessThenThreeHundred() {
        System.out.println("isLessThenThreeHundred");
        assertTrue(instance.isLessThenThreeHundred("288"));
        assertFalse(instance.isLessThenThreeHundred("3288"));
        assertFalse(instance.isLessThenThreeHundred("328 8"));
        assertTrue(instance.isLessThenThreeHundred("1"));
        assertTrue(instance.isLessThenThreeHundred("99"));
        assertFalse(instance.isLessThenThreeHundred("300"));
    }

    /**
     * Test of isEmail method, of class StringMatcher.
     */
    @Test
    public void testIsEmail() {
        System.out.println("isEmail");
        assertTrue(instance.isEmail("ciao@mondo.net"));
        assertFalse(instance.isEmail("paolo.rossi@email"));
        assertFalse(instance.isEmail("hello"));
        assertTrue(instance.isEmail("mario.rossi.81@gmail.com"));
        assertTrue(instance.isEmail("sara-verdi_90@tim.ital"));
        assertFalse(instance.isEmail("300@abc.d"));
    }
    
}
