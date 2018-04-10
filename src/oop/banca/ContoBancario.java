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
package oop.banca;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Objects;

/**
 * 
 * Classe che rappresenta un conto bancario dato un numero di conto e un saldo.
 * La classe incapsula, infatti, la stringa 'numeroConto' e il double 'saldo'
 * che rappresenteranno lo stato interno degli oggetti che potranno essere
 * instanziati. La classe ha anche una varibile statica di tipo 'int' che
 * ha il compito di contare il numero di oggetti che verranno creati.
 * La classe implementa l'interfaccia 'Serializable' per consentire l'eventuale
 * serializzazione e deserializzazione.
 *
 * @author Antonio
 */
public class ContoBancario implements Serializable {
    
    private static final long serialVersionUID = -2886419301638293782L;
    
    protected String iban; // variabile d'instanza
    protected double saldo; // variabile d'instanza
    
    private static int count = 0; // variabile statica (sarà condivisa tra tutti gli oggetti di tipo ContoBancario)
    
    /**
     * 
     * Metodo costruttore che inizializza la variabile d'istanza 'iban' con la
     * stringa passata come parametro e la variabile d'istanza 'saldo' a 2000.0
     * come default. Da notare che il metodo richiama col 'this' l'altro
     * metodo costruttore.
     * 
     * @param iban - il numero di conto
     */
    public ContoBancario(String iban) {
        this(iban, 0.0);
    }
    
    /**
     * 
     * Metodo costruttore pubblico che inizializza le variabili d'istanza
     * 'iban' e 'saldo' con i valori contenuti nei parametri passati al metodo.
     * Inoltre viene incrementata la variabile statica 'count' che consente di
     * tenere traccia del numero di conti che verranno instanziati.
     * 
     * @param iban - il numero di conto
     * @param saldo - il saldo iniziale del conto
     */
    public ContoBancario(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
        
        count++;
    }
    
    /**
     * 
     * Metodo accessorio che consente di leggere il numero di conto.
     * 
     * @return il numero di conto
     */
    public String getIban() {
        return iban;
    }
    
    /**
     * 
     * Metodo mutatore che permette di cambiare il numero di conto
     * 
     * @param iban - il numero di conto
     */
    public void setIban(String iban) {
        this.iban = iban;
    }
    
    /**
     * 
     * Metodo accessorio che consente di leggere il saldo del conto corrente.
     * 
     * @return il saldo del conto corrente
     */
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * 
     * Metodo statico che ritorna il numero dei conti creati.
     * 
     * @return il numero di conti creati
     */
    public static int count() {
        return count;
    }
    
    /**
     * 
     * Il metodo accetta un come parametro la somma da depositare sul
     * conto corrente. Se l'ammontare è negativo il metodo restituisce false,
     * perché non è possibile depositare una somma negativa.
     * 
     * @param ammontare - la quantità di denaro da depositare sul conto corrente
     * @return true se è stato possibile depositare, false altrimenti
     */
    public boolean deposita(double ammontare) {
        if(ammontare < 0)
            return false;
        
        saldo += ammontare;
        
        return true;
    }
    
    /**
     * 
     * Metodo che accetta come parametro una somma da prelevare e, se tale somma
     * non supera il saldo disponibile, il metodo aggiorna il saldo e ritorna
     * 'true' per segnalare che il prelievo è avvenuto con succcesso. Il metodo
     * ritorna 'false' se la somma da prelevare supera quella del saldo.
     * 
     * @param ammontare - la quantità di denaro da prelevare sul conto corrente
     * @return true se è possibile prelvare, false altrimenti
     */
    public boolean preleva(double ammontare) {
        if(ammontare < 0 || ammontare > saldo)
            return false;
        
        saldo -= ammontare;
        
        return true;
    }
    
    /* Override del metodo finalize per testare il 'Garbage Collector' di Java.
    Il metodo decrementa la variabile 'count' se un oggetto instanziato per
    questa classe non è più referenziato e quindi soggetto a essere rimosso
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
     * Override del metodo per calcolare il codice hash di un oggetto di
     * tipo 'ContoBancario'.
     * 
     * @return il codice hash di un oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(iban, saldo);
    }
    
    /**
     * 
     * Implementazione del metodo 'equals' per permettere il confronto tra due
     * oggetti di tipo 'ContoBancario'. Due oggetti di questo tipo saranno
     * uguali se l'iban ed il saldo sono uguali.
     * 
     * @param obj - l'oggetto da passare come parametro per confrontarlo con il 'this'
     * @return true se gli oggetti sono uguali, false altrimenti
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContoBancario cb = (ContoBancario) obj;
        
        return iban.equals(cb.iban) && Double.doubleToLongBits(saldo) == Double.doubleToLongBits(cb.saldo);
    }
    
    /**
     * 
     * Implementazione del metodo 'toString' che genera una stringa che
     * rappresenterà l'oggetto. Per il saldo la stringa sarà formattata in modo
     * tale che abbia la parte decimale composta da sole due cifre decimali.
     * La classe DecimalFormat è utile per questo scopo.
     * 
     * @return la stringa per rappresentare l'oggetto
     */
    @Override
    public String toString() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat format = new DecimalFormat("0.00", symbols);
        
        StringBuilder builder = new StringBuilder();
        builder.append("iban: ");
        builder.append(iban);
        builder.append(", saldo: ");
        builder.append(format.format(saldo));
        
        return builder.toString();
    }
}
