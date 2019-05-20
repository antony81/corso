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
package oop.app;

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
public class AppRazionale {
        
    public void init(Scanner scanner) {
        Razionale r = null;
        boolean exit = false;
        do {
            System.out.println("scegli un operazione");
            System.out.println("0. per terminare il programma");
            System.out.println("1. per creare un razionale");
            System.out.println("2. per salvare un razionale");
            System.out.println("3. per caricare un razionale");
            int scelta = scanner.nextInt();
            switch(scelta) {
                case 0:
                    exit = true;
                    System.out.println("programma terminato");
                    break;
                case 1:
                    r = crea(scanner);
                    break;
                case 2:
                    salva(r);
                    break;
                case 3:
                    r = carica();
                    break;
                default:
                    System.out.println("scelta errata\n\n\n");
            }
        } while(!exit);
    }

    private Razionale crea(Scanner scanner) {
        int num, den;
        do {
            System.out.println("inserisci il numeratore");
            num = scanner.nextInt();
            System.out.println("inserisci il denominatore (diverso da zero");
            den = scanner.nextInt();
            if(den == 0)
                System.out.println("il denominatore non può essere zero");
        } while(den == 0);
        
        Razionale r = null;
        try {
            r = new Razionale(num, den);
            System.out.println("il razionale " + r + " è stato creato correttamente");
        } catch (DenominatoreNulloException ex) {
            Logger.getLogger(AppRazionale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }

    private void salva(Razionale r) {
        System.out.println("provo a salvare il razionale " + r + "\n...");
        boolean esito = RazionaleIO.save(r);
        System.out.println(esito ? "razionale salvato correttamente" : "non è possibile salvare il razionale");
    }

    private Razionale carica() {
        System.out.println("provo a caricare il razionale\n...");
        Razionale r = RazionaleIO.load();
        if(r != null)
            System.out.println("il razionale " + r + " è stato caricato correttamente");
        else
            System.out.println("non è possibile caricare il razionale");
        
        return r;
    }
    
}
