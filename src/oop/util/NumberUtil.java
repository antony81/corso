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

/**
 *
 * @author Antonio
 * 
 * Classe di utilità che offre dei metodi per il calcolo di alcune funzioni
 * mateatiche.
 */
public class NumberUtil {
    
    private NumberUtil() {
    }
    
    public static long fattoriale(long numero) {
        if(numero == 1 || numero == 0)
            return 1;
        
        return numero * fattoriale(numero - 1);
    }
    
    public static BigInteger fattoriale(BigInteger numero) {
        if(numero.equals(BigInteger.ONE) || numero.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        
        return numero.multiply(fattoriale(numero.subtract(BigInteger.ONE)));
    }
    
}
