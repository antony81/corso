/*
* Copyright (C) 2017 Antonio
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

/**
 *
 * @author Antonio
 */
public class StringMatcher {
    
    /*
    * returns true if the string matches exactly "true"
    */
    public boolean isTrue(String s) {
        return s.matches("true");
    }
    
    /*
    * returns true if the string matches exactly "true" or "True"
    */
    public boolean isTrueVersion2(String s) {
        return s.matches("[tT]rue");
    }
    
    /*
    * returns true if the string matches exactly "true" or "True"
    * or "yes" or "Yes"
    */
    public boolean isTrueOrYes(String s) {
        return s.matches("[tT]rue|[yY]es");
    }
    
    /*
    * returns true if the string contains exactly "true"
    */
    public boolean containsTrue(String s) {
        return s.matches(".*true.*");
    }
    
    /*
    * returns true if the string contains of three letters
    */
    public boolean isThreeLetters(String s) {
        return s.matches("[a-zA-Z]{3}"); // simpler from for return s.matches("[a-Z][a-Z][a-Z]");
    }
    
    /*
    * returns true if the string does not have a number at the beginning
    */
    public boolean isNoNumberAtBeginning(String s) {
        return s.matches("^[^\\d].*");
    }
    
    /*
    * returns true if the string contains a arbitrary number of characters except b
    */
    public boolean isIntersection(String s) {
        return s.matches("([\\w&&[^b]])*");
    }
    
    /*
    * returns true if the string contains a number less than 300
    */
    public boolean isLessThenThreeHundred(String s) {
        return s.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*");
    }
    
    /*
    * returns true if the string is a valid email
    */
    public boolean isEmail(String s) {
        return s.matches("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
    }
    
}
