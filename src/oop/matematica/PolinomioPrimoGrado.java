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
package oop.matematica;

/**
 * Classe che rappresenta un polinomio di primo grado composto da monomi.
 * La classe gestisce al massimo due monomi i quali non potranno superare
 * il grado 1 o non potranno essere di grado negativo.
 * La classe implementa l'interfaccia PolinomioRisolvibile che serve a
 * determinare se, l'equazione ottenuta supponendo di porre il polinomio uguale
 * a zero, esso è risolvibile.
 *
 * @author Antonio
 * @see Polinomio
 * @see PolinomioSecondoGrado
 * @see PolinomioRisolvibile
 */
public class PolinomioPrimoGrado extends Polinomio implements PolinomioRisolvibile {

    /**
     * Costruttore di default che inizializza un polinomio di primo grado con
     * due monomi. Usando poi il metodo 'add' di questa classe si potranno
     * aggiungere altri monomi.
     * Il polinomio sarà ordinato per monomi di grado più grande a monomi di
     * grado più picoolo.
     */
    PolinomioPrimoGrado() {
        super();
        
        espressione.put(1, new Monomio());
        espressione.put(0, new Monomio(new Razionale(), 0));
    }
    
    /**
     * Override del metodo 'add' che permette di aggiungere monomi ad un
     * polinomio. Se si passano monomi con grado uguale ad uno già presente,
     * questi verranno sommati.
     * Il grado dei monomi non può essere minore di 0 o maggiore di 1; tale
     * condizione solleva l'eccezione GradoErratoException.
     * 
     * @param m - il monomio da aggiungere al polinomio
     * @throws NullPointerException se 'm' è null
     * @throws GradoErratoException se i monomi hanno grado minore di 0 o maggiore di 1
     */
    @Override
    public void add(Monomio m) {
        if(m.getExp() < 0 || m.getExp() > 1)
            throw new GradoErratoException();
        
        super.add(m);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String soluzione() {
        StringBuilder builder = new StringBuilder();
        
        double a = ((double) espressione.get(1).getCoeff().getNumeratore())/((double) espressione.get(1).getCoeff().getDenominatore());
        double b = ((double) espressione.get(0).getCoeff().getNumeratore())/((double) espressione.get(0).getCoeff().getDenominatore());
        
        if(Double.doubleToLongBits(a) == 0L)
            if(Double.doubleToLongBits(b) == 0L)
                builder.append("indeterminato");
            else
                builder.append("impossibile");
        else {
            double x = -1*b/a;
            builder.append("x = ").append(x);
        }
        
        return builder.toString();
    }
    
}
