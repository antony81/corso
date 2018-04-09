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

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop.util.LoggerFactory;

/**
 *
 * @author Antonio
 * 
 * Classe che rappresenta un razionale che abbia quindi un numeratore ed un
 * denominatore. La classe ha dei metodi che permettono le operazioni di base
 * sui razionali: somma, differenza, prodotto, divisione.
 */
public class Razionale implements Comparable<Razionale> {
    
    private int numeratore; // variabile d'instanza
    private int denominatore; // variabile d'instanza
    
    private static int count = 0; // variabile statica utile a contare quanti razionali saranno creati
    
    private final static Logger LOGGER = LoggerFactory.getLogger(Razionale.class); // creazione di un logger
    
    /**
     * Metodo costruttore di default che inizializza a zero un razionale.
     */
    public Razionale() {
        this.numeratore = 0;
        this.denominatore = 1;
        
        count++;
    }
    
    /**
     * 
     * @param numeratore - il numeratore del razionale
     * @param denominatore - il denominatore del razionale
     * @throws DenominatoreNulloException - se il denominatore è uguale a zero
     */
    public Razionale(int numeratore, int denominatore) throws DenominatoreNulloException {
        if(denominatore == 0)
            throw new DenominatoreNulloException();
        
        int mcd = mcd(Math.abs(numeratore), Math.abs(denominatore)); // calcolo del massimo comun divisore usado un metodo ricorsivo
        
        this.numeratore = numeratore/mcd;
        this.denominatore = denominatore/mcd;
        
        if(this.denominatore < 0) {
            this.numeratore *= -1;
            this.denominatore *= -1;
        }
        
        count++;
    }
    
    /* Metodo privato che usa la ricorsione per calcolare, sfruttando
    l'algoritmo di Euclide, il massimo comun divisore.
    */
    private int mcd(int num, int den) {
        if(den == 0)
            return num;
        
        return mcd(den, num%den);
    }
    
    /**
     * 
     * @return - il numeratore del razionale
     * 
     * Metodo accessorio per leggere il numeratore di un razionale.
     */
    public int getNumeratore() {
        return numeratore;
    }

    /**
     * 
     * @param numeratore - il nuovo numeratore del razionale
     * 
     * Metodo mutatore che accetta come parametro il nuovo numeratore.
     */
    public void setNumeratore(int numeratore) {
        int mcd = mcd(Math.abs(numeratore), Math.abs(this.denominatore));
        
        this.numeratore = numeratore/mcd;
        this.denominatore /= mcd;
    }
    
    /**
     * 
     * @return - il nuovo denominatore del razionale
     * 
     * Metodo mutatore che accetta come parametro il nuovo denominatore.
     */
    public int getDenominatore() {
        return denominatore;
    }

    /**
     * 
     * @param denominatore - il nuovo denominatore del razionale
     * @throws DenominatoreNulloException se il denominatore è uguale a zero
     * 
     * Metodo mutatore che accetta come parametro il nuovo denominatore.
     */
    public void setDenominatore(int denominatore) throws DenominatoreNulloException {
        if(denominatore == 0)
            throw new DenominatoreNulloException();
        
        int mcd = mcd(Math.abs(this.numeratore), Math.abs(denominatore));
        
        this.numeratore /= mcd;
        this.denominatore = denominatore/mcd;
        
        if(this.denominatore < 0) {
            this.numeratore *= -1;
            this.denominatore *= -1;
        }
    }
    
    /**
     * 
     * @param r - il razionale da sommare a 'this'
     * @return il razionale somma
     * 
     * Metodo che permette di addizionare due razionali e ottenerne un terzo che
     * rappresenta il risultato finale.
     */
    public Razionale addizione(Razionale r) {
        int mcm = denominatore*r.denominatore;
        int num = numeratore*r.denominatore+r.numeratore*denominatore;
        
        Razionale somma = null;
        try {
            somma = new Razionale(num, mcm);
        } catch (DenominatoreNulloException ex) {
            LOGGER.log(Level.SEVERE, null, ex); // il catch non si verifica mai perché sicuramente il denominatore non sarà zero
        }
        
        return somma;
    }
    
