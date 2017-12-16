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
 */
public class Monomio implements Comparable<Monomio> {
    
    private Razionale coefficiente;
    private int esponente;
    
    private static int count = 0;

    public Monomio() {
        this(new Razionale(), 1);
    }

    public Monomio(Razionale coefficiente, int esponente) {
        this.coefficiente = coefficiente;
        this.esponente = esponente;
    }
    
    public Monomio(int numeratore, int denominatore, int esponente) throws DenominatoreNulloException {
        coefficiente = new Razionale(numeratore, denominatore);
        this.esponente = esponente;
    }

    public Razionale getCoefficiente() {
        return coefficiente;
    }

    public int getEsponente() {
        return esponente;
    }
    
    public Monomio somma(Monomio m) throws OperazioneNonValida {
        if(esponente != m.esponente)
            throw new OperazioneNonValida();
        
        Razionale somma = coefficiente.addizione(m.coefficiente);
        
        return new Monomio(somma, esponente);
    }
    
    public Monomio differenza(Monomio m) throws OperazioneNonValida {
        if(esponente != m.esponente)
            throw new OperazioneNonValida();
        
        Razionale differenza = coefficiente.sottrazione(m.coefficiente);
        
        return new Monomio(differenza, esponente);
    }
    
    public Monomio prodotto(Monomio m) {
        Razionale prodotto = coefficiente.moltiplicazione(m.coefficiente);
        int newEsp = esponente+m.esponente;
        
        return new Monomio(prodotto, newEsp);
    }
    
    public Monomio divisione(Monomio m) {
        Razionale divisione = coefficiente.divisione(m.coefficiente);
        int newEsp = esponente-m.esponente;
        
        return new Monomio(divisione, newEsp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coefficiente, esponente);
    }

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
