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
package oop.time;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author Antonio
 * 
 * Interfaccia che dimostra, a partire dalla versione 1.8 di Java, come usare
 * i metodi di default e statici.
 */
public interface Tempo {
    
    void setTempo(int ore, int minuti, int secondi);
    
    void setData(int anno, int mese, int giorno);
    
    void setDataTempo(int anno, int mese, int giorno, int ore, int minuti, int secondi);
    
    LocalDateTime getLocalDateTime();
    
    default ZonedDateTime getZonedDateTime(String zona) {
        return ZonedDateTime.of(getLocalDateTime(), getZoneId(zona));
    }

    static ZoneId getZoneId(String zona) {
        try {
            return ZoneId.of(zona);
        } catch(DateTimeException e) {
            System.err.println("zona " + zona + " non valida; verrà utilizzata quella di default");
            
            return ZoneId.systemDefault();
        }
    }
    
}
