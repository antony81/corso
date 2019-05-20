/*
 * Copyright (C) 2019 Antonio
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

import java.time.ZoneId;
import oop.time.Tempo;
import oop.time.TempoJava1;
import oop.time.TempoJava8;

/**
 *
 * @author Antonio
 */
public class TestTempo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tempo t1 = new TempoJava1();
        t1.setData(1998, 2, 21);
        System.out.println("t1: " + t1);
        
        System.out.println("-------------------------------------");
        Tempo t2 = new TempoJava8();
        System.out.println("t2: " + t2);
        System.out.println("zoned: " + t2.getZonedDateTime(ZoneId.SHORT_IDS.get("IET")));
        System.out.println("zone id: " + Tempo.getZoneId(ZoneId.SHORT_IDS.get("ECT")));
    }
    
}
