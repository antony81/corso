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
import oop.util.Giorno;

/**
 *
 * @author Antonio
 */
public class TestEnumGiorno {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        out.println("start main");
        out.println("------------------------------");
        
        // scegliamo un valore
        Giorno giorno = Giorno.VENERDI;
        
        // definiamo una logica usando il costrutto switch
        switch(giorno) {
            case LUNEDI:
                out.println("Oggi è Lunedì");
                break;
            case MARTEDI:
                out.println("Oggi è Martedì");
                break;
            case MERCOLEDI:
                out.println("Oggi è Mercoledì");
                break;
            case GIOVEDI:
                out.println("Oggi è Giovedì");
                break;
            case VENERDI:
                out.println("Oggi è Venerdì");
                break;
            case SABATO:
                out.println("Oggi è Sabato");
                break;
            case DOMENICA:
                out.println("Oggi è Domenica");
        }
        
        out.println("------------------------------");
        
        // facciamo uso del metodo statico (values) implicito negli enum
        Giorno[] arr = Giorno.values();
        out.println("Giorni della settimana:\n");
        for(Giorno g : arr)
            out.println(g);
        
        out.println("------------------------------");
        // facciamo uso del metodo statico (valueOf) implicito negli enum
        Giorno g = Giorno.valueOf("DOMENICA"); // occhio al case sensitive
        out.println("Giorno scelto: " + g);
        
        out.println("------------------------------");
        out.println("end main");
    }
}
