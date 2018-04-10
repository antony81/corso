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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Objects;

/**
 * 
 * Classe che rappresenta un conto esteso il quale eredita il numero di
 * conto e il saldo e aggiunge il fido.
 * La classe incapsula, infatti, la stringa 'numeroConto' e il double 'saldo'
 * ereditate dalla super classe e inoltre incapsula la variabile fido.
 * Le tre variabili rappresenteranno lo stato interno degli oggetti che potranno
 * essere instanziati.
 * Questa classe eredita anche l'implementazione dell'interfaccia 'Serializable'
 * per consentire l'eventuale serializzazione e deserializzazione.
 *
 * @author Antonio
 */
public class ContoEsteso extends ContoBancario {
    
    private static final long serialVersionUID = 9171240682087241598L;
    
    private double fido; // variabile d'instanza
    
    /**
     * 
     * Metodo costruttore che richiama col this l'altro costruttore (quello che
     * accetta una stinga e un double).
     * 
     * @param numeroConto - il numero di conto
     */
    public ContoEsteso(String iban) {
        this(iban, 0.0);
    }
    
    /**
     * 
     * Metodo costruttore che richiama col this l'altro costruttore (quello che
     * accetta una stinga, un double e un double).
     * 
     * @param iban - il numero di conto
     * @param saldo - il saldo del conto
     */
    public ContoEsteso(String iban, double saldo) {
        this(iban, saldo, 1000.0);
    }
    
    /**
     * 
     * Metodo costruttore che richiama col super il costruttore della super
     * classe (quello che accetta una stinga e un double) e inizializza anche
     * il fido.
     * 
     * @param iban - il numero di conto
     * @param saldo - il saldo del conto
     * @param fido - il fido del conto
     */
    public ContoEsteso(String iban, double saldo, double fido) {
        super(iban, saldo);
        
        this.fido = fido;
    }
    
    /**
     * 
     * Metodo accessorio che consente di leggere il fido.
     * 
     * @return il fido del conto
     */
    public double getFido() {
        return fido;
    }
    
    /**
     * 
     * Metodo mutatore che permette di cambiare il fido del conto.
     * 
     * @param fido - il fido del conto
     */
    public void setFido(double fido) {
        this.fido = fido;
    }
    
    /**
     * 
     * Riscrittura del metodo preleva della super classe. La riscrittura di
     * questo metodo è necessaria perché bisogna tener conto ache del fido per
     * poter prelevare e, quindi, il metodo accetta come parametro una somma da
     * prelevare. Se tale somma non supera il saldo disponibile sommato al fido,
     * il metodo aggiorna il saldo e ritorna 'true' per segnalare che il
     * prelievo è avvenuto con succcesso; ritorna false in caso contrario.
     * 
     * @param ammontare - la quantità di denaro da prelevare sul conto corrente
     * @return true se è possibile prelvare, false altrimenti
     */
    @Override
    public boolean preleva(double ammontare) {
        if(ammontare < 0 || ammontare > (saldo+fido))
            return false;
        
        saldo -= ammontare;
        
        return true;
    }
    
    /**
     * 
     * Override del metodo per calcolare il codice hash di un oggetto di
     * tipo 'ContoEsteso'.
     * 
     * @return il codice hash di un oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(iban, saldo, fido);
    }
    
    /**
     * 
     * Implementazione del metodo 'equals' per permettere il confronto tra due
     * oggetti di tipo 'ContoEsteso'. Due oggetti di questo tipo saranno
     * uguali se il saldo e il fido sono uguali.
     * 
     * @param obj - l'oggetto da passare come parametro per confrontarlo con il 'this'
     * @return true se gli oggetti sono uguali, false altrimenti
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContoEsteso ce = (ContoEsteso) obj;
        
        return Double.doubleToLongBits(fido) == Double.doubleToLongBits(ce.fido);
    }
    
    /**
     * 
     * Implementazione del metodo 'toString' che genera una stringa che
     * rappresenterà l'oggetto. Per il saldo ed il fido la stringa sarà
     * formattata in modo tale che abbia la parte decimale composta da sole due
     * cifre decimali.
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
        builder.append(super.toString());
        builder.append(", fido: ");
        builder.append(format.format(fido));
        
        return builder.toString();
    }
}
