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
package oop.time;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Antonio
 */
public class TempoJava1 implements Tempo {
    
    private Calendar data;

    public TempoJava1() {
        data = Calendar.getInstance();
    }

    @Override
    public void setTempo(int ore, int minuti, int secondi) {
        data.set(data.get(Calendar.YEAR), data.get(Calendar.MONTH), data.get(Calendar.DATE), ore, minuti, secondi);
    }

    @Override
    public void setData(int anno, int mese, int giorno) {
        data.set(anno, mese, giorno, data.get(Calendar.HOUR_OF_DAY), data.get(Calendar.MINUTE), data.get(Calendar.SECOND));
    }

    @Override
    public void setDataTempo(int anno, int mese, int giorno, int ore, int minuti, int secondi) {
        data.set(anno, mese, giorno, ore, minuti, secondi);
    }

    @Override
    public Date getDate() {
        return data.getTime();
    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return null;
    }

    @Override
    public String toString() {
        return getDate().toString();
    }
    
}
