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
import oop.matematica.Formule;

/**
 * Classe che rappresenta la figura del triangolo
 *
 * @author Antonio
 */
public class Triangolo implements Figura2D {
    
    private double base;
    private double altezza;

    /**
     * Metodo costruttore che permette di istanziare un triangolo data la base
     * e l'altezza in input al metodo. Questa classe non è in grado di
     * rappresentare triangoli scaleni.
     * 
     * @param base - la base del triangolo
     * @param altezza - l'altezza del triangolo
     */
    public Triangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    /**
     * Metodo accessorio per leggere la base
     * 
     * @return la base del triangolo
     */
    public double getBase() {
        return base;
    }

    /**
     * Metodo mutatore che consente di cambiare la base
     * 
     * @param base - la nuova base del triangolo
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * Metodo accessorio per leggere l'altezza
     * 
     * @return l'altezza del triangolo
     */
    public double getAltezza() {
        return altezza;
    }

    /**
     * Metodo mutatore che consente di cambiare l'altezza
     * 
     * @param altezza - la nuova altezza del triangolo
     */
    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    /**
     * Override del metodo perimetro dell'interfaccia Figura2D.
     * Il metodo calcola il perimetro del triangolo.
     * 
     * @return il perimetro del triangolo
     */
    @Override
    public double perimetro() {
        return 2D*Formule.teoremaPitagoraIpotenusa(base/2, altezza)+base;
    }

    /**
     * Override del metodo area dell'interfaccia Figura2D.
     * Il metodo calcola l'area del triangolo.
     * 
     * @return l'area del triangolo
     */
    @Override
    public double area() {
        return base*altezza/2D;
    }

    /**
     * Metodo che disegna un triangolo
     */
    @Override
    public void disegna() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo che restituisce le informazioni del triangolo.
     * 
     * @return la stringa che contiente le informazioni
     */
    @Override
    public String info() {
        return "un triangolo è un poligono formato da tre lati e tre angoli";
    }

    /**
     * Override del metodo <code>hashCode</code> per calcolare il codice hash
     * di un oggetto di tipo Triangolo
     * 
     * @return il codice hash dell'oggetto 'this'
     */
    @Override
    public int hashCode() {
        return Objects.hash(base, altezza);
    }

    /**
     * Override del metodo <code>equals</code> per determinare l'ugualianza
     * tra due oggetti di tipo Triangolo. Due oggetti di questo tipo sono
     * uguali se le basi e le altezze sono uguali.
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
        final Triangolo other = (Triangolo) obj;
        if (Double.doubleToLongBits(this.base) != Double.doubleToLongBits(other.base)) {
            return false;
        }
        
        return Double.doubleToLongBits(this.altezza) == Double.doubleToLongBits(other.altezza);
    }

    /**
     * Override del metodo <code>toString</code> che rappresenta, sotto forma
     * di stringa un oggetto di tipo Triangolo.
     * 
     * @return la stringa che rappresenta l'oggetto
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("b = ")
                .append(base)
                .append(", h = ")
                .append(altezza);
        
        return builder.toString();
    }
    
}
