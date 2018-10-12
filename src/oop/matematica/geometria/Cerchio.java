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
 * Classe che rappresenta la figura del cerchio
 *
 * @author Antonio
 */
public class Cerchio implements Figura2D {
    
    private double raggio;

    /**
     * Metodo costruttore che permette di istanziare un cerchio dato il raggio
     * in input al metodo.
     * 
     * @param raggio - il raggio del cerchio
     */
    public Cerchio(double raggio) {
        this.raggio = raggio;
    }

    /**
     * Metodo accessorio per leggere il raggio
     * 
     * @return il raggio del cerchio
     */
    public double getRaggio() {
        return raggio;
    }

    /**
     * Metodo mutatore che consente di cambiare il raggio
     * 
     * @param raggio - il nuovo raggio del cerchio
     */
    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    /**
     * Override del metodo perimetro dell'interfaccia Figura2D.
     * Il metodo calcola il perimetro del cerchio.
     * 
     * @return il perimetro del cerchio
     */
    @Override
    public double perimetro() {
        return Math.PI*raggio*2D;
    }

    /**
     * Override del metodo area dell'interfaccia Figura2D.
     * Il metodo calcola l'area del cerchio.
     * 
     * @return l'area del cerchio
     */
    @Override
    public double area() {
        return Math.PI*Math.pow(raggio, 2);
    }

    /**
     * Metodo che disegna un cerchio
     */
    @Override
    public void disegna() {
        int n = 6;
        int x, y;
        for(int i = 0; i < (n/2+1); i++) {
            x = Math.abs(n/2-i*2);
            y = n - x + 1;
            for(int j = 1; j <= n; j++) {
                if(j == x || j == y)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * Metodo che restituisce le informazioni del cerchio.
     * 
     * @return la stringa che contiente le informazioni
     */
    @Override
    public String info() {
        return "Cerchio e circonferenza in Geometria sono rispettivamente la parte di piano delimitata dalla circonferenza e l'insieme dei punti equidistanti da un punto fissato, detto centro del cerchio. La distanza dei punti della circonferenza dal centro viene detta raggio.";
    }

    /**
     * Override del metodo <code>hashCode</code> per calcolare il codice hash
     * di un oggetto di tipo Cerchio
     * 
     * @return il codice hash dell'oggetto 'this'
     */
    @Override
    public int hashCode() {
        return Objects.hash(raggio);
    }

    /**
     * Override del metodo <code>equals</code> per determinare l'ugualianza
     * tra due oggetti di tipo Cerchio. Due oggetti di questo tipo sono uguali
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
        final Cerchio c = (Cerchio) obj;
        
        return Double.doubleToLongBits(this.raggio) == Double.doubleToLongBits(c.raggio);
    }

    /**
     * Override del metodo <code>toString</code> che rappresenta, sotto forma
     * di stringa un oggetto di tipo Cerchio.
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
