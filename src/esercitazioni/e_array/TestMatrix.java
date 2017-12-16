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
package esercitazioni.e_array;

import static java.lang.Math.random;
import static java.lang.System.out;

/**
 *
 * @author Antonio
 */
public class TestMatrix {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        out.println("start main");
        out.println("------------------------------");
        
        int matrix[][] = new int[4][3];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (random()*90+1);
            }
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] < 10)
                    out.print(" ");
                out.print(matrix[i][j] + " ");
            }
            out.println();
        }
        
        out.println("------------------------------");
        out.println("end main");
    }
    
}
