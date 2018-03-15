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
 * Classe che dimostra come utilizzare il costrutto decisionale dello switch
 * e come inserire dati in input dal prompt dei comandi utilizzando la classe
 * Scanner presente nel package java.util della libreria.
 */
public class Giorni {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci 1 per testare switch, 2 per testare if, qualsiasi altro numero per terminare");
        int scelta = input.nextInt();
        while(scelta == 1 || scelta == 2) {
            if(scelta == 1) {
                System.out.println("inserisci un numero da 1 a 7");
                scelta = input.nextInt();
                stampaGiornoSwitch(scelta);
            } else if(scelta == 2) {
                System.out.println("inserisci un numero da 1 a 7");
                scelta = input.nextInt();
                stampaGiornoIf(scelta);
            }
            System.out.println("inserisci 1 per testare switch, qualsiasi altro numero per terminare");
            scelta = input.nextInt();
        }
        System.out.println("scelta errata");
    }
    
    private static void stampaGiornoSwitch(int scelta) {
        switch(scelta) {
            case 1:
                System.out.println("lunedi'");
                break;
            case 2:
                System.out.println("martedi'");
                break;
            case 3:
                System.out.println("mercoledi'");
                break;
            case 4:
                System.out.println("giovedi'");
                break;
            case 5:
                System.out.println("venerdi'");
                break;
            case 6:
                System.out.println("sabato");
                break;
            case 7:
                System.out.println("domenica");
                break;
            default:
                System.out.println("scelta errata");
        }
    }
    
    private static void stampaGiornoIf(int scelta) {
        if(scelta == 1)
            System.out.println("lunedi'");
        else if(scelta == 2)
            System.out.println("martedi'");
        else if(scelta == 3)
            System.out.println("mercoledi'");
        else if(scelta == 4)
            System.out.println("giovedi'");
        else if(scelta == 5)
            System.out.println("venerdi'");
        else if(scelta == 6)
            System.out.println("sabato");
        else if(scelta == 7)
            System.out.println("domenica");
        else
            System.out.println("scelta errata");
    }
    
}
