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

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop.matematica.DenominatoreNulloException;
import oop.matematica.Razionale;
import oop.matematica.RazionaleIO;

/**
 *
 * @author Antonio
 */
public class TestRazionale {
    
    private static final Scanner INPUT = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("digita 1 per creare e salvare un razionale, 2 per caricare un razionale");
        int scelta = INPUT.nextInt();
        switch(scelta) {
            case 1:
                salva();
                break;
            case 2:
                carica();
                break;
            default:
                System.out.println("scelta errata");
                System.out.println("programma terminato");
        }
        
        INPUT.close();
    }

    private static void salva() {
        System.out.println("inserisci il numeratore");
        int num = INPUT.nextInt();
        System.out.println("inserisci il denominatore");
        int den = INPUT.nextInt();
        Razionale r;
        try {
            r = new Razionale(num, den);
        } catch (DenominatoreNulloException ex) {
            Logger.getLogger(TestRazionale.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        System.out.println("provo a salvare il razionale: " + r);
        boolean esito = RazionaleIO.save(r);
        System.out.println(esito ? "razionale salvato" : "razionale non salvato");
    }

    private static void carica() {
        System.out.println("provo a caricare il razionale salvato");
        Razionale r = RazionaleIO.load();
        if(r != null)
            System.out.println("razionale caricato: " + r);
        else
            System.out.println("errore! razionale non caricato");
    }
    
}
