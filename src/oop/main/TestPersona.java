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

import java.time.LocalDate;
import java.util.Arrays;
import oop.individui.Persona;
import oop.individui.PersonaIO;

/**
 *
 * @author Antonio
 */
public class TestPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Persona p1 = new Persona("p1", "Mario", "Rossi", LocalDate.of(1998, 11, 23), "Milano", "MI", 'M');
        Persona p2 = new Persona("p2", "Paolo", "Rossi", LocalDate.of(1998, 8, 12), "Roma", "RM", 'M');
        
        boolean esito = PersonaIO.save(p1);
        System.out.println(esito ? "OK" : "KO");
        esito = PersonaIO.save(p2);
        System.out.println(esito ? "OK" : "KO");*/
        
        String s[] = PersonaIO.load().split("[, ]+");
        for(String str : s)
            System.out.println(str);
    }
    
}