    /**
     * 
     * @param r - il razionale da sottrarre a 'this'
     * @return il razionale che è la differenza tra i due
     * 
     * Metodo che permette di effettuare la sottrazione tra due razionali e
     * ottenerne un terzo che appresenta il risultato finale.
     */
    public Razionale sottrazione(Razionale r) {
        int mcm = denominatore*r.denominatore;
        int num = numeratore*r.denominatore-r.numeratore*denominatore;
        
        Razionale differenza = null;
        try {
            differenza = new Razionale(num, mcm);
        } catch (DenominatoreNulloException ex) {
            LOGGER.log(Level.SEVERE, null, ex); // il catch non si verifica mai perché sicuramente il denominatore non sarà zero
        }
        
        return differenza;
    }
    
    /**
     * 
     * @param r - il razionale da moltiplicare a 'this'
     * @return il razionale che è il prodotto tra i due
     * 
     * Metodo che permette di moltiplicare due razionali e ottenerne un terzo
     * che appresenta il risultato finale.
     */
    public Razionale moltiplicazione(Razionale r) {
        int num = numeratore*r.numeratore;
        int den = denominatore*r.denominatore;
        
        Razionale prodotto = null;
        try {
            prodotto = new Razionale(num, den);
        } catch (DenominatoreNulloException ex) {
            LOGGER.log(Level.SEVERE, null, ex); // il catch non si verifica mai perché sicuramente il denominatore non sarà zero
        }
        
        return prodotto;
    }
    
    /**
     * 
     * @param r - il razionale da dividere a 'this'
     * @return il razionale che è la divisione tra i due
     * 
     * Metodo che permette di effettuare la divisione tra due razionali e
     * ottenerne un terzo che appresenta il risultato finale.
     * Il metodo lancia l'eccezione ArithmeticException ('Unchecked Exception')
     * se il razionale passato come parametro vale zero.
     */
    public Razionale divisione(Razionale r) {
        if(r.numeratore == 0)
            throw new ArithmeticException("Non posso dividere per zero");
        
        int num = numeratore*r.denominatore;
        int den = r.numeratore*denominatore;
        
        Razionale quoziente = null;
        try {
            quoziente = new Razionale(num, den);
        } catch (DenominatoreNulloException ex) {
            LOGGER.log(Level.SEVERE, null, ex); // il catch non si verifica mai perché sicuramente il denominatore non sarà zero
        }
        
        return quoziente;
    }
    
    /* Override del metodo finalize per testare il 'Garbage Collector' di Java.
    Il metodo decrementa la variabile 'count' se un oggetto instanziato
    per questa classe non è più referenziato e quindi soggetto a essere rimosso
    dalla memoria dal 'Garbage Collector', il quale chiama questo metodo prima
    di pulire effettivamente la memoria.
    */
    @Override
    protected void finalize() throws Throwable {
        try {
            count--;
        } finally {
            super.finalize();
        }
    }
    
    /**
     * 
     * @return il codice hash di un oggetto
     * 
     * Override del metodo per calcolare il codice hash di un oggetto di
     * tipo 'Razionale'.
     */
    @Override
    public int hashCode() {
        return Objects.hash(numeratore, denominatore);
    }
    
    /**
     * 
     * @param obj - l'oggetto da passare come parametro per confrontarlo con il 'this'
     * @return true se gli oggetti sono uguali, false altrimenti
     * 
     * Implementazione del metodo 'equals' per permettere il confronto tra due
     * oggetti di tipo 'Razionale'. Due oggetti di questo tipo saranno
     * uguali se il numeratore ed il denominatore sono uguali.
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
     * 
     * @return la stringa per rappresentare l'oggetto
     * 
     * Implementazione del metodo 'toString' che genera una stringa che
     * rappresenterà l'oggetto.
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
     * 
     * @param r - il razionale da comparare
     * @return un valore negativo se 'this' precede 'r', positivo se lo segue, il valore zero se sono uguali
     * 
     * Sovrascrittura del metodo presente nell'interfaccia 'Comparable' per
     * comparare due razionali in base al loro valore. un razionale precede un
     * altro se il suo valore è minore dell'altro. Se il valore è maggiore lo
     * segue.
     */
    @Override
    public int compareTo(Razionale r) {
        if(this == r)
            return 0;
        if(r == null)
            return 1;
        
        int mcd = mcd(denominatore, r.denominatore);
        int mcm = (denominatore*r.denominatore)/mcd;
        int n1 = (mcm/denominatore)*numeratore;
        int n2 = (mcm/r.denominatore)*r.numeratore;
        
        return n1-n2;
    }
    
    /**
     * 
     * @return il numero degli oggetti di tipo razionale creati
     * 
     * Metodo statico che ritorna il numero complessivo dei razionali creati.
     */
    public static int getCount() {
        return count;
    }
    
}
