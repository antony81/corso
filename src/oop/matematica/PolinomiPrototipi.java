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
 * Classe che sfrutta il design pattern prototype. La classe espone dei metodi
 * per la creazione di polinomi di diverso tipo. I polinomi sono inizialmente
 * dei cloni di un prototipo che può essere modificato aggiungendo nuovi monomi.
 *
 * @author Antonio
 * @see Polinomio
 * @see PolinomioPrimoGrado
 * @see PolinomioSecondoGrado
 * @see PolinomioRisolvibile
 */
public class PolinomiPrototipi {
    
    /**
     * Variabile statica che contiene dei prototipi di polinomio.
     */
    private static final Polinomio[] PROTOTYPES = new Polinomio[3];
    static {
        PROTOTYPES[0] = new Polinomio();
        PROTOTYPES[1] = new PolinomioPrimoGrado();
        PROTOTYPES[2] = new PolinomioSecondoGrado();
    }
    
    /**
     * Costruttore di default rivato che evita la creazione di oggetti di tipo
     * PolinomiPrototipi. Si dovranno usare i metodi pubblici statici per creare
     * dei polinomi.
     */
    private PolinomiPrototipi() {
    }
    
    /**
     * Metodo statico che crea un polinomio generico.
     * 
     * @return un oggetto prototipo di tipo Polinomio
     */
    public static Polinomio getPolinomio() {
        return PROTOTYPES[0].clone();
    }
    
    /**
     * Metodo statico che crea un polinomio di primo grado
     * 
     * @return un oggetto prototipo di tipo PolinomioPrimoGrado
     */
    public static PolinomioPrimoGrado getPolinomioPrimoGrado() {
        return (PolinomioPrimoGrado) PROTOTYPES[1].clone();
    }
    
    /**
     * Metodo statico che crea un polinomio di secondo grado
     * 
     * @return un oggetto prototipo di tipo PolinomioSecondoGrado
     */
    public static PolinomioSecondoGrado getPolinomioSecondoGrado() {
        return (PolinomioSecondoGrado) PROTOTYPES[2].clone();
    }
    
}
