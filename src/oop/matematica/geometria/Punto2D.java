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
package oop.matematica.geometria;

import java.util.Objects;

/**
 * Classe che rappresenta un punto bidimensionale con coordinate x e y nel
 * piano cartesiano
 *
 * @author Antonio
 */
public class Punto2D {
    
    private double x;
    private double y;

    /**
     * Metodo costruttore di default che permette di istanziare un punto 
     * nell'origine del piano cartesiano.
     */
    public Punto2D() {
        x = 0.0;
        y = 0.0;
    }

    /**
     * Metodo costruttore che permette di istanziare un punto con le coordinate
     * x e y date in input al metodo.
     * 
     * @param x - la coordinata x
     * @param y - la coordinata y 
     */
    public Punto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Metodo accessorio per leggere la coordinata x
     * 
     * @return la coordinata x
     */
    public double getX() {
        return x;
    }

    /**
     * Metodo mutatore che consente di cambiare la coordinata x
     * 
     * @param x - la nuova coordinata x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Metodo accessorio per leggere la coordinata y
     * 
     * @return la coordinata y
     */
    public double getY() {
        return y;
    }

    /**
     * Metodo mutatore che consente di cambiare la coordinata y
     * 
     * @param y - la nuova coordinata y
     */
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * Metodo che calcola la distanza tra due punti nel piano cartesiano
     * 
     * @param p - il punto distante dal punto 'this'
     * @return la distanza dei due punti
     */
    public double distanza(Punto2D p) {
        double deltaX = Math.pow(p.x-x, 2);
        double deltaY = Math.pow(p.y-y, 2);
        
        return Math.sqrt(deltaX+deltaY);
    }

    /**
     * Override del metodo <code>hashCode</code> per calcolare il codice hash
     * di un oggetto di tipo Punto
     * 
     * @return il codice hash dell'oggetto 'this'
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Override del metodo <code>equals</code> per determinare l'ugualianza
     * tra due oggetti di tipo Punto. Due oggetti di questo tipo sono uguali
     * se le coordinate x e y coincidono.
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
        final Punto2D p = (Punto2D) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(p.x)) {
            return false;
        }
        return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(p.y);
    }

    /**
     * Override del metodo <code>toString</code> che rappresenta, sotto forma
     * di stringa un oggetto di tipo Punto.
     * 
     * @return la stringa che rappresenta l'oggetto
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(")
                .append(x)
                .append(", ")
                .append(y)
                .append(")");
        
        return builder.toString();
    }
    
}
