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
package esercitazioni.d_iterativi;

import java.util.Scanner;

/**
 *
 * @author Antonio
 */
public class QuadratiPerfetti {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci un  numero intero");
        int numero = input.nextInt();
        if(numero < 0)
            numero = Math.abs(numero);
        
        for(int n = 0; n <= numero; n++)
            System.out.println("quadrato di " + n + " = " + (int) Math.pow(n, 2));
    }
    
}
