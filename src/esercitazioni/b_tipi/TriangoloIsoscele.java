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
public class TriangoloIsoscele {
    
    public static void main(String[] args) {
        double base = 8;
        double altezza = 3;

        double area = base*altezza/2;
        double lato = Math.sqrt(Math.pow(altezza, 2)+Math.pow(base, 2)/4);
        double perimetro = base+lato*2;
        
        System.out.println("area triangolo = " + area);
        System.out.println("perimetro triangolo = " + perimetro);
    }
    
}
