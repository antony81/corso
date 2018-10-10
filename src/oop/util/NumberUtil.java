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
package oop.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe di utilità che offre dei metodi per il calcolo di alcune funzioni
 * matematiche.
 *
 * @author Antonio
 */
public final class NumberUtil {
    
    /*
     * Costruttore privato che evita la creazione di oggetti di tipo
     * NumberUtil.
     */
    private NumberUtil() {
    }
    
    /**
     * Metodo che calcola la successione di Fibonacci dato in input la quantità
     * di numeri da calcolare. Il metodo usa il tipo <code>BigInteger</code>
     * per il calcolo e sfrutta la ricorsione.
     *
     * @param count - la quantità di numeri da calcolare
     * @return una lista parametrizzata a <code>BigInteger</code> che contiene la serie
     */
    public static List<BigInteger> fibonacci(BigInteger count) {
        List<BigInteger> list = new ArrayList<>();
        BigInteger n1 = BigInteger.ZERO; // primo valore della serie
        BigInteger n2 = BigInteger.ONE; // secondo valore della serie
        list.add(n1);
        list.add(n2);
        BigInteger two = BigInteger.valueOf(2);
        
        if(!(count.equals(BigInteger.ZERO) || count.equals(BigInteger.ONE) || count.equals(two)))
            fib(n1, n2, count.subtract(two), list);
        
        return list;
    }

    /**
     * Metodo privato a supporto del metodo pubblico fibonacci
     */
    private static void fib(BigInteger n1, BigInteger n2, BigInteger count, List<BigInteger> list) {
        if(count.compareTo(BigInteger.ZERO) > 0) {
            BigInteger n3 = n1.add(n2);
            n1 = n2;
            n2 = n3;
            list.add(n3);
            fib(n1, n2, count.subtract(BigInteger.ONE), list);
        }
    }
    
    /**
     * Metodo che calcola il fattoriale di un numero di tipo <code>long</code>.
     * Il metodo, usando un <code>long</code>, è limitato fino ad un certo
     * valore. Per superare questo limite si può usare il metodo fattoriale
     * in overloading che accetta come argomento un <code>BigInteger</code>.
     * Il metodo usa la ricorsione.
     * 
     * @param numero - il numero su cui calcolare il fattoriale
     * @return il valore calcolato del fattoriale
     */
    public static long fattoriale(long numero) {
        if(numero == 1 || numero == 0)
            return 1;
        
        return numero * fattoriale(numero - 1);
    }
    
    /**
     * Metodo che calcola il fattoriale di un numero di
     * tipo <code>BigInteger</code>.
     * Il metodo usa la ricorsione.
     * 
     * @param numero - il numero su cui calcolare il fattoriale
     * @return il valore calcolato del fattoriale
     */
    public static BigInteger fattoriale(BigInteger numero) {
        if(numero.equals(BigInteger.ONE) || numero.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        
        return numero.multiply(fattoriale(numero.subtract(BigInteger.ONE)));
    }
    
    /**
     * Metodo che calcola, sfruttando l'algoritmo di Euclide, il massimo comun
     * divisore a partire dai dati passati come argomenti.
     * Il metodo usa la ricorsione.
     * 
     * @param x - il primo numero
     * @param y - il secondo numero
     * @return il massimo comun divisore calcolato
     */
    public static int massimoComunDivisore(int x, int y) {
        return mcd(Math.abs(x), Math.abs(y));
    }
    
    /**
     * Metodo privato a supporto del metodo pubblico massimoComunDivisore
     */
    private static int mcd(int x, int y) {
        if(y == 0)
            return x;
        
        return mcd(y, x%y);
    }
    
}
