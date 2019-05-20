/*
 * Copyright (C) 2019 Antonio
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

/**
 * Classe che rappresenta un Monomio nel quale il coefficiente sarà un oggetto
 * di tipo Razionale, mentre la parte letterale sarà identificata semplicemente
 * con un esponente intero (si assume 'x' come lettera del monomio).
 * 
 * @author Antonio
 */
public class Monomio implements Cloneable, Comparable<Monomio> {
    
    /**
     * variabile statica utile a contare quanti monomi saranno creati.
     */
    private static int count = 0;
    
    /**
     * variabili d'instanza.s
     */
    private Razionale coeff;
    private int exp;

    /**
     * Costruttore di default che permette di creare un oggetto di tipo Monomio
     * con coefficiente pari a zero ed esponente pari a uno.
     */
    public Monomio() {
        this(new Razionale(), 1);
    }

    /**
     * Costruttore parametrizzato che permette di creare un oggetto di tipo
     * Monomio dato un razionale ed un intero, che saranno rispettivamente il
     * coefficiente e l'esponente.
     * 
     * @param coeff - il razionale che rappresenta il coefficiente
     * @param exp - l'intero che rappresenta l'esponente
     */
    public Monomio(Razionale coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
        
        count++;
    }
    
    /**
     * Costruttore parametrizzato che permette di creare un oggetto di tipo
     * Monomio dato un numeratore e un denominatore, che saranno usati per
     * creare il coefficiente, e l'esponente.
     * Il metodo lancia la checked exception DenominatoreNulloException se il
     * denominatore passato è 0.
     * 
     * @param numeratore - il numeratore del coefficiente del monomio
     * @param denominatore - il denominatore del coefficiente del monomio
     * @param exp - l'esponente del monomio
     * @throws DenominatoreNulloException se il denominatore del coefficiente è uguale a zero
     */
    public Monomio(int numeratore, int denominatore, int exp) throws DenominatoreNulloException {
        this(new Razionale(numeratore, denominatore), exp);
    }

    /**
     * Metodo statico che ritorna il numero complessivo dei monomi creati.
     * 
     * @return il numero di monomi creati
     */
    public static int getCount() {
        return count;
    }

    /**
     * Metodo accessorio per leggere il coefficiente di un monomio.
     * 
     * @return il coefficiente del monomio
     */
    public Razionale getCoeff() {
        return coeff;
    }

    /**
     * Metodo mutatore per cambiare il coefficiente ad un monomio.
     * 
     * @param coeff - il coefficiente del monomio
     */
    public void setCoeff(Razionale coeff) {
        this.coeff = coeff;
    }
    
    /**
     * Metodo accessorio per leggere l'esponente di un monomio.
     * 
     * @return l'esponente del monomio
     */
    public int getExp() {
        return exp;
    }

    /**
     * Metodo mutatore per cambiare l'esponente ad un monomio.
     * 
     * @param exp - l'esponente del monomio
     */
    public void setExp(int exp) {
        this.exp = exp;
    }
    
    /**
     * Metodo che permette di sommare due monomi se gli esponenti sono uguali
     * tra di loro.
     * Il metodo lancia la unchecked exception MonomiNonSimiliException se i
     * monomi non sono simili tra loro ('this' e 'm') e quindi non sommabili.
     * 
     * @param m - il monomio da sommare
     * @return un nuovo monomio che sarà la somma tra 'this' e 'm'
     * @throws NullPointerException se 'm' è null
     * @throws MonomiNonSimiliException se gli esponenti non sono simili
     */
    public Monomio addizione(Monomio m) {
        if(exp != m.exp)
            throw new MonomiNonSimiliException();
                
        return new Monomio(coeff.addizione(m.coeff), exp);
    }
    
    /**
     * Metodo che permette di effettuare la sottrazione tra due monomi se gli
     * esponenti sono uguali tra di loro.
     * Il metodo lancia la unchecked exception MonomiNonSimiliException se i
     * monomi non sono simili tra loro ('this' e 'm') e quindi non sottraibili.
     * 
     * @param m - il monomio da sottrarre
     * @return un nuovo monomio che sarà la differenza a 'this' e 'm'
     * @throws NullPointerException se 'm' è null
     * @throws MonomiNonSimiliException se gli esponenti non sono simili
     */
    public Monomio sottrazione(Monomio m) {
        if(exp != m.exp)
            throw new MonomiNonSimiliException();
                
        return new Monomio(coeff.sottrazione(m.coeff), exp);
    }
    
