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
 * Classe che estende 'Exception' per rappresentare una eccezione personalizzata
 * (una 'Checked Exception'), la quale indica che un razionale non può avere un
 * denominatore uguale a zero.
 */
public class DenominatoreNulloException extends Exception {

    private static final long serialVersionUID = -4484567940687144099L;

    /**
     * Metodo costruttore di default
     */
    public DenominatoreNulloException() {
    }
    
}
