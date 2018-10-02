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
public class Auto extends VeicoloTerrestre {
    
    private Tipo tipo;

    public Auto(int cilindrata, Carburante carburante, double volumeSerbatoio, String targa, double coeffAttrito, Tipo tipo) {
        super(cilindrata, carburante, volumeSerbatoio, targa, coeffAttrito);
        
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public int velocitaMax() {
        int velocita = 0;
        
        switch(carburante) {
            case BENZINA: case CHEROSENE:
                velocita = 190 + cilindrata / 100;
                break;
            case DIESEL:
                velocita = 160 + cilindrata / 100;
                break;
            case GPL:
                velocita = 180 + cilindrata / 100;
                break;
            case METANO:
                velocita = 170 + cilindrata / 100;
        }
        int tmp = (velocita % 10);
        velocita = ((tmp < 5) ? (velocita-tmp) : (velocita-tmp+10));
        switch(tipo) {
            case UTILITARIA:
                velocita += 20;
                break;
            case STATION_WAGON:
                velocita += 10;
                break;
            case SUV:
                velocita += 30;
                break;
            case SUPERCAR:
                velocita += 50;
        }
        
        return velocita;
    }

    @Override
    public String consumo() {
        double consumo = 0.0;
        
        switch(carburante) {
            case BENZINA:
                consumo = 16.0 * 1000.0 / cilindrata;
                consumo += consumo * Carburante.BENZINA.getOttani();
                break;
            case DIESEL:
                consumo = 20.0 * 1000.0 / cilindrata;
                consumo += consumo * Carburante.DIESEL.getOttani();
                break;
            case GPL:
                consumo = 24.0 * 1000.0 / cilindrata;
                consumo += consumo * Carburante.GPL.getOttani();
                break;
            case METANO:
                consumo = 22.0 * 1000.0 / cilindrata;
                consumo += consumo * Carburante.METANO.getOttani();
                break;
            case CHEROSENE:
                consumo = 16.0 * 1000.0 / cilindrata;
                consumo += consumo * Carburante.CHEROSENE.getOttani();
        }
        switch(tipo) {
            case UTILITARIA:
                consumo += 2.0;
                break;
            case STATION_WAGON:
                consumo += 2.5;
                break;
            case SUV:
                consumo += 1.5;
                break;
            case SUPERCAR:
                consumo += 0.5;
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
        switch(tipo) {
            case UTILITARIA:
                peso += peso * 0.2;
                break;
            case STATION_WAGON:
                peso += peso * 0.5;
                break;
            case SUV:
                peso += peso * 0.4;
                break;
            case SUPERCAR:
                peso += peso * 0.3;
        }
        
        return peso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cilindrata, carburante, volumeSerbatoio, targa, coeffAttrito, tipo);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auto a = (Auto) obj;
        
        return this.tipo == a.tipo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(", tipo: ");
        builder.append(tipo);
        
        return builder.toString();
    }
    
}
