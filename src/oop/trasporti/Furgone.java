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

import java.util.Objects;

/**
 *
 * @author Antonio
 */
public class Furgone extends VeicoloTerrestre {
    
    private double capacita;
    
    public Furgone(int cilindrata, Carburante carburante, double volumeSerbatoio, String targa, double coeffAttrito, double capacita) {
        super(cilindrata, carburante, volumeSerbatoio, targa, coeffAttrito);
        
        setCapacita(capacita);
    }

    public double getCapacita() {
        return capacita;
    }

    public void setCapacita(double capacita) {
        if(capacita < 0)
            throw new ValoriNegativiException();
        
        this.capacita = capacita;
    }

    @Override
    public int velocitaMax() {
        int velocita = 0;
        
        switch(carburante) {
            case BENZINA: case CHEROSENE:
                velocita = 180 + cilindrata / 100;
                break;
            case DIESEL:
                velocita = 150 + cilindrata / 100;
                break;
            case GPL:
                velocita = 170 + cilindrata / 100;
                break;
            case METANO:
                velocita = 160 + cilindrata / 100;
        }
        int tmp = (velocita % 10);
        velocita = ((tmp < 5) ? (velocita-tmp) : (velocita-tmp+10));
        
        return velocita;
    }

    @Override
    public String consumo() {
        double consumo = 0.0;
        
        switch(carburante) {
            case BENZINA:
                consumo = 18.0 * 1000.0 / cilindrata;
                consumo += consumo * Carburante.BENZINA.getOttani();
                break;
            case DIESEL:
                consumo = 22.0 * 1000.0 / cilindrata;
                consumo += consumo * Carburante.DIESEL.getOttani();
                break;
            case GPL:
                consumo = 26.0 * 1000.0 / cilindrata;
                consumo += consumo * Carburante.GPL.getOttani();
                break;
            case METANO:
                consumo = 24.0 * 1000.0 / cilindrata;
                consumo += consumo * Carburante.METANO.getOttani();
                break;
            case CHEROSENE:
                consumo = 18.0 * 1000.0 / cilindrata;
                consumo += consumo * Carburante.CHEROSENE.getOttani();
        }
        
        return consumo + "Km/l";
    }

    @Override
    public double peso() {
        double peso = 0.0;
        
        switch(carburante) {
            case BENZINA:
                peso = volumeSerbatoio * Carburante.BENZINA.getPesoSpecifico();
                break;
            case DIESEL:
                peso = volumeSerbatoio * Carburante.DIESEL.getPesoSpecifico();
                break;
            case GPL:
                peso = volumeSerbatoio * Carburante.GPL.getPesoSpecifico();
                break;
            case METANO:
                peso = volumeSerbatoio * Carburante.METANO.getPesoSpecifico();
                break;
            case CHEROSENE:
                peso = volumeSerbatoio * Carburante.CHEROSENE.getPesoSpecifico();
        }
        
        return peso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cilindrata, carburante, volumeSerbatoio, targa, coeffAttrito, capacita);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Furgone f = (Furgone) obj;
        
        return Double.doubleToLongBits(this.capacita) == Double.doubleToLongBits(f.capacita);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(", capacità: ");
        builder.append(capacita);
        
        return builder.toString();
    }
    
}
