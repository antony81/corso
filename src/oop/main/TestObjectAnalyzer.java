/*
 * Copyright (C) 2018 Antonio
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
import oop.banca.ContoBancario;
import oop.banca.ContoEsteso;
import oop.matematica.DenominatoreNulloException;
import oop.matematica.Razionale;
import oop.reflection.ObjectAnalyzer;

/**
 *
 * @author Antonio
 */
public class TestObjectAnalyzer {
    
    public static void main(String[] args) {
        try {
            Razionale r1 = new Razionale(3, 4);
            System.out.println(new ObjectAnalyzer().toString(r1));
            ContoBancario cb1 = new ContoBancario("CB001", 4000.0);
            System.out.println(new ObjectAnalyzer().toString(cb1));
            ContoEsteso ce1 = new ContoEsteso("CE001", 7000.0, 4000.0);
            System.out.println(new ObjectAnalyzer().toString(ce1));
        } catch (DenominatoreNulloException ex) {
            Logger.getLogger(TestObjectAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
