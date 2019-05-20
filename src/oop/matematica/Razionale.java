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
 * Classe che rappresenta un razionale che abbia quindi un numeratore ed un
 * denominatore. La classe ha dei metodi che permettono le operazioni di base
 * sui razionali: somma, differenza, prodotto, divisione.
 *
 * @author Antonio
 */
public class Razionale implements Cloneable, Comparable<Razionale> {
    
    /**
     * variabile statica utile a contare quanti razionali saranno creati.
     */
    private static int count = 0;
    
    /**
     * variabili d'instanza.
     */
    private int numeratore;
    private int denominatore;
        
    /**
     * Metodo costruttore di default che permette di istanziare un oggetto di
     * tipo Razionale con valore zero (0/1).
     */
    public Razionale() {
        this(0);
    }
    
    public Razionale(int numeratore) {
        this.numeratore = numeratore;
        this.denominatore = 1;
        
        count++;
    }
    
    /**
     * Metodo costruttore parametrizzato che permette di istanziare un oggetto
     * di tipo Razionale dato un numeratore e un denominatore. Un razionale non
     * può essere costruito con un denominatore che valga 0, pertanto il metodo
     * lancia la checked exception DenominatoreNulloException.
     * 
     * @param numeratore - il numeratore del razionale
     * @param denominatore - il denominatore del razionale
     * @throws DenominatoreNulloException se il denominatore è uguale a zero
     */
    public Razionale(int numeratore, int denominatore) throws DenominatoreNulloException {
        if(denominatore == 0)
            throw new DenominatoreNulloException();
        
        int mcd = Formule.massimoComunDivisore(numeratore, denominatore);
        
        this.numeratore = numeratore / mcd;
        this.denominatore = denominatore / mcd;
        
        if(denominatore < 0) {
            this.numeratore *= -1;
            this.denominatore *= -1;
        }
        
        count++;
    }
    
    /**
     * Metodo statico che ritorna il numero complessivo dei razionali creati.
     * 
     * @return il numero degli oggetti di tipo razionale creati
     */
    public static int getCount() {
        return count;
    }
    
    /**
     * Metodo accessorio per leggere il numeratore di un razionale.
     * 
     * @return - il numeratore del razionale
     */
    public int getNumeratore() {
        return numeratore;
    }

    /**
     * Metodo mutatore che accetta come parametro il nuovo numeratore.
     * 
     * @param numeratore - il nuovo numeratore del razionale
     */
    public void setNumeratore(int numeratore) {
        int mcd = Formule.massimoComunDivisore(numeratore, denominatore);
        
        this.numeratore = numeratore / mcd;
        this.denominatore /= mcd;
    }
    
    /**
     * Metodo accessorio per leggere il denominatore di un razionale.
     * 
     * @return - il denominatore del razionale
     */
    public int getDenominatore() {
        return denominatore;
    }

    /**
     * Metodo mutatore che accetta come parametro il nuovo denominatore.
     * 
     * @param denominatore - il nuovo denominatore del razionale
     * @throws DenominatoreNulloException se il denominatore è uguale a zero
     */
    public void setDenominatore(int denominatore) throws DenominatoreNulloException {
        if(denominatore == 0)
            throw new DenominatoreNulloException();
        
        int mcd = Formule.massimoComunDivisore(numeratore, denominatore);
        
        this.numeratore /= mcd;
        this.denominatore = denominatore / mcd;
        
        if(denominatore < 0) {
            this.numeratore *= -1;
            this.denominatore *= -1;
        }
    }
    
    public Razionale cambiaSegno() {
        Razionale r = null;
        try {
            r = new Razionale(numeratore * -1, denominatore);
        } catch (DenominatoreNulloException ex) {
            // il catch non si verifica mai perché sicuramente il denominatore non sarà zero
            throw new InternalError(ex);
        }
        
        return r;
    }
    
    /**
     * Metodo che calcola e restituisce il reciproco del razionale 'this'.
     * 
     * @return il razionale reciproco
     * @throws ArithmeticException se il numeratore di 'this' vale zero
     */
    public Razionale reciproco() {
        if(numeratore == 0)
            throw new ArithmeticException("reciproco di 0");
        
        Razionale reciproco = null;
        try {
            reciproco = new Razionale(denominatore, numeratore);
        } catch (DenominatoreNulloException ex) {
            // il catch non si verifica mai perché sicuramente il denominatore non sarà zero
            throw new InternalError(ex);
        }
        
        return reciproco;
    }
    
    /**
     * Metodo che permette di addizionare due razionali e ottenerne un terzo
     * che rappresenta il risultato finale.
     * 
     * @param r - il razionale da sommare a 'this'
     * @return il razionale somma
     * @throws NullPointerException se 'r' è null
     */
    public Razionale addizione(Razionale r) {
        int num = numeratore * r.denominatore + r.numeratore * denominatore;
        int den = denominatore * r.denominatore;
        
        Razionale somma = null;
        try {
            somma = new Razionale(num, den);
        } catch (DenominatoreNulloException ex) {
            // il catch non si verifica mai perché sicuramente il denominatore non sarà zero
            throw new InternalError(ex);
        }
        
        return somma;
    }
    
