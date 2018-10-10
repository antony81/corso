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
import java.util.List;

/**
 *
 * @author Antonio
 */
public class StringUtil {
    
    private StringUtil() {
    }
    
    public static List<String> permuta(String s) {
        List<String> list = new ArrayList<>();
        generaPermutazioni(s, NumberUtil.fattoriale(BigInteger.valueOf(s.length())), list);
        
        return list;
    }

    private static void generaPermutazioni(String s, BigInteger numPermutazioni, List<String> list) {
        if(numPermutazioni.compareTo(BigInteger.valueOf(list.size())) > 0) {
            char[] characters = s.toCharArray();
            int scambi = characters.length - 1;
            for(int i = 0; i < scambi; i++) {
                char tmp = characters[i];
                characters[i] = characters[i+1];
                characters[i+1] = tmp;
                s = String.valueOf(characters);
                list.add(s);
            }
            generaPermutazioni(s, numPermutazioni, list);
        }
    }
    
}
