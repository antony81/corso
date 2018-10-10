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
package oop.main;

import java.math.BigInteger;
import oop.util.NumberUtil;

/**
 *
 * @author Antonio
 */
public class TestNumberUtil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigInteger numero = BigInteger.valueOf(50);
        System.out.println("fattoriale di " + numero + " = " + NumberUtil.fattoriale(numero));
        System.out.println("**************************************************************");
        BigInteger count = BigInteger.valueOf(20);
        System.out.println("fibonacci di " + count + " = " + NumberUtil.fibonacci(count));
    }
    
}
