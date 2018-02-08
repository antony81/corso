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
package esercitazioni.b_tipi;

/**
 *
 * @author Antonio
 * 
 * Programma per capire l'uso dei tipi primitivi in Java e sfruttarli per
 * eseguire operazioni aritmetiche.
 */
public class Cerchio {
    
    public static void main(String[] args) {
        final double pgreco = 3.14;
        double raggio = 4;
        
        double area = Math.pow(raggio, 2)*pgreco;
        double perimetro = 2*raggio*pgreco;
        
        System.out.println("area cerchio = " + area);
        System.out.println("circonferenza cerchio = " + perimetro);
    }
    
}