    /**
     * Metodo che permette di effettuare la sottrazione tra due razionali e
     * ottenerne un terzo che appresenta il risultato finale.
     * 
     * @param r - il razionale da sottrarre a 'this'
     * @return il razionale che è la differenza tra i due
     * @throws NullPointerException se 'r' è null
     */
    public Razionale sottrazione(Razionale r) {
        return addizione(r.cambiaSegno());
    }
    
    /**
     * Metodo che permette di moltiplicare due razionali e ottenerne un terzo
     * che appresenta il risultato finale.
     * 
     * @param r - il razionale da moltiplicare a 'this'
     * @return il razionale che è il prodotto tra i due
     * @throws NullPointerException se 'r' è null
     */
    public Razionale moltiplicazione(Razionale r) {
        int num = numeratore * r.numeratore;
        int den = denominatore * r.denominatore;
        
        Razionale prodotto = null;
        try {
            prodotto = new Razionale(num, den);
        } catch (DenominatoreNulloException ex) {
            // il catch non si verifica mai perché sicuramente il denominatore non sarà zero
            throw new InternalError(ex);
        }
        
        return prodotto;
    }
    
    /**
     * Metodo che permette di effettuare la divisione tra due razionali e
     * ottenerne un terzo che appresenta il risultato finale.
     * Il metodo lancia la unchecked exception ArithmeticException se il
     * razionale passato come parametro vale zero.
     * 
     * @param r - il razionale da dividere a 'this'
     * @return il razionale che è la divisione tra i due
     * @throws NullPointerException se 'r' è null
     * @throws ArithmeticException se r vale zero
     */
    public Razionale divisione(Razionale r) {
        if(r.numeratore == 0)
            throw new ArithmeticException("errore! divisione per zero!");
        
        int num = numeratore*r.denominatore;
        int den = r.numeratore*denominatore;
        
        Razionale quoziente = null;
        try {
            quoziente = new Razionale(num, den);
        } catch (DenominatoreNulloException ex) {
            // il catch non si verifica mai perché sicuramente il denominatore non sarà zero
            throw new InternalError(ex);
        }
        
        return quoziente;
    }
    
    /**
     * Metodo che permette di effettuare la potenza di un razionale e
     * ottenendo un secondo razionale che appresenta il risultato finale.
     * 
     * @param esponente
     * @return il razionale potenza
     */
    public Razionale potenza(int esponente) {
        if(esponente < 0 && numeratore == 0)
            throw new ArithmeticException("potenza di 0^(-n)");
        
        if(esponente == 0)
            return new Razionale(1);
        
        int num = (int) Math.pow(numeratore, esponente);
        int den = (int) Math.pow(denominatore, esponente);
        
        Razionale potenza = null;
        try {
            potenza = new Razionale(num, den);
        } catch (DenominatoreNulloException ex) {
            // il catch non si verifica mai perché sicuramente il denominatore non sarà zero
            throw new InternalError(ex);
        }
        
        return potenza;
    }
    
    /**
     * Metodo che restituisce il valore calcolato come rapporto tra
     * il numeratore e il denominatore.
     * 
     * @return il rapporto tra numeratore e denominatore
     */
    public double doubleValue() {
        double num = numeratore;
        double den = denominatore;
        
        return num/den;
    }

    /**
     * Metodo che ritorna una copia dell'istanza 'this' di Razionale.
     * 
     * @return un clone dell'istanza 'this' di Razionale
     */
    @Override
    public Razionale clone() {
        Razionale r = null;
        try {
            r = (Razionale) super.clone();
        } catch (CloneNotSupportedException ex) {
            // l'eccezione non si verifica perché Razionale è di tipo Cloneable
            throw new InternalError(ex);
        }
        
        return r;
    }
    
    /**
     * Override del metodo 'hashCode' per calcolare il codice hash di un
     * oggetto di tipo Razionale.
     * 
     * @return il codice hash di 'this'
     */
    @Override
    public int hashCode() {
        return Objects.hash(numeratore, denominatore);
    }
    
    /**
     * Override del metodo 'equals' per permettere il confronto tra due
     * oggetti di tipo 'Razionale'. Due oggetti di questo tipo saranno
     * uguali se il numeratore ed il denominatore sono uguali.
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
        final Razionale r = (Razionale) obj;
        
        return (numeratore == r.numeratore) && (denominatore == r.denominatore);
    }
    
    /**
     * Override del metodo 'toString' che genera una stringa che
     * rappresenterà l'oggetto.
     * 
     * @return la stringa per rappresentare l'oggetto
     */
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
    
    /**
     * Override del metodo 'compareTo' presente nell'interfaccia 'Comparable'
     * che permette di comparare due razionali in base al loro valore.
     * Il razionale 'this' precede 'r' se il suo valore è minore dell'altro,
     * altrimenti lo segue.
     * 
     * @param r - il razionale da comparare
     * @return un valore negativo se 'this' precede 'r', positivo se lo segue, il valore zero se sono uguali
     * @throws NullPointerException se 'r' è null
     */
    @Override
    public int compareTo(Razionale r) {
        int mcd = Formule.massimoComunDivisore(denominatore, r.denominatore);
        int mcm = (denominatore*r.denominatore)/mcd;
        int n1 = (mcm/denominatore)*numeratore;
        int n2 = (mcm/r.denominatore)*r.numeratore;
        
        return n1-n2;
    }
    
}
