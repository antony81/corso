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
 * Classe che rappresenta la figura del rettangolo
 *
 * @author Antonio
 */
public class Rettangolo implements Figura2D {
    
    private double base;
    private double altezza;

    /**
     * Metodo costruttore che permette di istanziare un quadrato dato il lato
     * in input al metodo.
     * 
     * @param base - la base del rettangolo
     * @param altezza - l'altezza del rettangolo
     */
    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    /**
     * Metodo accessorio per leggere la base
     * 
     * @return la base del rettangolo
     */
    public double getBase() {
        return base;
    }

    /**
     * Metodo mutatore che consente di cambiare la base
     * 
     * @param base - la nuova base del rettangolo
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * Metodo accessorio per leggere l'altezza
     * 
     * @return l'altezza del rettangolo
     */
    public double getAltezza() {
        return altezza;
    }

    /**
     * Metodo mutatore che consente di cambiare l'altezza
     * 
     * @param altezza - la nuova altezza del rettangolo
     */
    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    /**
     * Override del metodo perimetro dell'interfaccia Figura2D.
     * Il metodo calcola il perimetro del rettangolo.
     * 
     * @return il perimetro del rettangolo
     */
    @Override
    public double perimetro() {
        return (base+altezza)*2D;
    }

    /**
     * Override del metodo area dell'interfaccia Figura2D.
     * Il metodo calcola l'area del rettangolo.
     * 
     * @return l'area del rettangolo
     */
    @Override
    public double area() {
        return base*altezza;
    }

    /**
     * Metodo che disegna un rettangolo
     */
    @Override
    public void disegna() {
        int b = 12;
        int a = 4;
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < b; j++) {
                if(i == 0 || i == (a-1))
                    System.out.print("*");
                else if(j == 0 || j == (b-1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * Metodo che restituisce le informazioni del rettangolo.
     * 
     * @return la stringa che contiente le informazioni
     */
    @Override
    public String info() {
        return "un rettangolo è un quadrilatero con i lati consecutivi perpendicolari tra di loro";
    }

    /**
     * Override del metodo <code>hashCode</code> per calcolare il codice hash
     * di un oggetto di tipo Rettangolo
     * 
     * @return il codice hash dell'oggetto 'this'
     */
    @Override
    public int hashCode() {
        return Objects.hash(base, altezza);
    }

    /**
     * Override del metodo <code>equals</code> per determinare l'ugualianza
     * tra due oggetti di tipo Rettangolo. Due oggetti di questo tipo sono
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
        final Rettangolo other = (Rettangolo) obj;
        if (Double.doubleToLongBits(this.base) != Double.doubleToLongBits(other.base)) {
            return false;
        }
        
        return Double.doubleToLongBits(this.altezza) == Double.doubleToLongBits(other.altezza);
    }

    /**
     * Override del metodo <code>toString</code> che rappresenta, sotto forma
     * di stringa un oggetto di tipo Rettangolo.
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
