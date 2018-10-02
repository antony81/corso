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
import oop.regex.StringMatcher;

/**
 *
 * @author Antonio
 */
public abstract class VeicoloTerrestre extends AbstractVeicolo {
    
    protected String targa;
    protected double coeffAttrito;

    public VeicoloTerrestre(int cilindrata, Carburante carburante, double volumeSerbatoio, String targa, double coeffAttrito) {
        super(cilindrata, carburante, volumeSerbatoio);
        
        setTarga(targa);
        setCoeffAttrito(coeffAttrito);
    }

    public final String getTarga() {
        return targa;
    }

    public final void setTarga(String targa) {
        StringMatcher sm = new StringMatcher();
        if(!sm.isValidPlate(targa))
            throw new TargaInvalidaException();
        
        this.targa = targa;
    }

    public final double getCoeffAttrito() {
        return coeffAttrito;
    }

    public final void setCoeffAttrito(double coeffAttrito) {
        this.coeffAttrito = coeffAttrito;
    }

    @Override
    public double spazioFrenata() {
        return Math.pow(velocitaMedia(), 2) / (2D * G * coeffAttrito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cilindrata, carburante, volumeSerbatoio, targa, coeffAttrito);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VeicoloTerrestre other = (VeicoloTerrestre) obj;
        if (Double.doubleToLongBits(this.coeffAttrito) != Double.doubleToLongBits(other.coeffAttrito)) {
            return false;
        }
        
        return Objects.equals(this.targa, other.targa);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(", targa: ");
        builder.append(targa);
        
        return builder.toString();
    }
    
}
