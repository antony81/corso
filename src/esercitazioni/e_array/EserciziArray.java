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

/**
 *
 * @author Antonio
 * 
 * Classe che contiene metodi statici.
 * Il metodo 'trovaMassimo' accetta 
 */
public class EserciziArray {
    
    /**
     * 
     * @param arr
     * @return la somma degli elementi presenti in arr
     * 
     * Metodo che calcola la somma degli elementi di un array passato come
     * parametro.
     */
    public static double sommaElementi(double[] arr) {
        double somma = 0;
        
        for(double x : arr)
            somma += x;
        
        return somma;
    }
    
    /**
     * 
     * @param arr
     * @return il valore massimo tra tutti gli elementi dell'array passato
     * come parametro.
     */
    public static int trovaMassimo(int[] arr) {
        int max = 0;
        
        for(int x : arr)
            if(x > max)
                max = x;
        
        return max;
    }
    
}
