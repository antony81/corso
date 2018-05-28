/*
 * Copyright (C) 2018 Consultant
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
 * @author Consultant
 */
public abstract class VeicoloTerrestre extends AbstractVeicolo {
    
    protected String targa;

    public VeicoloTerrestre(int cilindrata, Carburante carburante, double volumeSerbatoio, String targa) {
        super(cilindrata, carburante, volumeSerbatoio);
        
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 67 * hash + Objects.hashCode(this.targa);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VeicoloTerrestre vt = (VeicoloTerrestre) obj;
        
        return Objects.equals(this.targa, vt.targa);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(", targa: ");
        builder.append(targa);
        
        return builder.toString();
    }
    
}
