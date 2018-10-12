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
 * Classe che rappresenta la figura del quadrato
 *
 * @author Antonio
 */
public class Quadrato implements Figura2D {
    
    private double lato;

    /**
     * Metodo costruttore che permette di istanziare un quadrato dato il lato
     * in input al metodo.
     * 
     * @param lato - il lato del quadrato
     */
    public Quadrato(double lato) {
        this.lato = lato;
    }

    /**
     * Metodo accessorio per leggere il lato
     * 
     * @return il lato del quadrato
     */
    public double getLato() {
        return lato;
    }

    /**
     * Metodo mutatore che consente di cambiare il lato
     * 
     * @param lato - il nuovo lato del quadrato
     */
    public void setLato(double lato) {
        this.lato = lato;
    }

    /**
     * Override del metodo perimetro dell'interfaccia Figura2D.
     * Il metodo calcola il perimetro del quadrato.
     * 
     * @return il perimetro del quadrato
     */
    @Override
    public double perimetro() {
        return lato*4D;
    }

    /**
     * Override del metodo area dell'interfaccia Figura2D.
     * Il metodo calcola l'area del quadrato.
     * 
     * @return l'area del quadrato
     */
    @Override
    public double area() {
        return Math.pow(lato, 2);
    }

    /**
     * Metodo che disegna un quadrato
     */
    @Override
    public void disegna() {
        int b = 7;
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
     * Metodo che restituisce le informazioni del quadrato.
     * 
     * @return la stringa che contiente le informazioni
     */
    @Override
    public String info() {
        return "un quadrato è un quadrilatero con quattro lati e quattro angoli congruenti";
    }

    /**
     * Override del metodo <code>hashCode</code> per calcolare il codice hash
     * di un oggetto di tipo Quadrato
     * 
     * @return il codice hash dell'oggetto 'this'
     */
    @Override
    public int hashCode() {
        return Objects.hash(lato);
    }

    /**
     * Override del metodo <code>equals</code> per determinare l'ugualianza
     * tra due oggetti di tipo Quadrato. Due oggetti di questo tipo sono uguali
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
        final Quadrato other = (Quadrato) obj;
        
        return Double.doubleToLongBits(this.lato) == Double.doubleToLongBits(other.lato);
    }

    /**
     * Override del metodo <code>toString</code> che rappresenta, sotto forma
     * di stringa un oggetto di tipo Quadrato.
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
