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
import oop.util.Elemento;

/**
 *
 * @author Antonio
 */
public class TestEnumElemento {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        out.println("start main");
        out.println("---------------------------------------------------------------------");
        
        // usiamo il metodo printf per stampare
        Elemento[] arr = Elemento.values();
        out.printf("%s\t|      %s|\t     %s|\t%s%n", "simbolo", "num. atomico", "massa atomica", "nome");
        out.println("---------------------------------------------------------------------");
        for(Elemento e : arr) {
            if(e.getNumeroAtomico() < 10 && e.getMassaAtomica() < 10)
                out.printf("%s\t|\t\t  %d|\t\t  %f|\t%s%n", e.getSimbolo(), e.getNumeroAtomico(), e.getMassaAtomica(), e);
            if(e.getNumeroAtomico() < 10 && e.getMassaAtomica() >= 10 && e.getMassaAtomica() < 100)
                out.printf("%s\t|\t\t  %d|\t\t %f|\t%s%n", e.getSimbolo(), e.getNumeroAtomico(), e.getMassaAtomica(), e);
            if(e.getNumeroAtomico() >= 10 && e.getNumeroAtomico() < 100 && e.getMassaAtomica() < 10)
                out.printf("%s\t|\t\t %d|\t\t  %f|\t%s%n", e.getSimbolo(), e.getNumeroAtomico(), e.getMassaAtomica(), e);
            if(e.getNumeroAtomico() >= 10 && e.getNumeroAtomico() < 100 && e.getMassaAtomica() >= 10 && e.getMassaAtomica() < 100)
                out.printf("%s\t|\t\t %d|\t\t %f|\t%s%n", e.getSimbolo(), e.getNumeroAtomico(), e.getMassaAtomica(), e);
            if(e.getNumeroAtomico() >= 10 && e.getNumeroAtomico() < 100 && e.getMassaAtomica() >= 100 && e.getMassaAtomica() < 1000)
                out.printf("%s\t|\t\t %d|\t\t%f|\t%s%n", e.getSimbolo(), e.getNumeroAtomico(), e.getMassaAtomica(), e);
            if(e.getNumeroAtomico() >= 100 && e.getMassaAtomica() >= 100)
                out.printf("%s\t|\t\t%d|\t\t%f|\t%s%n", e.getSimbolo(), e.getNumeroAtomico(), e.getMassaAtomica(), e);
        }
        
        out.println("---------------------------------------------------------------------");
        out.println("end main");
    }
    
}
