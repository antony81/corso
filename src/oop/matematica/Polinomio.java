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

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Classe che rappresenta un polinomio composto da monomi.
 * La classe fa uso di una TreeMap in cui inserire i monomi, ordinati in base
 * al loro esponente partendo dal più grande fino al più piccolo.
 *
 * @author Antonio
 * @see PolinomioPrimoGrado
 * @see PolinomioSecondoGrado
 */
public class Polinomio implements Cloneable {
    
    Map<Integer, Monomio> espressione; // variabile d'instanza
    int grado; // variabile d'instanza
    
    /**
     * Costruttore di default che inizializza un polinomio senza monomi. Usando
     * poi il metodo 'add' di questa classe si potranno aggiungere i monomi.
     * Il polinomio sarà ordinato per monomi di grado più grande a monomi di
     * grande più picoolo.
     */
    Polinomio() {
        espressione = new TreeMap<>((n1, n2) -> n2.compareTo(n1));
        grado = -1;
    }
    
    /**
     * Metodo che ritorna il grado del polinomio.ù
     * 
     * @return il grado del polinomio
     */
    public int grado() {
        return grado;
    }
    
    /**
     * Metodo che permette di aggiungere monomi ad un polinomio. Se si passano
     * monomi con grado uguale ad uno già presente, questi verranno sommati.
     * 
     * @param m - il monomio da aggiungere al polinomio
     * @throws NullPointerException se 'm' è null
     */
    public void add(Monomio m) {
        int exp = m.getExp();
        if(exp > grado)
            grado = exp;
        
        Monomio x = espressione.get(exp);
        espressione.put(exp, (x != null ? x.addizione(m) : x));
    }
    
    /**
     * Metodo che addiziona il polinomio 'p' a 'this'.
     * 
     * @param p - il polinomio da sommare
     */
    public void add(Polinomio p) {
        Collection<Monomio> values = p.espressione.values();
        values.forEach(this::add); // chiama il metodo add(Monomio m) di questa classe
    }

    /**
     * Metodo che ritorna una copia dell'istanza 'this' di Polinomio.
     * 
     * @return un clone dell'istanza 'this' di Polinomio
     */
    @Override
    public Polinomio clone() {
        Polinomio p = null;
        try {
            p = (Polinomio) super.clone();
            p.espressione.putAll(espressione);
        } catch (CloneNotSupportedException ex) {
            // l'eccezione non si verifica perché Razionale è di tipo Cloneable
            throw new InternalError(ex);
        }
        
        return p;
    }
    
    /**
     * Override del metodo 'hashCode' per calcolare il codice hash di un
     * oggetto di tipo Polinomio.
     * 
     * @return il codice hash di un oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(espressione);
    }
    
    /**
     * Implementazione del metodo 'equals' che confronta due oggetti di tipo
     * Polinomio. Due oggetti di questo tipo saranno uguali se sono composti
     * dallo stesso numero di monomi uguali tra loro.
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
        final Polinomio p = (Polinomio) obj;
        
        return espressione.equals(p.espressione);
    }
    
    /**
     * Implementazione del metodo 'toString' che genera una stringa che
     * rappresenterà l'oggetto.
     * 
     * @return la stringa per rappresentare l'oggetto
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Collection<Monomio> values = espressione.values();
        Iterator<Monomio> it = values.iterator();
        builder.append(it.next());
        while(it.hasNext()) {
            builder.append(' ');
            Monomio m = it.next();
            if(m.getCoeff().getNumeratore() >= 0)
                builder.append('+');
            builder.append(m);
        }
        
        return builder.toString();
    }
    
}
