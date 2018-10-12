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
 * Classe che rappresenta la figura del cubo
 *
 * @author Antonio
 */
public class Cubo implements Figura3D {
    
    private double lato;

    /**
     * Metodo costruttore che permette di istanziare un cubo dato il lato
     * in input al metodo.
     * 
     * @param lato 
     */
    public Cubo(double lato) {
        this.lato = lato;
    }

    /**
     * Metodo accessorio per leggere il lato
     * 
     * @return il lato del cubo
     */
    public double getLato() {
        return lato;
    }

    /**
     * Metodo mutatore che consente di cambiare il lato
     * 
     * @param lato - il nuovo lato del cubo
     */
    public void setLato(double lato) {
        this.lato = lato;
    }

    /**
     * Override del metodo superficie dell'interfaccia Figura3D.
     * Il metodo calcola la superficie del cubo.
     * 
     * @return la superficie del cubo
     */
    @Override
    public double superficie() {
        return 6D * Math.pow(lato, 2);
    }

    /**
     * Override del metodo volume dell'interfaccia Figura3D.
     * Il metodo calcola il volume del cubo.
     * 
     * @return il volume del cubo
     */
    @Override
    public double volume() {
        return Math.pow(lato, 3);
    }

    /**
     * Metodo che disegna un cubo
     */
    @Override
    public void disegna() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo che restituisce le informazioni del cubo.
     * 
     * @return la stringa che contiente le informazioni
     */
    @Override
    public String info() {
        return "un cubo è un poliedro con sei facce quadrate perpendicolari a due a due tra loro e congruenti";
    }

    /**
     * Override del metodo <code>hashCode</code> per calcolare il codice hash
     * di un oggetto di tipo Cubo
     * 
     * @return il codice hash dell'oggetto 'this'
     */
    @Override
    public int hashCode() {
        return Objects.hash(lato);
    }

    /**
     * Override del metodo <code>equals</code> per determinare l'ugualianza
     * tra due oggetti di tipo Cubo. Due oggetti di questo tipo sono uguali
     * se i lati sono uguali.
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
        final Cubo c = (Cubo) obj;
        
        return Double.doubleToLongBits(this.lato) == Double.doubleToLongBits(c.lato);
    }

    /**
     * Override del metodo <code>toString</code> che rappresenta, sotto forma
     * di stringa un oggetto di tipo Cubo.
     * 
     * @return la stringa che rappresenta l'oggetto
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("l = ")
                .append(lato);
        
        return builder.toString();
    }
    
}
