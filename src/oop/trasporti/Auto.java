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
package oop.trasporti;

import oop.individui.Persona;

/**
 *
 * @author Antonio
 */
public class Auto extends Veicolo {
    
    private int posti;

    public Auto(String targa, int cilindrata, double consumo, Carburante carburante, Persona proprietario, int posti) {
        super(targa, cilindrata, consumo, carburante, proprietario);
        
        this.posti = posti;
    }

    public int getPosti() {
        return posti;
    }

    public void setPosti(int posti) {
        this.posti = posti;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auto a = (Auto) obj;
        if (this.cilindrata != a.cilindrata) {
            return false;
        }
        if (Double.doubleToLongBits(this.consumo) != Double.doubleToLongBits(a.consumo)) {
            return false;
        }
        if (this.carburante != a.carburante) {
            return false;
        }
        
        return this.posti == a.posti;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", posti=");
        builder.append(posti);
        
        return builder.toString();
    }
    
}
