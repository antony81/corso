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

import java.util.logging.Level;
import java.util.logging.Logger;
import oop.matematica.DenominatoreNulloException;
import oop.matematica.EsponenteException;
import oop.matematica.Monomio;
import oop.matematica.Polinomio;
import oop.matematica.Razionale;

/**
 *
 * @author Antonio
 */
public class TestPolinomio {
    
    public static void main(String[] args) {
        try {
            Razionale r1 = new Razionale(10, 4);
            Razionale r2 = new Razionale(-22, 6);
            Razionale r3 = new Razionale(1, -10);
            
            Monomio m1 = new Monomio(r1, 2);
            Monomio m2 = new Monomio(r2, 1);
            Monomio m3 = new Monomio(r3, 0);
            
            Polinomio p1 = new Polinomio();
            p1.aggiungi(m2);
            p1.aggiungi(m1);
            p1.aggiungi(m3);
            p1.ordina();
            
            System.out.println("polinomio: " + p1);
            System.out.println("soluzioni: " + p1.soluzione());
        } catch (DenominatoreNulloException | EsponenteException ex) {
            Logger.getLogger(TestPolinomio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
