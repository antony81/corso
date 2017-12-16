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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Antonio
 */
public class Polinomio {
    
    private final List<Monomio> espressione;
    
    public Polinomio() {
        espressione = new ArrayList<>(3);
    }
    
    public void aggiungi(Monomio monomio) throws EsponenteException {
        if(espressione.size() > 3 || monomio.getEsponente() < 0 || monomio.getEsponente() > 2)
            throw new EsponenteException();
        
        boolean trovato = false;
        int size = espressione.size();
        for(int i = 0; !trovato && i < size; i++)
            if(espressione.get(i).getEsponente() == monomio.getEsponente())
                trovato = true;
        
        if(trovato)
            throw new EsponenteException();
        
        espressione.add(monomio);
    }
    
    public String soluzione() {
        StringBuilder builder = new StringBuilder();
        
        Razionale a = new Razionale();
        Razionale b = new Razionale();
        Razionale c = new Razionale();
        
        for(Monomio m : espressione) {
            switch(m.getEsponente()) {
                case 2:
                    a = m.getCoefficiente();
                    break;
                case 1:
                    b = m.getCoefficiente();
                    break;
                case 0:
                    c = m.getCoefficiente();
            }
        }
        
        double aNum = a.getNumeratore();
        double aDen = a.getDenominatore();
        double a1 = aNum/aDen;
        double bNum = b.getNumeratore();
        double bDen = b.getDenominatore();
        double b1 = bNum/bDen;
        double cNum = c.getNumeratore();
        double cDen = c.getDenominatore();
        double c1 = cNum/cDen;
        
        if(a.getNumeratore() == 0) {
            double x = -1*c1/b1;
            builder.append("x = ").append(x);
        } else {
            double delta = Math.pow(b1, 2)-4*a1*c1;
            if(delta < 0)
                builder.append("indeterminato");
            else if(delta > 0) {
                double x1 = (-b1-Math.sqrt(delta))/(2*a1);
                double x2 = (-b1+Math.sqrt(delta))/(2*a1);
                builder.append("x1 = ").append(x1);
                builder.append(", x2 = ").append(x2);
            } else {
                double x = -b1/(2*a1);
                builder.append("x1 = x2 = ").append(x);
            }
        }
        
        return builder.toString();
    }
    
    public void ordina() {
        Collections.sort(espressione);
    }
    
    @Override
    public int hashCode() {
        return espressione.hashCode();
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
        final Polinomio p = (Polinomio) obj;
        
        return espressione.containsAll(p.espressione);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(espressione.get(0));
        int size = espressione.size();
        for(int i = 1; i < size; i++) {
            builder.append(' ');
            Razionale r = espressione.get(i).getCoefficiente();
            if(r.getNumeratore() > 0)
                builder.append('+');
            builder.append(espressione.get(i));
        }
        
        return builder.toString();
    }
    
}
