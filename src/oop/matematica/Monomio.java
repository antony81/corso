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

/**
 *
 * @author Antonio
 * 
 * Classe che rappresenta un Monomio nel quale il coefficiente sarà un oggetto
 * di tipo Razionale, mentre la parte letterale sarà identificata soltanto con
 * un esponente intero (assumiamo 'x' come lettera del monomio).
 */
public class Monomio implements Comparable<Monomio> {
    
    private Razionale coefficiente; // variabile d'instanza
    private int esponente; // variabile d'instanza
    
    private static int count = 0; // variabile statica utile a contare quanti monomi saranno creati

    /**
     * Costruttore di default che crea monomi con coefficiente zero ed esponente
     * uno.
     */
    public Monomio() {
        this(new Razionale(), 1);
    }

    /**
     * 
     * @param coefficiente - il razionale che rappresenta il coefficiente
     * @param esponente - l'intero che rappresenta l'esponente
     * 
     * Costruttore che crea un monomio a partire da un razionale ed un intero,
     * passati come parametri, che saranno rispettivamente il coefficiente e
     * l'esponente.
     */
    public Monomio(Razionale coefficiente, int esponente) {
        this.coefficiente = coefficiente;
        this.esponente = esponente;
    }
    
    /**
     * 
     * @param numeratore - il numeratore del coefficiente del monomio
     * @param denominatore - il denominatore del coefficiente del monomio
     * @param esponente - l'esponente del monomio
     * @throws DenominatoreNulloException - se il denominatore del coefficiente è uguale a zero
     */
    public Monomio(int numeratore, int denominatore, int esponente) throws DenominatoreNulloException {
        coefficiente = new Razionale(numeratore, denominatore);
        this.esponente = esponente;
    }

    /**
     * 
     * @return il coefficiente del monomio
     * 
     * Metodo accessorio per leggere il coefficiente di un monomio.
     */
    public Razionale getCoefficiente() {
        return coefficiente;
    }

    /**
     * 
     * @param coefficiente - il coefficiente del monomio
     * 
     * Metodo mutatore per cambiare il coefficiente ad un monomio
     */
    public void setCoefficiente(Razionale coefficiente) {
        this.coefficiente = coefficiente;
    }
    
    /**
     * 
     * @return l'esponente del monomio
     * 
     * Metodo accessorio per leggere l'esponente di un monomio.
     */
    public int getEsponente() {
        return esponente;
    }

    /**
     * 
     * @param esponente - l'esponente del monomio
     * 
     * Metodo mutatore per cambiare l'esponente ad un monomio
     */
    public void setEsponente(int esponente) {
        this.esponente = esponente;
    }
    
    /**
     * 
     * @param m - moonomio da sommare
     * @return un nuovo monomio che sarà la somma tra 'this' e 'm'
     * @throws OperazioneNonValida se gli esponenti non sono uguali
     * 
     * Metodo che permette di sommare due monomi se gli esponenti sono uguali
     * tra di loro.
     * Il metodo lancia l'eccezione OperazioneNonValida se gli esponenti non
     * sono uguali tra di loro.
     */
    public Monomio somma(Monomio m) throws OperazioneNonValida {
        if(esponente != m.esponente)
            throw new OperazioneNonValida();
        
        Razionale somma = coefficiente.addizione(m.coefficiente);
        
        return new Monomio(somma, esponente);
    }
    /**
     * 
     * @param m - moonomio da sottrarre
     * @return un nuovo monomio 'm' che sarà sottratto a 'this'
     * @throws OperazioneNonValida se gli esponenti non sono uguali
     * 
     * Metodo che permette di effettuare la sottrazione tra due monomi se gli
     * esponenti sono uguali tra di loro.
     * Il metodo lancia l'eccezione OperazioneNonValida se gli esponenti non
     * sono uguali tra di loro.
     */
    public Monomio differenza(Monomio m) throws OperazioneNonValida {
        if(esponente != m.esponente)
            throw new OperazioneNonValida();
        
        Razionale differenza = coefficiente.sottrazione(m.coefficiente);
        
        return new Monomio(differenza, esponente);
    }
    
    /**
     * 
     * @param m - moonomio da moltiplicare
     * @return un nuovo monomio che sarà il prodotto tra 'this' e 'm'
     * 
     * Metodo che permette di moltiplicare due monomi tra di loro.
     */
    public Monomio prodotto(Monomio m) {
        Razionale prodotto = coefficiente.moltiplicazione(m.coefficiente);
        int newEsp = esponente+m.esponente;
        
        return new Monomio(prodotto, newEsp);
    }
    
    /**
     * 
     * @param m - moonomio con cui effettuare la divisione
     * @return un nuovo monomio che sarà la divisione tra 'this' e 'm'
     * 
     * Metodo che permette di effettuare la divisione tra due monomi.
     */
    public Monomio divisione(Monomio m) {
        Razionale divisione = coefficiente.divisione(m.coefficiente);
        int newEsp = esponente-m.esponente;
        
        return new Monomio(divisione, newEsp);
    }

    /**
     * 
     * @return il codice hash di un oggetto
     * 
     * Override del metodo per calcolare il codice hash di un oggetto di
     * tipo 'Monomio'.
     */
    @Override
    public int hashCode() {
        return Objects.hash(coefficiente, esponente);
    }

    /**
     * 
     * @param obj - l'oggetto da passare come parametro per confrontarlo con il 'this'
     * @return true se gli oggetti sono uguali, false altrimenti
     * 
     * Implementazione del metodo 'equals' per permettere il confronto tra due
     * oggetti di tipo 'Monomio'. Due oggetti di questo tipo saranno
     * uguali se il coefficiente e l'esponente sono uguali.
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
        
        return (coefficiente.equals(m.coefficiente)) && (esponente == m.esponente);
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
        StringBuilder builder = new StringBuilder();
        
        if(coefficiente.getNumeratore() == 0)
            builder.append('0');
        else if(esponente == 0)
            builder.append(coefficiente);
        else if(esponente == 1)
            if(coefficiente.getNumeratore() == 1 && coefficiente.getDenominatore() == 1)
                builder.append('x');
            else
                builder.append(coefficiente).append('x');
        else
            if(coefficiente.getNumeratore() == 1 && coefficiente.getDenominatore() == 1)
                builder.append("x^").append(esponente);
            else
                builder.append(coefficiente).append("x^").append(esponente);
        
        return builder.toString();
    }

    /**
     * 
     * @param m - il monomio da comparare
     * @return un valore negativo se 'this' precede 'm', positivo se lo segue, il valore zero se sono uguali
     * 
     * Sovrascrittura del metodo presente nell'interfaccia 'Comparable' per
     * comparare due monomi in base al loro valore. un monomio precede un
     * altro se il valore dell'esponente è minore dell'altro. Se, invece, il
     * valore dell'esponente è maggiore lo segue.
     */
    @Override
    public int compareTo(Monomio m) {
        if(this == m)
            return 0;
        if(m == null)
            return 1;
        
        return m.esponente-esponente;
    }

    public static int getCount() {
        return count;
    }
    
}
