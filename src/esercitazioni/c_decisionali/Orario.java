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
package esercitazioni.c_decisionali;

import java.util.Scanner;

/**
 *
 * @author Antonio
 * 
 * Programma dimostrativo per testare le espressioni booleane e il costrutto
 * decisionale dell'if-else.
 */
public class Orario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci le ore");
        int ore = input.nextInt();
        System.out.println("inserisci le minuti");
        int minuti = input.nextInt();
        
        if(ore < 0 || ore > 23 || minuti < 0 || minuti > 59)
            System.out.println("non è un orario valido");
        else
            System.out.println("è un orario valido");
    }
    
}
