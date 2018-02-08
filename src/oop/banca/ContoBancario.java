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
 * @author Antonio
 * 
 * Classe che rappresenta un conto bancario dato un numero di conto e un saldo.
 * La classe incapsula, infatti, la stringa 'numeroConto' e il double 'saldo'
 * che rappresenteranno lo stato interno degli oggetti che potranno essere
 * instanziati. La classe ha anche una varibile statica di tipo 'int' che
 * ha il compito di contare il numero di oggetti che verranno creati.
 * La classe implementa l'interfaccia 'Serializable' per consentire l'eventuale
 * serializzazione e deserializzazione.
 */
public class ContoBancario implements Serializable {
    
    private static final long serialVersionUID = -2886419301638293782L;
    
    protected String numeroConto; // variabile d'insatnza
    protected double saldo; // variabile d'insatnza
    
    private static int contiAttivi = 0; // variabile statica (sarà condivisa tra tutti gli oggetti di tipo ContoBancario)
    
    /**
     * 
     * @param numeroConto - il numero di conto
     * 
     * Metodo costruttore che inizializza la variabile d'istanza 'numeroConto'
     * con la stringa passata come parametro e la variabile d'istanza 'saldo'
     * a 0.0 come default. Da notare che il metodo richiama col 'this' l'altro
     * metodo costruttore.
     */
    public ContoBancario(String numeroConto) {
        this(numeroConto, 0.0);
    }
    
    /**
     * 
     * @param numeroConto - il numero di conto
     * @param saldo - il saldo iniziale del conto
     * 
     * Metodo costruttore pubblico che inizializza le variabili d'istanza
     * 'numeroConto' e 'saldo' con i valori contenuti nei parametri passati
     * al metodo. Inoltre viene incrementata la variabile statica 'contiAttivi'
     * che consente di tenere traccia del numero di conti che verranno
     * instanziati.
     */
    public ContoBancario(String numeroConto, double saldo) {
        this.numeroConto = numeroConto;
        this.saldo = saldo;
        
        contiAttivi++;
    }
    
    /**
     * 
     * @return il numero di conto
     * 
     * Metodo accessorio che consente di leggere il numero di conto.
     */
    public String getNumeroConto() {
        return numeroConto;
    }
    
    /**
     * 
     * @param numeroConto - il numero di conto
     * 
     * Metodo mutatore che permette di cambiare il numero di conto
     */
    public void setNumeroConto(String numeroConto) {
        this.numeroConto = numeroConto;
    }
    
    /**
     * 
     * @return il saldo del conto corrente
     * 
     * Metodo accessorio che consente di leggere il saldo del conto corrente.
     */
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * 
     * @return il numero di conti creati
     * 
     * Metodo statico che ritorna il numero dei conti creati.
     */
    public static int contiAttivi() {
        return contiAttivi;
    }
    
    /**
     * 
     * @param ammontare - la quantità di denaro da depositare sul conto corrente
     * 
     * Il metodo accetta un come parametro la somma da depositare sul
     * conto corrente.
     */
    public void deposita(double ammontare) {
        saldo += ammontare;
    }
    
    /**
     * 
     * @param ammontare - la quantità di denaro da prelevare sul conto corrente
     * @return true se è possibile prelvare, false altrimenti
     * 
     * Metodo che accetta come parametro una somma da prelevare e, se tale somma
     * non supera il saldo disponibile, il metodo aggiorna il saldo e ritorna
     * 'true' per segnalare che il prelievo è avvenuto con succcesso. Il metodo
     * ritorna 'false' se la somma da prelevare supera quella del saldo.
     */
    public boolean preleva(double ammontare) {
        if(ammontare > saldo)
            return false;
        
        saldo -= ammontare;
        
        return true;
    }
    
    /* Override del metodo finalize per testare il 'Garbage Collector' di Java.
    Il metodo decrementa la variabile 'contiAttivi' se un oggetto instanziato
    per questa classe non è più referenziato e quindi soggetto a essere rimosso
    dalla memoria dal 'Garbage Collector', il quale chiama questo metodo prima
    di pulire effettivamente la memoria.
    */
    @Override
    protected void finalize() throws Throwable {
        try {
            contiAttivi--;
        } finally {
            super.finalize();
        }
    }
    
    /**
     * 
     * @return il codice hash di un oggetto
     * 
     * Override del metodo per calcolare il codice hash di un oggetto di
     * tipo 'ContoBancario'.
     */
    @Override
    public int hashCode() {
        return Objects.hash(numeroConto);
    }
    
    /**
     * 
     * @param obj - l'oggetto da passare come parametro per confrontarlo con il 'this'
     * @return true se gli oggetti sono uguali, false altrimenti
     * 
     * Implementazione del metodo 'equals' per permettere il confronto tra due
     * oggetti di tipo 'ContoBancario'. Due oggetti di questo tipo saranno
     * uguali se il saldo è uguale.
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
        
        return Double.doubleToLongBits(saldo) == Double.doubleToLongBits(cb.saldo);
    }
    
    /**
     * 
     * @return la stringa per rappresentare l'oggetto
     * 
     * Implementazione del metodo 'toString' che genera una stringa che
     * rappresenterà l'oggetto. Per il saldo la stringa sarà formattata in modo
     * tale che abbia la parte decimale composta da sole due cifre decimali.
     * La classe DecimalFormat è utile per questo scopo.
     */
    @Override
    public String toString() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat format = new DecimalFormat("0.00", symbols);
        
        StringBuilder builder = new StringBuilder();
        builder.append("numero conto: ");
        builder.append(numeroConto);
        builder.append(", saldo: ");
        builder.append(format.format(saldo));
        
        return builder.toString();
    }
}
