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
package oop.matematica;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop.util.LoggerFactory;

/**
 *
 * @author Antonio
 */
public class Razionale implements Comparable<Razionale> {
    
    private int numeratore;
    private int denominatore;
    
    private static int count = 0;
    
    private final static Logger LOGGER = LoggerFactory.getLogger(Razionale.class);
    
    public Razionale() {
        this.numeratore = 0;
        this.denominatore = 1;
        
        count++;
    }
    
    public Razionale(int numeratore, int denominatore) throws DenominatoreNulloException {
        if(denominatore == 0)
            throw new DenominatoreNulloException();
        
        int mcd = mcd(Math.abs(numeratore), Math.abs(denominatore));
        
        this.numeratore = numeratore/mcd;
        this.denominatore = denominatore/mcd;
        
        if(this.denominatore < 0) {
            this.numeratore *= -1;
            this.denominatore *= -1;
        }
        
        count++;
    }
    
    private int mcd(int num, int den) {
        if(den == 0)
            return num;
        
        return mcd(den, num%den);
    }
    
    public int getNumeratore() {
        return numeratore;
    }

    public void setNumeratore(int numeratore) {
        int mcd = mcd(Math.abs(numeratore), Math.abs(this.denominatore));
        
        this.numeratore = numeratore/mcd;
        this.denominatore /= mcd;
    }
    
    public int getDenominatore() {
        return denominatore;
    }

    public void setDenominatore(int denominatore) throws DenominatoreNulloException {
        if(denominatore == 0)
            throw new DenominatoreNulloException();
        
        int mcd = mcd(Math.abs(this.numeratore), Math.abs(denominatore));
        
        this.numeratore /= mcd;
        this.denominatore = denominatore/mcd;
        
        if(this.denominatore < 0) {
            this.numeratore *= -1;
            this.denominatore *= -1;
        }
    }
    
    public Razionale addizione(Razionale r) {
        int mcm = denominatore*r.denominatore;
        int num = numeratore*r.denominatore+r.numeratore*denominatore;
        Razionale res = null;
        
        try {
            res = new Razionale(num, mcm);
        } catch (DenominatoreNulloException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public Razionale sottrazione(Razionale r) {
        int mcm = denominatore*r.denominatore;
        int num = numeratore*r.denominatore-r.numeratore*denominatore;
        Razionale res = null;
        
        try {
            res = new Razionale(num, mcm);
        } catch (DenominatoreNulloException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public Razionale moltiplicazione(Razionale r) {
        int num = numeratore*r.numeratore;
        int den = denominatore*r.denominatore;
        Razionale res = null;
        
        try {
            res = new Razionale(num, den);
        } catch (DenominatoreNulloException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public Razionale divisione(Razionale r) {
        if(r.numeratore == 0)
            throw new ArithmeticException("Non posso dividere per zero");
        
        int num = numeratore*r.denominatore;
        int den = r.numeratore*denominatore;
        Razionale res = null;
        
        try {
            res = new Razionale(num, den);
        } catch (DenominatoreNulloException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            count--;
        } finally {
            super.finalize();
        }
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(numeratore, denominatore);
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
        final Razionale r = (Razionale) obj;
        
        return (numeratore == r.numeratore) && (denominatore == r.denominatore);
    }
    
    @Override
    public String toString() {
        if(numeratore == 0)
            return "0";
        
        StringBuilder builder = new StringBuilder();
        builder.append(numeratore);
        if(denominatore != 1)
            builder.append("/").append(denominatore);
        
        return builder.toString();
    }
    
    @Override
    public int compareTo(Razionale r) {
        if(this == r)
            return 0;
        if(r == null)
            return 1;
        
        int mcd = mcd(denominatore, r.denominatore);
        int mcm = (denominatore*r.denominatore)/mcd;
        int n1 = (mcm/denominatore)*numeratore;
        int n2 = (mcm/r.denominatore)*r.numeratore;
        
        return n1-n2;
    }
    
    public static int getCount() {
        return count;
    }
    
}
