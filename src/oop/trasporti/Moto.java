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
public class Moto extends VeicoloTerrestre {
    
    private Tipo tipo;
    private Tempi tempi;
    
    public Moto(int cilindrata, Carburante carburante, double volumeSerbatoio, String targa, double coeffAttrito, Tipo tipo, Tempi tempi) {
        super(cilindrata, carburante, volumeSerbatoio, targa, coeffAttrito);
        
        this.tipo = tipo;
        this.tempi = tempi;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tempi getTempi() {
        return tempi;
    }

    public void setTempi(Tempi tempi) {
        this.tempi = tempi;
    }

    @Override
    public int velocitaMax() {
        int velocita = 100 + cilindrata / 100;
        
        switch(tipo) {
            case SCOOTER:
                velocita += 2;
                break;
            case STRADALE:
                velocita += 5;
                break;
            case SPORTIVA:
                velocita += 10;
                break;
            case NAKED:
                velocita += 4;
                break;
            case CROSS:
                velocita += 3;
        }
        
        return velocita;
    }

    @Override
    public String consumo() {
        double consumo = 16.0 * 1000.0 / cilindrata;
        consumo += consumo * Carburante.BENZINA.getOttani();
        
        switch(tipo) {
            case SCOOTER:
                consumo += 0.5;
                break;
            case STRADALE:
                consumo += 1.5;
                break;
            case SPORTIVA:
                consumo += 2.5;
                break;
            case NAKED:
                consumo += 2.0;
                break;
            case CROSS:
                consumo += 3.0;
        }
        
        return consumo + "Km/l";
    }

    @Override
    public double peso() {
        double peso = volumeSerbatoio * Carburante.BENZINA.getPesoSpecifico();
        
        switch(tipo) {
            case SCOOTER:
                peso += peso * 0.05;
                break;
            case STRADALE:
                peso += peso * 0.7;
                break;
            case SPORTIVA:
                peso += peso * 0.9;
                break;
            case NAKED:
                peso += peso * 0.5;
                break;
            case CROSS:
                peso += peso * 0.1;
        }
        
        return peso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cilindrata, carburante, volumeSerbatoio, targa, coeffAttrito, tipo, tempi);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Moto m = (Moto) obj;
        if (this.tipo != m.tipo) {
            return false;
        }
        
        return this.tempi == m.tempi;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(", tipo: ");
        builder.append(tipo);
        builder.append(", tempi: ");
        builder.append(tempi);
        
        return builder.toString();
    }
    
}
