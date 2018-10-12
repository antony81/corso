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
package oop.matematica.geometria;

import java.util.Objects;

/**
 * Classe che rappresenta la figura della sfera
 *
 * @author Antonio
 */
public class Sfera implements Figura3D {
    
    private double raggio;

    /**
     * Metodo costruttore che permette di istanziare una sfera dato il raggio
     * in input al metodo.
     * 
     * @param raggio 
     */
    public Sfera(double raggio) {
        this.raggio = raggio;
    }

    /**
     * Metodo accessorio per leggere il raggio
     * 
     * @return il raggio della sfera
     */
    public double getRaggio() {
        return raggio;
    }

    /**
     * Metodo mutatore che consente di cambiare il raggio
     * 
     * @param raggio - il nuovo raggio della sfera
     */
    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    /**
     * Override del metodo superficie dell'interfaccia Figura3D.
     * Il metodo calcola la superficie della sfera.
     * 
     * @return la superficie della sfera
     */
    @Override
    public double superficie() {
        return 4D * Math.PI * Math.pow(raggio, 2);
    }

    /**
     * Override del metodo volume dell'interfaccia Figura3D.
     * Il metodo calcola il volume della sfera.
     * 
     * @return il volume della sfera
     */
    @Override
    public double volume() {
        return 4D / 3D * Math.PI * Math.pow(raggio, 3);
    }

    /**
     * Metodo che disegna una sfera
     */
    @Override
    public void disegna() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo che restituisce le informazioni della sfera.
     * 
     * @return la stringa che contiente le informazioni
     */
    @Override
    public String info() {
        return "una sfera è un solido di rotazione che viene generato dalla rotazione completa di un semicerchio attorno al diametro";
    }

    /**
     * Override del metodo <code>hashCode</code> per calcolare il codice hash
     * di un oggetto di tipo Sfera
     * 
     * @return il codice hash dell'oggetto 'this'
     */
    @Override
    public int hashCode() {
        return Objects.hash(raggio);
    }

    /**
     * Override del metodo <code>equals</code> per determinare l'ugualianza
     * tra due oggetti di tipo Sfera. Due oggetti di questo tipo sono uguali
     * se i raggi sono uguali.
     * 
     * @return true se l'oggetto 'this' è uguale a obj, false altrimenti
     */
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
        final Sfera s = (Sfera) obj;
        
        return Double.doubleToLongBits(this.raggio) == Double.doubleToLongBits(s.raggio);
    }

    /**
     * Override del metodo <code>toString</code> che rappresenta, sotto forma
     * di stringa un oggetto di tipo Sfera.
     * 
     * @return la stringa che rappresenta l'oggetto
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("r = ")
                .append(raggio);
        
        return builder.toString();
    }
    
}
