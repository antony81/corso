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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Antonio
 * 
 * Classe che implementa l'interfaccia Tempo. La classe fa l'override dei
 * metodi dell'interfaccia tranne quello di default e quello static.
 * Infatti i metodi di default possono essere sovrascritti opzionalmente,
 * quelli static, invece, non possono essere sovrascritti.
 */
public class TempoImpl implements Tempo {
    
    private LocalDateTime data;
    
    public TempoImpl() {
        data = LocalDateTime.now();
    }

    @Override
    public void setTempo(int ore, int minuti, int secondi) {
        LocalDate dataCorrente = LocalDate.from(data);
        LocalTime nuovoTempo = LocalTime.of(ore, minuti, secondi);
        data = LocalDateTime.of(dataCorrente, nuovoTempo);
    }

    @Override
    public void setData(int anno, int mese, int giorno) {
        LocalDate nuovaData = LocalDate.of(anno, mese, giorno);
        LocalTime tempoCorrente = LocalTime.from(data);
        data = LocalDateTime.of(nuovaData, tempoCorrente);
    }

    @Override
    public void setDataTempo(int giorno, int mese, int anno, int ore, int minuti, int secondi) {
        LocalDate nuovaData = LocalDate.of(giorno, mese, anno);
        LocalTime nuovoTempo = LocalTime.of(ore, minuti, secondi);
        data = LocalDateTime.of(nuovaData, nuovoTempo);
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
    
}