    /**
     * Metodo che permette di moltiplicare due monomi tra di loro.
     * 
     * @param m - il monomio da moltiplicare
     * @return un nuovo monomio che sarà il prodotto tra 'this' e 'm'
     * @throws NullPointerException se 'm' è null
     */
    public Monomio moltiplicazione(Monomio m) {
        return new Monomio(coeff.moltiplicazione(m.coeff), exp+m.exp);
    }
    
    /**
     * Metodo che permette di effettuare la divisione tra due monomi.
     * 
     * @param m - il monomio divisore
     * @return un nuovo monomio che sarà la divisione tra 'this' e 'm'
     * @throws NullPointerException se 'm' è null
     * @throws ArithmeticException se il grado di 'this' è minore del grado di 'm'
     */
    public Monomio divisione(Monomio m) {
        if(exp < m.exp)
            throw new ArithmeticException("errore! divisione non possibile!");
        
        return new Monomio(coeff.divisione(m.coeff), exp-m.exp);
    }

    /**
     * Metodo che ritorna una copia dell'istanza 'this' di Monomio. Il metodo
     * clona anche il coefficiente (copia profonda dell'oggetto).
     * 
     * @return un clone dell'istanza 'this' di Monomio
     */
    @Override
    public Monomio clone() {
        Monomio m = null;
        try {
            m = (Monomio) super.clone();
            m.coeff = m.coeff.clone();
        } catch (CloneNotSupportedException ex) {
            // l'eccezione non si verifica perché Razionale è di tipo Cloneable
            throw new InternalError(ex);
        }
        
        return m;
    }

    /**
     * Override del metodo 'hashCode' per calcolare il codice hash di un
     * oggetto di tipo 'Monomio'.
     * 
     * @return il codice hash di 'this'
     */
    @Override
    public int hashCode() {
        return Objects.hash(coeff, exp);
    }

    /**
     * Override del metodo 'equals' per permettere il confronto tra due oggetti
     * di tipo 'Monomio'. Due oggetti di questo tipo saranno uguali se il
     * coefficiente e l'esponente sono uguali.
     * 
     * @param obj - l'oggetto da passare come parametro per confrontarlo con il 'this'
     * @return true se gli oggetti sono uguali, false altrimenti
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
        final Monomio m = (Monomio) obj;
        
        return (coeff.equals(m.coeff)) && (exp == m.exp);
    }

    /**
     * Override del metodo 'toString' che ritorna la rappresentazione sotto
     * forma di stringa di un monomio.
     * 
     * @return la stringa per rappresentare l'oggetto
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        if(coeff.getNumeratore() == 0)
            builder.append('0');
        else if(exp == 0)
            builder.append(coeff);
        else if(exp == 1)
            if(coeff.getNumeratore() == 1 && coeff.getDenominatore() == 1)
                builder.append('x');
            else
                builder.append(coeff).append('x');
        else
            if(coeff.getNumeratore() == 1 && coeff.getDenominatore() == 1)
                builder.append("x^").append(exp);
            else
                builder.append(coeff).append("x^").append(exp);
        
        return builder.toString();
    }

    /**
     * Override del metodo 'compareTo' presente nell'interfaccia 'Comparable'
     * per comparare due monomi in base al loro valore. Il monomio 'this'
     * precede 'r' se il valore dell'esponente è più grande. Se, invece, il
     * valore dell'esponente è più piccolo lo segue. Se i due esponenti fossero
     * uguali si confronterebbero i coefficienti. 
     * 
     * @param m - il monomio da comparare
     * @return un valore negativo se 'this' precede 'm', positivo se lo segue, il valore zero se sono uguali
     * @throws NullPointerException se 'm' è null
     */
    @Override
    public int compareTo(Monomio m) {
        int cmp = m.exp-exp;
        if(cmp == 0)
            return coeff.compareTo(m.coeff);
        
        return cmp;
    }
    
}
