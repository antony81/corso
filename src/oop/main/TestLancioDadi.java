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
package oop.main;

import static java.lang.System.out;
import java.util.Arrays;
import oop.util.Dado;
import oop.util.LancioDadi;

/**
 *
 * @author Antonio
 */
public class TestLancioDadi {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LancioDadi ld = new LancioDadi(3);
        Dado[] arr = ld.lancio();
        String s = Arrays.toString(arr);
        
        out.println(s);
    }
    
}
