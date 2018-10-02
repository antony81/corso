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
package oop.trasporti;

import java.util.Objects;

/**
 *
 * @author Antonio
 */
public abstract class AbstractVeicolo implements Veicolo {
    
    protected int cilindrata;
    protected Carburante carburante;
    protected double volumeSerbatoio;

    public AbstractVeicolo(int cilindrata, Carburante carburante, double volumeSerbatoio) {
        setCilindrata(cilindrata);
        setCarburante(carburante);
        setVolumeSerbatoio(volumeSerbatoio);
    }

    public final int getCilindrata() {
        return cilindrata;
    }

    public final void setCilindrata(int cilindrata) {
        if(cilindrata < 0)
            throw new ValoriNegativiException();
        
        this.cilindrata = cilindrata;
    }

    public final Carburante getCarburante() {
        return carburante;
    }

    public final void setCarburante(Carburante carburante) {
        this.carburante = carburante;
    }

    public final double getVolumeSerbatoio() {
        return volumeSerbatoio;
    }

    public final void setVolumeSerbatoio(double volumeSerbatoio) {
        if(volumeSerbatoio < 0)
            throw new ValoriNegativiException();
        
        this.volumeSerbatoio = volumeSerbatoio;
    }

    @Override
    public int velocitaMedia() {
        return velocitaMax() / 2;
    }

    @Override
    public double energiaCinetica() {
        return 0.5 * peso() * Math.pow(velocitaMedia(), 2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cilindrata, carburante, volumeSerbatoio);
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
        final AbstractVeicolo av = (AbstractVeicolo) obj;
        if (this.cilindrata != av.cilindrata) {
            return false;
        }
        if (Double.doubleToLongBits(this.volumeSerbatoio) != Double.doubleToLongBits(av.volumeSerbatoio)) {
            return false;
        }
        return this.carburante == av.carburante;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("cilindrata: ");
        builder.append(cilindrata);
        builder.append(", carburante: ");
        builder.append(carburante);
        builder.append(", volume serbatoio: ");
        builder.append(volumeSerbatoio);
        
        return builder.toString();
    }
    
}
