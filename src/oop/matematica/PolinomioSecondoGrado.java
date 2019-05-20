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
 * Classe che rappresenta un polinomio di secondo grado composto da monomi.
 * La classe gestisce al massimo tre monomi i quali non potranno superare
 * il grado 2 o non potranno essere di grado negativo.
 * La classe implementa l'interfaccia PolinomioRisolvibile che serve a
 * determinare se, l'equazione ottenuta supponendo di porre il polinomio uguale
 * a zero, esso è risolvibile.
 *
 * @author Antonio
 * @see Polinomio
 * @see PolinomioPrimoGrado
 * @see PolinomioRisolvibile
 */
public class PolinomioSecondoGrado extends Polinomio implements PolinomioRisolvibile {
    
    /**
     * Costruttore di default che inizializza un polinomio di secondo grado con
     * tre monomi. Usando poi il metodo 'add' di questa classe si potranno
     * aggiungere altri monomi.
     * Il polinomio sarà ordinato per monomi di grado più grande a monomi di
     * grado più picoolo.
     */
    PolinomioSecondoGrado() {
        super();
        
        espressione.put(2, new Monomio(new Razionale(), 2));
        espressione.put(1, new Monomio());
        espressione.put(0, new Monomio(new Razionale(), 0));
    }

    /**
     * Override del metodo 'add' che permette di aggiungere monomi ad un
     * polinomio. Se si passano monomi con grado uguale ad uno già presente,
     * questi verranno sommati.
     * Il grado dei monomi non può essere minore di 0 o maggiore di 2; tale
     * condizione solleva l'eccezione GradoErratoException.
     * 
     * @param m - il monomio da aggiungere al polinomio
     * @throws NullPointerException se 'm' è null
     * @throws GradoErratoException se i monomi hanno grado minore di 0 o maggiore di 2
     */
    @Override
    public void add(Monomio m) {
        if(m.getExp() < 0 || m.getExp() > 2)
            throw new GradoErratoException();
        
        super.add(m);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String soluzione() {
        StringBuilder builder = new StringBuilder();
        
        double a = ((double) espressione.get(2).getCoeff().getNumeratore())/((double) espressione.get(2).getCoeff().getDenominatore());
        double b = ((double) espressione.get(1).getCoeff().getNumeratore())/((double) espressione.get(1).getCoeff().getDenominatore());
        double c = ((double) espressione.get(0).getCoeff().getNumeratore())/((double) espressione.get(0).getCoeff().getDenominatore());
        
        if(Double.doubleToLongBits(a) == 0L) {
            double x = -1*c/b;
            builder.append("x = ").append(x);
        } else {
            double delta = Math.pow(b, 2)-4*a*c;
            if(delta < 0)
                builder.append("indeterminato");
            else if(delta > 0) {
                double x1 = (-b-Math.sqrt(delta))/(2*a);
                double x2 = (-b+Math.sqrt(delta))/(2*a);
                builder.append("x1 = ").append(x1);
                builder.append(", x2 = ").append(x2);
            } else {
                double x = -b/(2*a);
                builder.append("x1 = x2 = ").append(x);
            }
        }
        
        return builder.toString();
    }
    
}
