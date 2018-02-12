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
package oop.matematica;

/**
 *
 * @author Antonio
 * 
 * Classe che risolve operazioni matematiche
 */
public class OperazioniMatematiche {
    
    /**
     * 
     * @param lato1 - un lato del triangolo
     * @param lato2 - un lato del triangolo
     * @return il valore dell'ipotenusa
     * 
     * Metodo che risolve il teorema di pitagora dati i valori di due lati.
     * Il metodo ritorna il valore dell'ipotenusa di un triangolo rettangolo.
     */
    public static double teoremaPitagoraIpotenusa(double lato1, double lato2) {
        return Math.sqrt(Math.pow(lato1, 2)+Math.pow(lato2, 2));
    }
    
    /**
     * 
     * @param ipotenusa - l'ipotenusa del triangolo
     * @param lato - un lato del triangolo
     * @return il valore del terzo lato
     * 
     * Metodo che risolve il teorema di pitagora che dati come valori
     * l'ipotenusa e un lato, calcola il valore del terzo lato di un triangolo
     * rettangolo.
     */
    public static double teoremaPitagoraLato(double ipotenusa, double lato) {
        return Math.sqrt(Math.pow(ipotenusa, 2)-Math.pow(lato, 2));
    }
    
}
