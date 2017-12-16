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
public class Furgone extends Veicolo {
    
    private double capacita;
    
    public Furgone(String targa, int cilindrata, double consumo, Carburante carburante, Persona proprietario, double capacita) {
        super(targa, cilindrata, consumo, carburante, proprietario);
        
        this.capacita = capacita;
    }

    public double getCapacita() {
        return capacita;
    }

    public void setCapacita(double capacita) {
        this.capacita = capacita;
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
        final Furgone f = (Furgone) obj;
        if (this.cilindrata != f.cilindrata) {
            return false;
        }
        if (Double.doubleToLongBits(this.consumo) != Double.doubleToLongBits(f.consumo)) {
            return false;
        }
        if (this.carburante != f.carburante) {
            return false;
        }
        
        return Double.doubleToLongBits(this.capacita) == Double.doubleToLongBits(f.capacita);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", capacità=");
        builder.append(capacita);
        
        return builder.toString();
    }
    
}
